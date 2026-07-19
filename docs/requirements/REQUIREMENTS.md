# Functional Requirements

## Access Management

This section defines how users access the system and how permissions are enforced.

### **FR-001** User Authentication

Priority: Must Have

Users must be able to sign in using credentials assigned to them by the department.

#### Acceptance Criteria

| **ID**     | **Name**                  | **Given**                   | **When**                          | **Then**                                                |
| ---------- | ------------------------- | --------------------------- | --------------------------------- | ------------------------------------------------------- |
| **AC-001** | Successful Authentication | A valid user account exists | The user enters valid credentials | Access is granted and the user's permissions are loaded |

---

### **FR-002** Role-Based Access Control

Priority: Must Have

Access to modules, pages, and actions must depend on the permissions assigned to the user's role.

#### Acceptance Criteria

| **ID**     | **Name**            | **Given**        | **When**                                                     | **Then**                                                   |
| ---------- | ------------------- | ---------------- | ------------------------------------------------------------ | ---------------------------------------------------------- |
| **AC-001** | Authorized Access   | A signed-in user | The user attempts to access a module or operation            | Access is granted only if the required permission exists   |
| **AC-002** | Unauthorized Access | A signed-in user | The user attempts to access a restricted module or operation | Access is denied and an authorization message is displayed |

---

## User Administration

This section defines how user accounts, roles, and permissions are managed.

### **FR-003** User Management

Priority: Must Have

Authorized personnel must be able to create, modify, activate, deactivate, and remove user accounts.

#### Acceptance Criteria

| **ID**     | **Name**                | **Given**                              | **When**                        | **Then**                                                       |
| ---------- | ----------------------- | -------------------------------------- | ------------------------------- | -------------------------------------------------------------- |
| **AC-001** | Create User Account     | A user with user-management permission | A new account is created        | The account is stored and becomes available for authentication |
| **AC-002** | Update User Account     | A user with user-management permission | Account information is modified | The changes are saved and applied immediately                  |
| **AC-003** | Deactivate User Account | A user with user-management permission | An account is deactivated       | The account can no longer access the system                    |

---

### **FR-004** Role Assignment and Permission Configuration

Priority: Must Have

Authorized personnel must be able to assign roles to users and configure permissions for Administrative Staff accounts.

#### Acceptance Criteria

| **ID**     | **Name**                     | **Given**                              | **When**                             | **Then**                                                              |
| ---------- | ---------------------------- | -------------------------------------- | ------------------------------------ | --------------------------------------------------------------------- |
| **AC-001** | Assign Role                  | A user with role-management permission | A role is assigned to a user account | The permissions associated with the role become effective immediately |
| **AC-002** | Configure Permissions        | An Administrative Staff account        | Permissions are configured           | Only the selected permissions are granted                             |
| **AC-003** | Apply Predefined Permissions | A predefined role exists               | The role is assigned                 | The predefined permissions are applied automatically                  |

---

## Data Import

This section defines how departmental data enters the system.

### **FR-005** Data Import

Priority: Must Have

Authorized users must be able to import departmental data from supported input files.

#### Acceptance Criteria

| **ID**     | **Name**            | **Given**                                 | **When**                                                         | **Then**                                           |
| ---------- | ------------------- | ----------------------------------------- | ---------------------------------------------------------------- | -------------------------------------------------- |
| **AC-001** | Successful Import   | A user with import permission             | A valid input file is selected and the import process is started | The data is imported and stored in the database    |
| **AC-002** | Invalid Import File | An invalid or corrupted input file exists | The import process is started                                    | The import is rejected and the reason is displayed |
| **AC-003** | Import Summary      | An import operation completes             | The process finishes                                             | A summary of the import results is displayed       |

---

### **FR-006** Import Session Control

Priority: Must Have

Only one import session may run at a time.

#### Acceptance Criteria

