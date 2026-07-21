# 0003 - Clean Architecture for the Server's Internal Code

## Status

Accepted

## Context

Once I decided the Application Server holds every real business rule, I needed to actually pick how to organize the code inside it. My own Part D page from my SOFTWARE ENGINEERING FINGERPRINT Notion file laid out a few real options: a simple Layered style, or one of 3 "domain-centric" styles (Hexagonal, Onion, Clean Architecture), which all share the same core idea, keep the real logic in the middle, keep the database and screens on the outside.

I went through real examples for both, using `FR-010`, graduation stats, as the test case. The big difference that actually mattered to me: with a domain-centric style, I can test my actual logic without needing a real database running at all. With Layered, most tests would still need MariaDB connected.

## Decision

Use Clean Architecture, specifically, not just "domain-centric" in general, for the Application Server's internal code. The core business rules sit in the middle. The database code and anything talking to the outside world sit around it, as separate pieces. The middle never depends on the outside, only the other way around.

## Consequences

**The good parts**

- I can test my real logic without a database running, which matters a lot once I get to `L4`, actual testing.
- Every real rule stays in one place, not spread across random files.
- My own Repo Skeleton page already uses the word "application," which is Clean Architecture's own name for this middle piece, so my folder names and my docs already agree with each other.

**The real costs**

- More setup than Layered, even small features need their own small structure.
- It can feel like extra work for a solo project this size, at least at first.
- I'm the only one on this project, so I have to hold myself to this discipline myself, nobody's reviewing it for me except future me.

## Alternatives Considered

**Simple Layered.** My own OFTWARE ENGINEERING FINGERPRINT Notion file literally says this is "usually the pro choice" for a small desktop tool like this one. Genuinely simpler, less setup. I didn't pick it because testing my real logic without a database felt like the bigger win for a project where I'm also trying to learn good habits, not just ship something fast.

**Hexagonal and Onion.** Both are basically the same idea as Clean Architecture, just named and drawn differently. I picked Clean specifically since its own vocabulary (calling the middle layer "application") already matches what I'd already named my folders, before I even made this decision formally.
