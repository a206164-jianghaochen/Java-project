# Network Programming

Java exercises from my network programming course at UKM. Everything here talks
to the wire directly — sockets, streams and protocol command flows, no
third-party client libraries.

## `smtpAndPop3` — the part worth reading

| File | Role |
| --- | --- |
| `src/smtpAndPop3/SMTPClient.java` | SMTP client, RFC 5321 |
| `src/smtpAndPop3/POP3Client.java` | POP3 client, RFC 1939 |
| `legacy/*.original.java.txt` | The first version, kept for comparison |
| `docs/smtp-pop3-rewrite.md` | What changed in the rewrite and why |

Both clients drive a full session by hand:

- **SMTP** — greeting → `HELO` → `MAIL FROM` → `RCPT TO` → `DATA` → message body →
  `.` → `QUIT`
- **POP3** — greeting → `USER` → `PASS` → `STAT` → `RETR 1` → print the message →
  `QUIT`

The rewrite is Java 17: `var` where it helps, explicit CRLF instead of
`println()` (SMTP and POP3 both require `\r\n` regardless of the host OS),
connect/read timeouts, a null-safe shutdown, and dedicated `SmtpException` /
`Pop3Exception` types.

It also fixed a genuine bug. The original parsed a reply with

```java
line.substring(0, line.indexOf(" "))
```

which turns a valid multi-line reply

```
250-mail.example.com greets you
250 8BITMIME
```

into `250-mail.example.com`, so `Integer.parseInt` threw. The rewrite consumes
the `250-` continuation lines and parses the code from the first line.

## Running

```bash
javac -d out src/smtpAndPop3/SMTPClient.java src/smtpAndPop3/POP3Client.java
java -cp out smtpAndPop3.SMTPClient      # defaults to localhost:1025
java -cp out smtpAndPop3.POP3Client      # defaults to localhost:110
```

You need a local mail sink to test against — Papercut, MailHog or Mailpit on
port 1025 all work for SMTP. Port 110 is privileged, so on Windows the POP3
client needs an elevated shell or a local server bound to a higher port.

## Other packages

| Package | Content |
| --- | --- |
| `tcp` | TCP client / server pair |
| `udp` | UDP client / server pair |
| `iostream` | Stream readers, grade averaging |
| `dataStream`, `dataInputStream` | `DataInputStream` / `DataOutputStream` |
| `objectIOStream` | Object serialisation |
| `fileOutputStream` | Writing files through an output stream |
| `bufferedReader*` | Buffered reader exercises |
| `ipaddress`, `inetAddressTest` | `InetAddress` and address handling |

## Note on `module-info.java`

The project declares a Java module (`network_programming`, requires
`java.desktop`), which is why `.classpath` points at a Java 21 JRE. The `javac`
commands above compile the clients outside module mode, which is the quickest way
to run a single class.