| **ID**     | **Name**                   | **Given**                                          | **When**                                         | **Then**                                          |
| ---------- | -------------------------- | -------------------------------------------------- | ------------------------------------------------ | ------------------------------------------------- |
| **AC-001** | Prevent Concurrent Imports | An import session is already running               | Another user starts a new import session         | The new import session is prevented from starting |
| **AC-002** | Import Session Visibility  | An import session is already running               | Another user opens the import module             | The active import session is indicated            |
| **AC-003** | Allow New Import Session   | The active import session finishes or is cancelled | Another authorized user starts an import session | The new import session is allowed to start        |

---

## Analytics Modules

The modules in this section transform departmental data into statistics, charts, and indicators that support analysis and decision-making.

### **FR-007** Student Distribution

Priority: Must Have

The Student Distribution module provides insights related to student distribution through statistics, charts, and indicators.

#### Acceptance Criteria

| **ID**     | **Name**                | **Given**                               | **When**                                       | **Then**                                                                                   |
| ---------- | ----------------------- | --------------------------------------- | ---------------------------------------------- | ------------------------------------------------------------------------------------------ |
| **AC-001** | Opening the Module      | Student data exists in the system       | The user opens the Student Distribution module | The Student Distribution module is displayed                                               |
| **AC-002** | Default Statistics Page | The Student Distribution module is open | The module is displayed for the first time     | The Statistics page is displayed by default and numerical statistical values are displayed |
| **AC-003** | Charts Page             | The Student Distribution module is open | The user navigates to the Charts page          | Graphical representations of the available statistics are displayed                        |
| **AC-004** | Indicators Page         | The Student Distribution module is open | The user navigates to the Indicators page      | The available indicators are displayed                                                     |

---

### **FR-008** Academic Progression

Priority: Must Have

The Academic Progression module provides insights related to academic progression through statistics, charts, and indicators.

#### Acceptance Criteria

| **ID**     | **Name**                | **Given**                               | **When**                                       | **Then**                                                                                   |
| ---------- | ----------------------- | --------------------------------------- | ---------------------------------------------- | ------------------------------------------------------------------------------------------ |
| **AC-001** | Opening the Module      | Academic data exists in the system      | The user opens the Academic Progression module | The Academic Progression module is displayed                                               |
| **AC-002** | Default Statistics Page | The Academic Progression module is open | The module is displayed for the first time     | The Statistics page is displayed by default and numerical statistical values are displayed |
| **AC-003** | Charts Page             | The Academic Progression module is open | The user navigates to the Charts page          | Graphical representations of the available statistics are displayed                        |
| **AC-004** | Indicators Page         | The Academic Progression module is open | The user navigates to the Indicators page      | The available indicators are displayed                                                     |

### **FR-009** Administrative Situation

Priority: Must Have

The Administrative Situation module provides insights related to administrative situations through statistics, charts, and indicators.

#### Acceptance Criteria

| **ID**     | **Name**                | **Given**                                   | **When**                                           | **Then**                                                                                   |
| ---------- | ----------------------- | ------------------------------------------- | -------------------------------------------------- | ------------------------------------------------------------------------------------------ |
| **AC-001** | Opening the Module      | Administrative data exists in the system    | The user opens the Administrative Situation module | The Administrative Situation module is displayed                                           |
| **AC-002** | Default Statistics Page | The Administrative Situation module is open | The module is displayed for the first time         | The Statistics page is displayed by default and numerical statistical values are displayed |
| **AC-003** | Charts Page             | The Administrative Situation module is open | The user navigates to the Charts page              | Graphical representations of the available statistics are displayed                        |
| **AC-004** | Indicators Page         | The Administrative Situation module is open | The user navigates to the Indicators page          | The available indicators are displayed                                                     |

---

### **FR-010** Graduation

Priority: Must Have

The Graduation module provides insights related to graduation through statistics, charts, and indicators.

#### Acceptance Criteria

