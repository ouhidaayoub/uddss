# Security Baseline

This document defines the minimum security principles that should guide the project from the beginning. The purpose is not to design the complete security architecture of the system. Instead, it establishes the rules that should influence future engineering decisions.

## Security Importance

Security is considered a high-priority concern for this project.

The system processes official academic and administrative information used to generate indicators, statistics, reports, and decision-support dashboards. Because of that, incorrect, manipulated, or unauthorized data can reduce trust in the system and affect the quality of decisions based on its outputs.

## Security Priorities

The project prioritizes security objectives in the following order:

1. Integrity
2. Availability
3. Confidentiality

The system exists to provide reliable information. Because of that, protecting the correctness of data is more important than keeping the system continuously available or hiding information from unauthorized users.

A system that produces incorrect information is more dangerous than a system that temporarily produces no information at all.

This project targets OWASP ASVS Level 2, the standard level for applications handling real, non-critical personal data.

## Trust Model

Users are not automatically trusted simply because they have access to the system.

Every important action should be attributable to a specific user and should be traceable after it occurs.

The system should always be able to answer questions such as:

* Who performed the action?
* When did it happen?
* What changed?
* Why was the action performed?

## Data Modification Strategy

Not all data should be treated the same way.

### Reference Entities

Reference entities represent the current state of the department.

Examples include:

* Students
* Teachers
* Modules
* Specialties

These entities may be updated when corrections are required.

However, important modifications should remain recoverable through audit history.

The current state may change, but previous states should not disappear completely.

### Transactional Entities

Transactional entities represent events or situations that happened.

Examples include:

* Enrollments
* Grades
* Administrative situations
* Academic events

These entities should follow an append-only philosophy whenever possible.

Historical information should remain available rather than being replaced or destroyed.

## Access Control

The system follows a role and permission model.

Permissions determine what actions can be performed.

Roles group related permissions together.

Users receive permissions through their assigned roles.

Access should never be granted simply because a user belongs to a particular category of staff.

Permissions should be explicit and traceable.

## Auditability

Auditability is a core requirement of the system.

Every meaningful business action should be recorded.

Examples include:

* Login attempts
* Imports
* Data modifications
* Permission changes
* Report exports
* Administrative actions

Audit records should contain enough information to understand what happened and who performed the action.

## Integrity First

Whenever the system detects a situation where data integrity cannot be guaranteed, the operation should be rejected or corrected.

The system should never silently ignore errors or invent missing information.

If a result cannot be trusted, it should not be produced.

Correctness is more important than convenience.

## Reporting a Vulnerability

If you find a security problem in UDDSS, please report it privately using GitHub's "Report a vulnerability" button (Security tab, on this repository), not through a public issue.

If that option is not available, contact business.ouhida@gmail.com directly.

Please do not share details publicly until a fix is ready.
