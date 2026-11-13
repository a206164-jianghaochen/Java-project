package smtpAndPop3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * A minimal SMTP client (RFC 5321) for the network-programming lab.
 *
 * <p>The console dialogue and the SMTP command sequence are unchanged from the
 * original version. What is different is the plumbing: explicit connect/read
 * timeouts, RFC-compliant CRLF line endings, UTF-8 console input, null-safe
 * shutdown, and a dedicated {@link SmtpException} instead of a bare
 * {@code Exception}. Written against Java 17.
 */
public class SMTPClient {

    /** Default port of the local SMTP sink used in the lab (Papercut / MailHog style). */
    private static final int DEFAULT_PORT = 1025;
    private static final String DEFAULT_HOST = "localhost";

    /** Do not hang forever when the server is unreachable or silent. */
    private static final int CONNECT_TIMEOUT_MS = 10_000;
    private static final int READ_TIMEOUT_MS = 30_000;

    /** The only line ending SMTP accepts (RFC 5321 section 2.3.8). */
    private static final String CRLF = "\r\n";

    private String hostname = DEFAULT_HOST;
    private int port = DEFAULT_PORT;
    private String from = "";
    private String to = "";
    private String subject = "";
    private String body = "";

    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;

    public static void main(String[] args) {
        new SMTPClient();
    }

    public SMTPClient() {
        try {
            getInput();
            sendEmail();
        } catch (Exception e) {
            System.out.println("Error sending message - " + e);
        }
    }

    /** Reads hostname, addresses, subject and body from standard input. */
    protected void getInput() throws IOException {
        var console = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        System.out.print("Please enter SMTP server hostname: ");
        String host = console.readLine();
        if (host != null && !host.isBlank()) {
            hostname = host.trim();
        }

        System.out.print("Please enter FROM email address: ");
        from = Objects.requireNonNullElse(console.readLine(), "");

        System.out.print("Please enter TO email address: ");
        String recipient = console.readLine();
        if (recipient != null && !recipient.isBlank()) {
            to = recipient.trim();
        }

        System.out.print("Please enter subject: ");
        subject = Objects.requireNonNullElse(console.readLine(), "");

        System.out.println("Please enter plain-text message ('.' character on a blank line signals end of message):");
        var buffer = new StringBuilder();
        for (String line = console.readLine(); line != null; line = console.readLine()) {
            if (line.equalsIgnoreCase(".")) {
                break;
            }
            buffer.append(line).append(CRLF);
        }
        buffer.append(CRLF);
        body = buffer.toString();
    }

    /**
     * Reads one complete server reply and returns its numeric status code.
     *
     * <p>A reply may span several lines (RFC 5321 section 4.2.1): every
     * continuation line starts with {@code 250-}, and the final line starts
     * with {@code 250 } followed by a space. All lines are consumed here so the
     * next command starts on a clean line.
     */
    protected int readResponseCode() throws IOException, SmtpException {
        String line = br.readLine();
        if (line == null) {
            throw new SmtpException("Connection closed before a reply was received");
        }
        System.out.println("< " + line);

        int code = parseCode(line);

        while (line.length() > 3 && line.charAt(3) == '-') {
            line = br.readLine();
            if (line == null) {
                throw new SmtpException("Connection closed in the middle of a reply");
            }
            System.out.println("< " + line);
        }
        return code;
    }

    /** Extracts the three-digit status code from a reply line. */
    private static int parseCode(String line) throws SmtpException {
        String codeText = line.length() >= 3 ? line.substring(0, 3) : line;
        try {
            return Integer.parseInt(codeText);
        } catch (NumberFormatException e) {
            throw new SmtpException("Malformed server reply: " + line);
        }
    }

    /** Sends one command line and echoes it to the console. */
    protected void writeMsg(String msg) {
        pw.print(msg);
        pw.print(CRLF);
        pw.flush();
        System.out.println("> " + msg);
    }

    /** Ends the session gracefully: QUIT, read the reply, close the socket. */
    protected void sendQuit() throws IOException, SmtpException {
        System.out.println("Sending QUIT");
        writeMsg("QUIT");
        readResponseCode();
        System.out.println("Closing Connection");
        closeConnection();
    }

    /** Closes everything that may or may not have been opened. Safe to call twice. */
    protected void closeConnection() {
        try {
            if (pw != null) {
                pw.flush();
                pw.close();
            }
            if (br != null) {
                br.close();
            }
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException ignored) {
            // Nothing useful can be done while tearing the connection down.
        }
    }

    /** Runs the full SMTP transaction: greeting, HELO, MAIL, RCPT, DATA, QUIT. */
    protected void sendEmail() throws IOException, SmtpException {
        System.out.println("Sending message now: Debug below");
        System.out.println(" ");

        System.out.println("Opening Socket");
        socket = new Socket();
        socket.connect(new InetSocketAddress(hostname, port), CONNECT_TIMEOUT_MS);
        socket.setSoTimeout(READ_TIMEOUT_MS);

        System.out.println("Creating Reader & Writer");
        br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.US_ASCII));
        pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.US_ASCII));

        try {
            System.out.println("Reading first line");
            expectCode(readResponseCode(), 220, "Invalid SMTP Server", false);

            System.out.println("Sending helo command");
            writeMsg("HELO " + InetAddress.getLocalHost().getHostName());
            expectCode(readResponseCode(), 250, "Invalid SMTP Server", true);

            System.out.println("Sending mail from command");
            writeMsg("MAIL FROM: <" + from + ">");
            expectCode(readResponseCode(), 250, "Invalid from address", true);

            System.out.println("Sending rcpt to command");
            writeMsg("RCPT TO: <" + to + ">");
            expectCode(readResponseCode(), 250, "Invalid to address", true);

            System.out.println("Sending data command");
            writeMsg("DATA");
            expectCode(readResponseCode(), 354, "Data entry not accepted", true);

            System.out.println("Sending message");
            writeMsg("Subject: " + subject);
            writeMsg("To: " + to);
            writeMsg("From: " + from);
            writeMsg("");
            writeMsg(body);
            writeMsg(".");

            int code = readResponseCode();
            sendQuit();
            if (code != 250) {
                throw new SmtpException("Message may not have been sent correctly");
            }
            System.out.println("Message sent");
        } finally {
            closeConnection();
        }
    }

    /**
     * Fails the transaction when the server answers with an unexpected code,
     * mirroring the original control flow (QUIT first, then throw).
     */
    private void expectCode(int actual, int expected, String message, boolean quitFirst)
            throws IOException, SmtpException {
        if (actual == expected) {
            return;
        }
        if (quitFirst) {
            try {
                sendQuit();
            } catch (Exception ignored) {
                // The original code let this propagate, but a dead connection is
                // not what the caller needs to hear about.
            }
        }
        throw new SmtpException(message);
    }

    /** Signalled when the server answers with an unexpected status code. */
    public static final class SmtpException extends Exception {
        private static final long serialVersionUID = 1L;

        public SmtpException(String message) {
            super(message);
        }
    }
}