| **ID**     | **Name**                | **Given**                            | **When**                                   | **Then**                                                                                   |
| ---------- | ----------------------- | ------------------------------------ | ------------------------------------------ | ------------------------------------------------------------------------------------------ |
| **AC-001** | Opening the Module      | Graduation data exists in the system | The user opens the Graduation module       | The Graduation module is displayed                                                         |
| **AC-002** | Default Statistics Page | The Graduation module is open        | The module is displayed for the first time | The Statistics page is displayed by default and numerical statistical values are displayed |
| **AC-003** | Charts Page             | The Graduation module is open        | The user navigates to the Charts page      | Graphical representations of the available statistics are displayed                        |
| **AC-004** | Indicators Page         | The Graduation module is open        | The user navigates to the Indicators page  | The available indicators are displayed                                                     |

---

## Dashboard

The dashboard provides a consolidated view of information from multiple modules.

### **FR-011** Dashboard

Priority: Must Have

The dashboard provides a summary of statistics, charts, and indicators collected from multiple modules.

#### Acceptance Criteria

| **ID**     | **Name**          | **Given**                                | **When**                       | **Then**                                                                                    |
| ---------- | ----------------- | ---------------------------------------- | ------------------------------ | ------------------------------------------------------------------------------------------- |
| **AC-001** | Default Home Page | Statistical data exists in the system    | The user successfully signs in | The Dashboard opens automatically and displays summarized information from multiple modules |
| **AC-002** | Empty Dashboard   | No statistical data exists in the system | The user successfully signs in | The Dashboard opens automatically and displays empty placeholders for future information    |
| **AC-003** | Dashboard Content | The Dashboard is open                    | Information is displayed       | The information may include statistics, charts, indicators, or a combination of them        |
| **AC-004** | Consolidated View | The Dashboard is open                    | The user views the page        | Information from multiple modules is presented in a single view                             |

---

## Data Management

This section defines how information can be exported, preserved, and corrected.

### **FR-012** Data Export

Priority: Must Have

Authorized users must be able to export statistics, charts, and indicators.

#### Acceptance Criteria

| **ID**     | **Name**           | **Given**                                       | **When**                                   | **Then**                                               |
| ---------- | ------------------ | ----------------------------------------------- | ------------------------------------------ | ------------------------------------------------------ |
| **AC-001** | Export Information | A user has export permission                    | The user initiates an export operation     | An export file is generated                            |
| **AC-002** | Export Accuracy    | Statistics, charts, or indicators are displayed | The user exports the displayed information | The exported content matches the displayed information |
| **AC-003** | Access Export File | An export operation completes successfully      | The export file is generated               | The user can access the generated file                 |

---

### **FR-013** Backup and Restore

Priority: Must Have

Authorized users must be able to create and restore system backups. Restoring a backup must not permanently destroy the state that existed immediately before the restore.

#### Acceptance Criteria

| **ID**     | **Name**                   | **Given**                                           | **When**                                            | **Then**                                                                      |
| ---------- | --------------------------- | ------------------------------------------------------ | ------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| **AC-001** | Create Backup              | A user has backup permission                          | The user initiates a backup operation                  | A backup containing application data is created                                |
| **AC-002** | Restore Backup             | A valid backup exists                                 | An authorized user initiates a restore operation        | The data contained in the selected backup is restored                          |
| **AC-003** | Operation Result           | A backup or restore operation completes               | The operation finishes                                  | The result of the operation is displayed                                       |
| **AC-004** | Preserve Pre-Restore State | A restore operation is initiated                      | The current database state is about to be replaced      | The current state is archived as a new backup before the restore proceeds      |

---

### **FR-014** Data Correction

Priority: Must Have

Authorized users must be able to correct previously imported information while preserving historical records.

#### Acceptance Criteria

| **ID**     | **Name**                     | **Given**                          | **When**                                | **Then**                                   |
| ---------- | ---------------------------- | ---------------------------------- | --------------------------------------- | ------------------------------------------ |
| **AC-001** | Record Correction            | Previously imported data exists    | An authorized user submits a correction | The correction is recorded successfully    |
| **AC-002** | View Corrected Data          | A correction exists                | The corrected information is viewed     | The corrected information is displayed     |
| **AC-003** | Preserve History             | A correction exists                | Historical information is reviewed      | The original information remains available |
| **AC-004** | Deny Unauthorized Correction | A user lacks correction permission | The user attempts a correction          | The operation is denied                    |

