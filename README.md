# Jiang Haochen — Projects

Undergraduate in Computer Science at Universiti Kebangsaan Malaysia (UKM),
graduating November 2027.

CGPA 3.87 / 4.00 · Dean's List every semester · Top 1% of the faculty

## About this repository

Most of the code here I wrote on my own, outside of class. It started as an
Eclipse workspace for coursework and gradually became the place where I keep
everything Java — experiments, half-finished ideas, and a few things I'm still
proud of. Course assignments are included only where they were substantial
enough to be worth reading.

If you only have two minutes, read [`network_programming`](network_programming/).

## Worth your time

### [`network_programming`](network_programming/)

Hand-written **SMTP (RFC 5321)** and **POP3 (RFC 1939)** clients on raw sockets —
no mail library, the protocol is implemented line by line, from the greeting to
the terminating dot. The same folder holds TCP/UDP socket work.

I later went back and rewrote the mail clients in Java 17: explicit CRLF instead
of `println()`, connect and read timeouts, RFC-compliant multi-line reply
handling, dedicated exception types. The original and the rewrite are both kept,
along with a [before/after write-up](network_programming/docs/smtp-pop3-rewrite.md)
that documents a real parsing bug in the first version — the kind of bug you
only find by pointing the client at a server that answers with more than one line.

### [`algorithm_design`](algorithm_design/)

Five sorting algorithms written from scratch — bubble, selection, insertion,
quicksort, heapsort — plus a benchmark that runs them on the same random input
and reports median timings. The [README](algorithm_design/README.md) has the
measurements and what they show: bubble sort taking 116× longer when the input
grows 10×, insertion sort beating selection sort by 3× despite both being
O(n²), and quicksort losing to heapsort at 10,000 elements before winning at a
million.

## What else is in here

| Folder | Content |
| --- | --- |
| `Algorithms`, `dataStructurePractise`, `mergeSort` | Data structures and algorithm exercises |
| `DiceGame.MVC`, `SimpleProject`, `SimpleWebSystem` | OOP and MVC practice |
| `unitTesting02`–`04`, `unitTesing` | JUnit experiments |
| `htmlPractice` | HTML / CSS |
| `Jim-*`, `studentQuerySystem` | Small Java applications |
| `Java1`–`Java4`, `Hello World`, `ZZZ`, `zzzz`, `azz` | Early exercises and scratch space |

Every folder is its own Eclipse project (`.project` and `.classpath` included),
so any of them can be imported with **File → Import → Existing Projects into
Workspace**.

## Not in this repository

My final-year project — a PHP MVC adaptive learning platform with a rule-based
recommendation pipeline and automated PDF certificate generation — lives in a
separate private repository.

## Contact

- Email: A206164@siswa.ukm.edu.my
- GitHub: [@a206164-jianghaochen](https://github.com/a206164-jianghaochen)
