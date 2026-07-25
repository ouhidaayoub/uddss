# Contributing

At the moment, I am the only contributor to this project. However, the project follows a documented workflow to keep development organized and consistent.

## Branching Strategy

The project uses Git Flow.

Main branches:

* main
* develop

Supporting branches:

* feature/*
* release/*
* hotfix/*

Every new feature should be developed inside its own feature branch.

Examples:

* feature/import-wizard
* feature/dashboard
* feature/audit-log

## Commit Messages

This project uses Conventional Commits with scopes.

Format:

`<type>(<scope>): <description>`

Examples:

* chore(project): initialize UDDSS project
* docs(requirements): define problem statement and stakeholders
* docs(requirements): add requirements specification and analysis artifacts
* feat(authentication): implement login workflow
* feat(import): add import session management
* refactor(import): simplify validation pipeline
* fix(statistics): correct graduation rate calculation
* test(import): add import validation tests


## Pull Requests

Pull Requests are required before changes are merged.

Even when working alone, Pull Requests serve as a review checkpoint and a historical record of important changes.

A Pull Request should explain:

* What changed.
* Why it changed.
* Any important design decisions.

## Before Merging

This is the project's Definition of Done. Before merging a Pull Request:

* The project must build successfully.
* The feature has been tested manually.
* The code has been reviewed (even if that means re-reading it myself, later, with fresh eyes).
* Security has been considered, no obvious new risk introduced.
* Documentation has been updated if necessary.
* The Pull Request description is complete.

## Engineering Decisions

Important technical decisions should be documented using ADRs located in [`docs/adr/`](docs/adr/).

Future contributors should consult existing ADRs before introducing major changes.