---

## Statistics Processing

This section defines how statistical information is generated, stored, updated, and presented.

### **FR-015** Statistics Recalculation

Priority: Must Have

Statistical results must remain synchronized with the underlying data.

#### Acceptance Criteria

| **ID**     | **Name**                     | **Given**                              | **When**                                      | **Then**                                           |
| ---------- | ---------------------------- | -------------------------------------- | --------------------------------------------- | -------------------------------------------------- |
| **AC-001** | Recalculate After Import     | Data affecting statistics is inserted  | The insertion completes successfully          | The affected statistical results are updated       |
| **AC-002** | Recalculate After Correction | Data affecting statistics is corrected | The correction completes successfully         | The affected statistical results are updated       |
| **AC-003** | Display Updated Results      | Updated statistical results exist      | A user opens or refreshes a statistics module | The updated results are displayed                  |
| **AC-004** | Display Current Results      | No data changes have occurred          | A user views statistics                       | The most recently calculated results are displayed |

---

### **FR-016** Precalculated Statistics Storage

Priority: Must Have

Calculated statistical results must be stored separately from operational data for presentation purposes.

#### Acceptance Criteria

| **ID**     | **Name**                 | **Given**                               | **When**                         | **Then**                                          |
| ---------- | ------------------------ | --------------------------------------- | -------------------------------- | ------------------------------------------------- |
| **AC-001** | Store Calculated Results | Statistical calculations have completed | The calculation process finishes | The resulting statistics are stored               |
| **AC-002** | Retrieve Stored Results  | Stored statistical results exist        | A user opens a statistics page   | The stored results are retrieved for presentation |
| **AC-003** | Replace Old Results      | Statistical results are updated         | Recalculation completes          | Previous results are replaced                     |
| **AC-004** | Use Stored Results       | Recalculation is not required           | A user requests statistics       | The stored statistical results are presented      |

---

### **FR-017** Statistics Availability

Priority: Must Have

Approved statistics must be available through Statistics, Charts, and Indicators pages.

#### Acceptance Criteria

| **ID**     | **Name**        | **Given**                        | **When**                                              | **Then**                                        |
| ---------- | --------------- | -------------------------------- | ----------------------------------------------------- | ----------------------------------------------- |
| **AC-001** | Statistics Page | Statistical results exist        | A user opens a Statistics page                        | Numerical statistical results are displayed     |
| **AC-002** | Charts Page     | Statistical results exist        | A user opens a Charts page                            | Graphical representations are displayed         |
| **AC-003** | Indicators Page | Statistical results exist        | A user opens an Indicators page                       | Available indicators are displayed              |
| **AC-004** | Empty State     | Statistical results do not exist | A user opens a Statistics, Charts, or Indicators page | An appropriate empty-state message is displayed |

---

## Auditing and Visibility

This section defines how important actions are recorded and how restricted information is handled.

### **FR-018** Restricted Information Presentation

Priority: Must Have

Users must not be able to view information for which they do not have permission while still being informed that access is restricted.

#### Acceptance Criteria

| **ID**     | **Name**                    | **Given**                                         | **When**                                             | **Then**                                                                        |
| ---------- | --------------------------- | ------------------------------------------------- | ---------------------------------------------------- | ------------------------------------------------------------------------------- |
| **AC-001** | Hide Restricted Information | A user lacks permission to view information       | The user accesses a page containing that information | The restricted information is not revealed                                      |
| **AC-002** | Indicate Restriction        | Restricted information exists on a page           | The page is displayed                                | A visual indication of restricted access is displayed                           |
| **AC-003** | Explain Restriction         | Restricted information is displayed as restricted | The user views the page                              | The user is informed that access is unavailable due to insufficient permissions |

---

### **FR-019** Audit History

Priority: Must Have

