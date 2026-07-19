# Branch Rules

This document defines how branches are used throughout the project.

The goal is to keep development organized while preserving a stable project history.

---

## Branches

The project follows Git Flow.

Permanent branches:

* `main`
* `develop`

Temporary branches:

* `feature/*`
* `release/*`
* `hotfix/*`

---

## main

The `main` branch represents stable versions of the project.

Rules:

* Direct commits are not allowed.
* Changes reach `main` through Pull Requests.
* Every commit on `main` should represent a stable project state.

---

## develop

The `develop` branch is the integration branch.

Rules:

* Daily development is integrated here.
* Direct commits are allowed when appropriate.
* Features should normally be merged into `develop` through Pull Requests.

---

## feature/*

Every new feature should be developed inside its own branch.

Branch name:

```
feature/<feature-name>
```

Examples:

```
feature/authentication
feature/import
feature/dashboard
feature/statistics
```

Rules:

* Created from `develop`.
* Merged back into `develop`.
* Deleted after merging.

---

## release/*

Release branches prepare a new stable version.

Branch name:

```
release/<version>
```

Examples:

```
release/v1.0.0
release/v1.1.0
```

Rules:

* Created from `develop`.
* Only bug fixes, documentation updates, and release preparation are allowed.
* Merged into both `main` and `develop`.

---

## hotfix/*

Hotfix branches are used to correct problems discovered in released versions.

Branch name:

```
hotfix/<description>
```

Examples:

```
hotfix/login-failure
hotfix/import-validation
```

Rules:

* Created from `main`.
* Merged into both `main` and `develop`.

---

## Branch Protection

### main

* Direct commits are not allowed.
* Force pushes are not allowed.
* Branch deletion is not allowed.
* Pull Requests are required.

### develop

* Force pushes are not allowed.
* Branch deletion is not allowed.

---

## General Rules

* Every branch should have a single purpose.
* Branch names should be short and descriptive.
* Finished branches should be deleted after merging.
* Long-lived feature branches should be avoided.
