# 0002 - Multi-Client Architecture with a Central Server

## Status

Accepted

## Context

More than one person needs to use UDDSS at the same time, on different computers. My own [`STAKEHOLDERS.md`](../requirements/STAKEHOLDERS.md) already lists 5 different roles who need to touch the system directly.

I also already wrote [`FR-006`](../requirements/REQUIREMENTS.md#fr-006-import-session-control): only one import can run at a time, anywhere. If every computer talked straight to the database on its own, nothing would actually know if another computer was already importing something. There'd be no way to enforce that rule at all.

## Decision

Each staff computer runs the JavaFX app. None of these apps talk to the database directly. Instead, they all talk to one central program, the Application Server, and only that server ever touches the database.

## Consequences

**The good parts**

- [`FR-006`](../requirements/REQUIREMENTS.md#fr-006-import-session-control) actually becomes possible to enforce, since one server can see everything happening, everywhere, at once.
- All the real rules live in one place, not copied across 5 different computers.
- Only one machine ever needs to know the real database password, not every single staff computer.

**The real costs**

- Now there are 2 programs to build instead of 1, more work overall.
- The server has to be running all the time, on some computer, for anything to work at all.
- If that server ever goes down, every single person loses access at once, not just one person.

## Alternatives Considered

Every app connecting straight to the database was the simpler option, and I did think about it. But it fails the [`FR-006`](../requirements/REQUIREMENTS.md#fr-006-import-session-control) requirement completely, no way to know about other computers, and it means giving the real database password to every single machine, which goes against the confidentiality priority I already wrote in [`SECURITY.md`](../security/SECURITY.md).
