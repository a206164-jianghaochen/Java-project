package smtpAndPop3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * A minimal POP3 client (RFC 1939) for the network-programming lab.
 *
 * <p>The console dialogue, the command order (USER, PASS, STAT, RETR 1, QUIT)
 * and the printed mail body are unchanged from the original version. The
 * differences are the plumbing: explicit connect/read timeouts, RFC-compliant
 * CRLF line endings, UTF-8 console input, null-safe shutdown, and a dedicated
 * {@link Pop3Exception}. Written against Java 17.
 */
public class POP3Client {

    /** Standard POP3 port used by the lab's local mail sink. */
    private static final int DEFAULT_PORT = 110;
    private static final String DEFAULT_HOST = "localhost";

    /** Do not hang forever when the server is unreachable or silent. */
    private static final int CONNECT_TIMEOUT_MS = 10_000;
    private static final int READ_TIMEOUT_MS = 30_000;

    /** The only line ending POP3 accepts (RFC 1939 section 3). */
    private static final String CRLF = "\r\n";

    private String hostname = DEFAULT_HOST;
    private int port = DEFAULT_PORT;
    private String username = "";
    private String password = "";

    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;

    public static void main(String[] args) {
        new POP3Client();
    }

    public POP3Client() {
        try {
            getInput();
            fetchMail();
        } catch (Exception e) {
            System.out.println("Error receiving message - " + e);
        }
    }

    /** Reads hostname, username and password from standard input. */
    protected void getInput() throws IOException {
        var console = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

        System.out.print("Please enter POP3 server hostname: ");
        String host = console.readLine();
        if (host != null && !host.isBlank()) {
            hostname = host.trim();
        }

        System.out.print("Please enter Username: ");
        username = Objects.requireNonNullElse(console.readLine(), "");

        System.out.print("Please enter Password: ");
        password = Objects.requireNonNullElse(console.readLine(), "");
    }

    /** Reads one status line and echoes it to the console. */
    protected String readResponse() throws IOException, Pop3Exception {
        String line = br.readLine();
        if (line == null) {
            throw new Pop3Exception("Connection closed before a reply was received");
        }
        System.out.println("< " + line);
        return line;
    }

    /** Sends one command line and echoes it to the console. */
    protected void writeMsg(String msg) {
        pw.print(msg);
        pw.print(CRLF);
        pw.flush();
        System.out.println("> " + msg);
    }

    /** Ends the session gracefully: QUIT, read the reply, close the socket. */
    protected void sendQuit() throws IOException, Pop3Exception {
        System.out.println("Sending QUIT");
        writeMsg("QUIT");
        readResponse();
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

    /** Connects, authenticates, prints the first message and quits. */
    protected void fetchMail() throws IOException, Pop3Exception {
        System.out.println("Opening Socket to POP3 server...");
        socket = new Socket();
        socket.connect(new InetSocketAddress(hostname, port), CONNECT_TIMEOUT_MS);
        socket.setSoTimeout(READ_TIMEOUT_MS);

        br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.US_ASCII));
        pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.US_ASCII));

        try {
            expectOk(readResponse(), "Invalid POP3 Server", false);

            writeMsg("USER " + username);
            expectOk(readResponse(), "Invalid Username", true);

            writeMsg("PASS " + password);
            expectOk(readResponse(), "Invalid Password", true);

            writeMsg("STAT");
            readResponse();

            System.out.println("Fetching first message...");
            writeMsg("RETR 1");
            String status = readResponse();

            if (status.startsWith("+OK")) {
                System.out.println("--- EMAIL CONTENT START ---");
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    if (line.equals(".")) {
                        break;
                    }
                    System.out.println(line);
                }
                System.out.println("--- EMAIL CONTENT END ---");
            }

            sendQuit();
        } finally {
            closeConnection();
        }
    }

    /**
     * Fails the session when the server answers with an error status,
     * mirroring the original control flow (QUIT first, then throw).
     */
    private void expectOk(String response, String message, boolean quitFirst) throws IOException, Pop3Exception {
        if (response.startsWith("+OK")) {
            return;
        }
        if (quitFirst) {
            try {
                sendQuit();
            } catch (Exception ignored) {
                // The connection is already failing; report the useful error only.
            }
        }
        throw new Pop3Exception(message);
    }

    /** Signalled when the server answers with an error status. */
    public static final class Pop3Exception extends Exception {
        private static final long serialVersionUID = 1L;

        public Pop3Exception(String message) {
            super(message);
        }
    }
}
