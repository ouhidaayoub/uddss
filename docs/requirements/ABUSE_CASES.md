# Abuse Cases

This document describes how an attacker or malicious user could intentionally misuse the system. Abuse cases are used to identify potential security threats early, before the system is designed and implemented.

---

## AB-001 Unauthorized Authentication

**As an attacker, I want to** sign in using invalid or stolen credentials **so that** I can gain unauthorized access to the system.

**Expected System Response**

* Reject the authentication attempt.
* Do not create a user session.
* Record the failed authentication attempt when appropriate.

---

## AB-002 Unauthorized Module Access

**As an attacker, I want to** access modules without the required permissions **so that** I can use restricted functionality.

**Expected System Response**

* Verify the user's permissions before granting access.
* Deny access to the requested module.
* Record the unauthorized access attempt when appropriate.

---

## AB-003 Unauthorized User Management

**As an attacker, I want to** create, modify, activate, or deactivate user accounts **so that** I can control access to the system.

**Expected System Response**

* Verify the required permissions.
* Reject the requested operation.
* Preserve the existing user information.
* Record the unauthorized operation when appropriate.

---

## AB-004 Unauthorized Permission Modification

**As an attacker, I want to** assign roles or modify user permissions **so that** I can gain additional privileges.

**Expected System Response**

* Verify the required permissions.
* Reject the requested operation.
* Preserve the existing roles and permissions.
* Record the unauthorized operation when appropriate.

---

## AB-005 Invalid Data Import

**As an attacker, I want to** import corrupted, malformed, or invalid data **so that** I can compromise the quality of departmental information.

**Expected System Response**

* Validate the imported data.
* Reject invalid records.
* Explain the validation failures.
* Prevent invalid data from entering the system.

---

## AB-006 Multiple Concurrent Imports

**As an attacker, I want to** start multiple import sessions simultaneously **so that** I can disrupt the import process or create inconsistent results.

**Expected System Response**

* Allow only one active import session at a time.
* Reject additional import attempts until the active session finishes.

---

## AB-007 Unauthorized Data Export

**As an attacker, I want to** export restricted information **so that** I can obtain data I am not authorized to access.

**Expected System Response**

* Verify export permissions.
* Reject unauthorized export requests.
* Prevent generation of the requested export.

---

## AB-008 Unauthorized Data Correction

**As an attacker, I want to** modify imported information without permission **so that** I can alter official departmental records.

**Expected System Response**

* Verify correction permissions.
* Reject unauthorized correction requests.
* Preserve the existing information.

---

## AB-009 Historical Data Tampering

**As an attacker, I want to** modify or remove historical records **so that** I can hide previous activities or alter the historical record.

**Expected System Response**

* Preserve protected historical information.
* Prevent unauthorized modification or deletion.
* Record the attempted operation when appropriate.

---

## AB-010 Unauthorized Backup Operations

**As an attacker, I want to** create or restore backups **so that** I can overwrite or obtain protected information.

**Expected System Response**

* Verify the required permissions.
* Reject unauthorized backup operations.
* Preserve the existing backup state.

---

## AB-011 Unauthorized Audit History Access

**As an attacker, I want to** view audit records **so that** I can learn about administrative activities or hide my own actions.

**Expected System Response**

* Verify access permissions.
* Deny access to audit history.
* Protect audit information from unauthorized disclosure.

---

## AB-012 Unauthorized Information Disclosure

**As an attacker, I want to** access confidential information **so that** I can obtain data that should remain protected.

**Expected System Response**

* Verify access permissions before displaying information.
* Deny access to restricted information.
* Prevent disclosure of protected data.
