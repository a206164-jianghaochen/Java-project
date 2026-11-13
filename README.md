# Jiang Haochen — Computer Science Coursework

Undergraduate in Computer Science at Universiti Kebangsaan Malaysia (UKM),
graduating November 2027.

CGPA 3.87 / 4.00 · Dean's List every semester · Top 1% of the faculty

This repository is my working archive: an Eclipse workspace with one folder per
course project. Most of them are weekly lab exercises. The one below is the one
I would actually ask you to look at.

## Worth your time

### [`network_programming`](network_programming/)

Hand-written **SMTP (RFC 5321)** and **POP3 (RFC 1939)** clients on raw sockets —
no mail library, the protocol is implemented line by line. The same folder holds
TCP/UDP socket exercises.

The mail clients were later rewritten in Java 17 (timeouts, explicit CRLF,
RFC-compliant multi-line reply handling, dedicated exception types). The
original and the rewrite are both kept, with a
[before/after write-up](network_programming/docs/smtp-pop3-rewrite.md) that also
documents a real parsing bug in the original.

## The rest of the workspace

| Folder | Content |
| --- | --- |
| `Algorithms`, `algorithm_design`, `dataStructurePractise`, `mergeSort` | Data structures and algorithm exercises |
| `DiceGame.MVC`, `SimpleProject`, `SimpleWebSystem` | OOP / MVC practice |
| `unitTesting02`–`04`, `unitTesing` | JUnit exercises |
| `htmlPractice` | HTML / CSS exercises |
| `Jim-*`, `studentQuerySystem` | Small Java applications |
| `Java1`–`Java4`, `Hello World`, `ZZZ`, `zzzz`, `azz` | Early exercises and scratch space |

Every folder is its own Eclipse project (`.project` / `.classpath` included), so
they can be imported individually with **File → Import → Existing Projects into
Workspace**.

## Not in this repository

My final-year project — a PHP MVC adaptive learning platform with a rule-based
recommendation pipeline and automated PDF certificate generation — lives in a
separate private repository.

## Contact

- Email: A206164@siswa.ukm.edu.my
- GitHub: [@a206164-jianghaochen](https://github.com/a206164-jianghaochen)