Important administrative operations must be recorded and available for review.

#### Acceptance Criteria

| **ID**     | **Name**                 | **Given**                                          | **When**                                      | **Then**                                                          |
| ---------- | ------------------------ | -------------------------------------------------- | --------------------------------------------- | ----------------------------------------------------------------- |
| **AC-001** | Record Operation         | An important administrative operation is performed | The operation completes                       | The operation is recorded in the audit history                    |
| **AC-002** | View Audit History       | Audit history records exist                        | An authorized user accesses the audit history | The recorded operations are displayed                             |
| **AC-003** | Deny Unauthorized Access | A user lacks audit-history permission              | The user attempts to access audit history     | Access is denied                                                  |
| **AC-004** | Audit Record Details     | An audit record exists                             | The record is viewed                          | The operation type, responsible user, and timestamp are displayed |

# Non-Functional Requirements

## Security

This section defines the security characteristics expected from the system.

### **NFR-001** Authentication Security

Priority: Must Have

User credentials and authentication information must be protected from unauthorized access.

#### Acceptance Criteria

| **ID**     | **Name**                      | **Given**                                 | **When**                               | **Then**                                                |
| ---------- | ----------------------------- | ----------------------------------------- | -------------------------------------- | ------------------------------------------------------- |
| **AC-001** | Protected Credentials         | User credentials are stored by the system | Authentication information is accessed | Unauthorized users cannot access credential information |
| **AC-002** | Secure Authentication Process | A user attempts to authenticate           | Credentials are submitted              | Authentication information is processed securely        |

---

### **NFR-002** Authorization Enforcement

Priority: Must Have

Permissions must be enforced consistently throughout the application.

#### Acceptance Criteria

| **ID**     | **Name**                     | **Given**                           | **When**                               | **Then**                                                         |
| ---------- | ---------------------------- | ----------------------------------- | -------------------------------------- | ---------------------------------------------------------------- |
| **AC-001** | Consistent Permission Checks | A protected resource exists         | A user attempts to access the resource | The required permissions are verified before access is granted   |
| **AC-002** | Consistent Enforcement       | Multiple protected operations exist | Users interact with the system         | Permission rules are enforced consistently across all operations |

---

## Availability and Performance

This section defines operational and performance expectations.

### **NFR-003** System Availability

Priority: Must Have

The system must remain operational without requiring an active internet connection.

#### Acceptance Criteria

| **ID**     | **Name**          | **Given**                              | **When**                             | **Then**                                    |
| ---------- | ----------------- | -------------------------------------- | ------------------------------------ | ------------------------------------------- |
| **AC-001** | Offline Operation | The system is installed and configured | Internet connectivity is unavailable | Core system functionality remains available |

---

### **NFR-004** Statistics Retrieval Performance

Priority: Must Have

Statistical information must be presented within 2 seconds under normal operating conditions.

#### Acceptance Criteria

| **ID**     | **Name**                 | **Given**                    | **When**                                | **Then**                                              |
| ---------- | ------------------------ | ----------------------------- | ----------------------------------------- | ---------------------------------------------------------- |
| **AC-001** | Statistics Response Time | Statistical results exist    | A user requests statistical information | Results are displayed within 2 seconds                |
| **AC-002** | Dashboard Response Time  | Dashboard information exists | A user opens the dashboard              | Dashboard information is displayed within 2 seconds    |

---

## Reliability and Integrity

This section defines expectations related to correctness, consistency, and reliability.

### **NFR-005** Data Integrity

Priority: Must Have

Stored information must remain consistent and correct throughout its lifecycle.

#### Acceptance Criteria

| **ID**     | **Name**               | **Given**                                    | **When**                                | **Then**                                                                  |
| ---------- | ---------------------- | -------------------------------------------- | --------------------------------------- | ------------------------------------------------------------------------- |
| **AC-001** | Preserve Consistency   | Valid data exists                            | Data is processed, stored, or retrieved | Information remains consistent and accurate                               |
| **AC-002** | Prevent Invalid States | An operation could produce inconsistent data | The operation is executed               | The operation is rejected or corrected before inconsistent data is stored |

