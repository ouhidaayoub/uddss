# 0004 - Business Rules Live Only on the Server

## Status

Accepted

## Context

Once I decided on the multi-client setup with a central server, and Clean Architecture for that server's code, one more question came up: should the JavaFX app also hold some of its own real rules, or should every real rule live only on the server?

I went through 3 real examples from my own docs to actually test this, not just guess:

- `US-001`, signing in. Checking if a password is actually correct always needs the server, no way around it.
- `FR-018`, restricted information. If the app tried to hide things itself, based on its own copy of the rules, and the real rule ever changed, I'd have to update it in 2 places, the server and the app, and if I forgot one, they'd quietly disagree.
- `FR-006`, only one import at a time. The app on one computer has no way of knowing what's happening on a different computer. Only the server can actually know that.

All 3 pointed the same way.

## Decision

Every real business rule lives only on the server. The JavaFX app doesn't decide anything real on its own, it just shows screens and sends requests. Small, harmless checks, like "you left this box empty," can still happen instantly on the app, but that's not a real rule, just basic manners, not something this decision is even about.

## Consequences

**The good parts**

- Every real rule lives in exactly one place. Fix a bug once, it's fixed everywhere.
- Every staff computer behaves exactly the same way, since none of them are deciding anything on their own.
- Matches the 2 decisions I already made, the central server (`0002`) and Clean Architecture (`0003`), both already assumed the real logic lives in one place.

**The real costs**

- Every real check, even small ones, needs a trip to the server and back. Feels a little slower than doing it instantly on the app.

## Alternatives Considered

Putting some real rules on the app too, so simple things could feel faster. I looked at this seriously, using the 3 examples above, and in every single one, the server still ended up being the only one who could actually give the real answer. The only genuine win from doing both would've been something as small as an empty text box, which isn't a real rule to begin with. Not worth the extra complexity for that.
