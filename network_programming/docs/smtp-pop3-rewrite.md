# SMTP / POP3 Client — Java 17 Rewrite

Rewritten from the original lab implementation. The wire protocol, the console
dialogue and the command order are unchanged; what changed is the implementation
style and the connection plumbing.

## Files

| Path | Role |
| --- | --- |
| `src/smtpAndPop3/SMTPClient.java` | SMTP client (current) |
| `src/smtpAndPop3/POP3Client.java` | POP3 client (current) |
| `legacy/SMTPClient.original.java.txt` | Original SMTP client, kept for comparison |
| `legacy/POP3Client.original.java.txt` | Original POP3 client, kept for comparison |

The `legacy/` copies use a `.java.txt` suffix on purpose: they hold the same
package and class names as the current files, so if they were plain `.java`
files under `src/` the project would fail to compile with duplicate classes.

## What changed

| Area | Before | After | Why |
| --- | --- | --- | --- |
| Local variables | Explicit types everywhere | `var` where the type is obvious from the right-hand side | Less noise, easier to read |
| String building | `StringBuffer` | `StringBuilder` | `StringBuffer` is synchronised; not needed on a local buffer |
| Console input | `readLine()` checked ad hoc | `Objects.requireNonNullElse`, `String.isBlank()` | Null-safe, and whitespace-only input is treated as empty |
| Charset | Platform default | `StandardCharsets.UTF_8` for the console, `US_ASCII` for the protocol | Same behaviour on every machine, not just Windows |
| Line endings | `PrintWriter.println()` | Explicit `CRLF` constant | RFC 5321 / RFC 1939 require CRLF; `println()` follows the OS |
| Connect | `new Socket(host, port)` | `connect(InetSocketAddress, 10 s)` plus `setSoTimeout(30 s)` | No infinite hang on an unreachable or silent server |
| SMTP replies | One `readLine()` | Continuation lines (`250-`) are consumed until the final `250 ` line | Multi-line replies no longer break the parser |
| Errors | Bare `Exception` | `SmtpException` / `Pop3Exception` | Callers can distinguish protocol failures from I/O failures |
| Shutdown | Three unchecked `close()` calls | Null-safe, idempotent, close errors swallowed | Cleanup after a failed connect no longer throws or NPEs |
| Resource handling | Manual close at the end | `try/finally` around the whole transaction | The socket is closed even when a step fails |

## Bug fixed

`readResponseCode()` used

```java
line = line.substring(0, line.indexOf(" "));
return Integer.parseInt(line);
```

so a multi-line reply such as

```
250-mail.example.com greets you
250 8BITMIME
```

produced the string `250-mail.example.com`, and `Integer.parseInt` threw
`NumberFormatException` — the session died on a perfectly valid server reply.
The rewrite reads the continuation lines, parses the three-digit code from the
first line, and returns it.

## Behaviour kept identical

- Same class names, package and `public static void main`.
- Same console prompts, in the same order.
- Same SMTP sequence: greeting → `HELO` → `MAIL FROM` → `RCPT TO` → `DATA` →
  message → `.` → `QUIT`.
- Same POP3 sequence: greeting → `USER` → `PASS` → `STAT` → `RETR 1` → `QUIT`.
- Same debug echo: `>` for commands sent, `<` for replies received.

## Verification

- `javac -Xlint:all` compiles cleanly on JDK 17.
- Both clients were exercised against local fake SMTP and POP3 servers; the
  captured transcripts matched the expected command flow, and the message body
  arrived with correct headers, blank line and terminating dot.

## Running

```bash
javac -d out src/smtpAndPop3/SMTPClient.java src/smtpAndPop3/POP3Client.java
java -cp out smtpAndPop3.SMTPClient
java -cp out smtpAndPop3.POP3Client
```

The SMTP client defaults to `localhost:1025`; the POP3 client to `localhost:110`
(port 110 needs administrator rights to bind locally).
