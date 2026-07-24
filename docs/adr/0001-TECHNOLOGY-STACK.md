# 0001 - Technology Stack

## Status

Accepted

## Context

Before I wrote any real code, I had to pick a language, a way to build the screens, a build tool, and a database. This happened really early, honestly before I even set up this whole structured process I use now. So let me be upfront: I didn't sit down and compare a bunch of options side by side. I just went with what I already knew, and what made sense for what the project actually needed.

The app has to run as a desktop program, without needing the internet (that's `NFR-003`), on computers inside a university department.

## Decision

I'm using Java 21, the long-term-support version, JavaFX to build the screens, Maven to build the project and handle its dependencies, and MariaDB as the database.

## Consequences

**The good parts**

- Java runs the same way on Windows, Mac, and Linux. That matters, since [`SETUP.md`](../setup/SETUP.md) says this should work on all of them.
- JavaFX comes built into Java already, so I don't need a whole separate UI framework on top.
- Maven is used by a lot of people, so if I get stuck, it's easy to find help online.
- MariaDB is free, open source, and works almost exactly like MySQL, so there's plenty of help out there for it too.

**The real costs**

- JavaFX takes more manual work to look modern, compared to some web-based tools.
- Since I picked a desktop app from day one, moving to a web version later would take real effort, not a quick switch.

## Alternatives Considered

Honestly? Not really, not seriously. I could have built this as a website instead, browser on the front, something hosted in the back. Looking back now, that might have worked for the actual requirements too, but it would have fought against the offline requirement unless I put in real extra work for that. Feels more honest to just say that here, instead of pretending I ran a big comparison that never actually happened.
