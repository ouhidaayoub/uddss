# 0006 - Server Runs Locally, on an Existing Staff Computer

## Status

Accepted

## Context

Once the server itself was decided, I had to figure out where it should actually live, and whether it needed to be reachable from outside the department too.

I looked at going fully online, the server and the database both hosted on the internet, using free hosts, and even picked real services (Aiven for the database, either Render or Oracle Cloud for the server). But going through it honestly, I realized this splits into 2 separate databases, the local one and the online one, with no automatic way to keep them in sync. That's a genuinely hard problem to solve well, syncing data safely is its own real project, not a small detail.

I also already have [`NFR-003`](../requirements/REQUIREMENTS.md#nfr-003-system-availability) written down: the system has to keep working without internet at all. A fully online setup breaks that promise completely if the internet ever goes down.

## Decision

The server runs locally only, for this version. It lives on an existing staff computer, not a brand new dedicated machine. Reaching it from outside the department is not part of this version at all.

## Consequences

**The good parts**

- [`NFR-003`](../requirements/REQUIREMENTS.md#nfr-003-system-availability) stays fully true, no internet needed, ever, for the system to work.
- No new hardware needed, no extra cost.
- Only one real database exists, no syncing problem to solve, no risk of 2 copies quietly disagreeing.

**The real costs**

- If that one staff computer gets shut down, everyone loses access until it's back on.
- Nobody can use the system from outside the department right now, at all.

## Alternatives Considered

**Fully online (Aiven plus a cloud host).** Real options, and I looked at them seriously, even picked specific services. Rejected for now because it either breaks [`NFR-003`](../requirements/REQUIREMENTS.md#nfr-003-system-availability) completely, or requires solving real data-syncing between 2 separate databases, which is a genuinely hard problem on its own, not something to take on casually alongside everything else in this project.

**A small dedicated device instead of a staff computer.** Also real, and possibly better long-term, since it wouldn't be tied to someone's daily use. Noted as a future improvement, not blocking this version.

Remote access is a real, deferred idea. It's now written down in [`ROADMAP.md`](../planning/ROADMAP.md)'s Future Versions section, so it isn't lost.
