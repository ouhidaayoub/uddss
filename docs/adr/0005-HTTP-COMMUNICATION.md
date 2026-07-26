# 0005 - HTTP for App-to-Server Communication

## Status

Accepted

## Context

Once I knew the app and the server are 2 separate programs, I needed to decide how they'd actually talk to each other over the network. I looked at 2 real options: plain sockets, where I invent my own message format myself, or HTTP, the same standard format real websites already use.

I wrote out real code for both, using [`FR-008`](../requirements/REQUIREMENTS.md#fr-008-academic-progression), academic progression stats, as the test case. With sockets, I had to invent my own reply format, then write code just to split it back apart on the other side. With HTTP, the reply was already real, standard JSON, nothing invented, nothing to undo.

## Decision

The app talks to the server using HTTP requests. Not because this is a website, it isn't, but because HTTP is just a message format, and it happens to be the same one real websites use.

## Consequences

**The good parts**

- Standard response codes already exist, `200` for success, `403` for not allowed, I don't need to invent my own.
- I can test a request by literally typing an address into a browser, before any of my real app code even exists yet.
- MMy own Part D page from my SOFTWARE ENGINEERING FINGERPRINT Notion file already covers REST and HTTP basics, so this decision means that material actually gets used, not skipped.
- HTTP is genuinely common in real jobs, sockets at this level mostly aren't.

**The real costs**

- HTTP carries a little more overhead than a raw socket message. For this project's size, that difference doesn't actually matter.

## Alternatives Considered

**Plain sockets.** Closer to "the metal," and I did write real code for it to compare. I didn't pick it because I'd be inventing my own message format from scratch, and keeping the app and the server agreeing on that format, forever, felt like unnecessary extra risk for no real benefit at this project's size.

**Java RMI and gRPC.** Looked at both briefly too. RMI isn't used much in real jobs anymore. gRPC is powerful, but needs real extra setup and tooling, more than this project's size actually calls for.
