# 0007 - Multi-Module Maven Project (Client and Server)

## Status

Accepted

## Context

Once the Client and the Server were both confirmed as real, separate Java programs, I needed to decide where their code should actually live. My own Repo Skeleton page only ever showed a single `pom.xml`, single `src/` layout, since it was written before this project needed 2 separate programs at all.

## Decision

One repository, one parent `pom.xml`, with 2 real Maven modules underneath it, `uddss-client` and `uddss-server`. This is Maven's own standard, documented pattern for exactly this situation, more than one related Java artifact, built together.

## Consequences

**The good parts**

- One repo to manage, not two, no syncing problem between separate projects.
- Shared settings, Java version, JUnit version, defined once in the parent, not copied in both places.
- Matches real, standard Maven practice, not something invented for this project alone.

**The real costs**

- Real, one-time restructuring effort, moving existing code, writing 2 new `pom.xml` files.
- Slightly more to understand upfront than a single, flat project, given I'm still learning Java and Maven both.

## Alternatives Considered

**2 completely separate repositories.** Would mean either Git submodules or manually keeping 2 projects in sync by hand, real, ongoing overhead for a solo project, with no real benefit for something this size.

**Keep everything in one single module.** Would mean JavaFX, a dependency the Server never needs, sitting inside the same module as the Server's own code, mixing 2 genuinely different programs together, and matching the multi-client architecture already decided in `ADR-0002` much less honestly.