---

### **NFR-006** Reliability

Priority: Must Have

Unexpected failures must not corrupt stored information.

#### Acceptance Criteria

| **ID**     | **Name**          | **Given**                         | **When**                             | **Then**                                     |
| ---------- | ----------------- | --------------------------------- | ------------------------------------ | -------------------------------------------- |
| **AC-001** | Failure Recovery  | An unexpected failure occurs      | The system recovers from the failure | Previously stored information remains intact |
| **AC-002** | Data Preservation | A failure interrupts an operation | Recovery procedures complete         | Data corruption does not occur               |

---

### **NFR-007** Backup Reliability

Priority: Must Have

Backup data must remain usable for successful restoration.

#### Acceptance Criteria

| **ID**     | **Name**               | **Given**             | **When**                        | **Then**                                      |
| ---------- | ---------------------- | --------------------- | ------------------------------- | --------------------------------------------- |
| **AC-001** | Valid Backup           | A backup is created   | The backup process completes    | The backup can be used for future restoration |
| **AC-002** | Successful Restoration | A valid backup exists | A restore operation is executed | The backup data is restored successfully      |

---

## Auditability

This section defines the ability to review and trace important actions performed within the system.

### **NFR-008** Auditability

Priority: Must Have

The system must preserve sufficient information to support auditing and administrative review.

#### Acceptance Criteria

| **ID**     | **Name**          | **Given**                  | **When**                                     | **Then**                                                  |
| ---------- | ----------------- | -------------------------- | -------------------------------------------- | --------------------------------------------------------- |
| **AC-001** | Traceable Actions | An auditable action occurs | The action is recorded                       | The responsible user and action details can be identified |
| **AC-002** | Historical Review | Audit records exist        | An authorized user reviews audit information | The recorded history can be examined                      |

---

## Usability

This section defines expectations related to consistency and ease of use.

### **NFR-009** Usability

Priority: Must Have

The user interface must remain consistent across all modules.

#### Acceptance Criteria

| **ID**     | **Name**                      | **Given**                                                                                        | **When**            | **Then**                                       |
| ---------- | ----------------------------- | ------------------------------------------------------------------------------------------------ | ------------------- | ---------------------------------------------- |
| **AC-001** | Consistent Interface Elements | A user navigates between modules                                                                 | Pages are displayed | Similar interface elements behave consistently |
| **AC-002** | Consistent Default Page       | A user opens Student Distribution, Academic Progression, Administrative Situation, or Graduation | The module loads    | The Statistics page is displayed by default    |

---

## Maintainability

This section defines expectations related to future development and evolution.

### **NFR-010** Maintainability

Priority: Should Have

The system should be organized in a way that supports future enhancements and modifications.

#### Acceptance Criteria

| **ID**     | **Name**                   | **Given**                       | **When**                       | **Then**                                                                                |
| ---------- | -------------------------- | ------------------------------- | ------------------------------ | --------------------------------------------------------------------------------------- |
| **AC-001** | Future Enhancement Support | New functionality is required   | Developers extend the system   | Existing functionality can be modified without excessive impact on unrelated components |
| **AC-002** | Understandable Structure   | Developers work on the codebase | Project artifacts are reviewed | The system structure remains understandable and maintainable                            |

### **NFR-011** Portability

Priority: Should Have

The application must build and run correctly on multiple operating systems without requiring changes to the source code.

#### Acceptance Criteria

| **ID**     | **Name**        | **Given**                                      | **When**                              | **Then**                                                             |
| ---------- | ---------------- | -------------------------------------------------- | ------------------------------------------ | --------------------------------------------------------------------------- |
| **AC-001** | Cross-OS Build   | The documented setup steps are followed           | The project is built on a supported OS   | The build completes successfully, using the same source code               |
| **AC-002** | Cross-OS Run     | The application has been built successfully       | The application is launched              | The application starts and behaves the same way across supported OSes      |
