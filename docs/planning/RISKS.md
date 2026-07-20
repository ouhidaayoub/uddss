# Risks

## Purpose

Every software project has risks.

Some risks can delay the project, while others can affect the quality of the final system. Writing them down helps me think about them early instead of dealing with them after they become real problems.

This document will be updated whenever a new important risk is discovered or an existing one changes.

---

## Risk Levels

### Probability

- **Low** -> Not likely to happen.
- **Medium** -> It could happen.
- **High** -> It is likely to happen.

### Impact

- **Low** -> Small effect on the project.
- **Medium** -> The project can continue, but extra work will be needed.
- **High** -> It can seriously affect the project or delay Version 1.0.

### Severity Matrix

| Probability | Impact | Severity |
|-------------|--------|----------|
| Low | Low | Low |
| Low | Medium | Low |
| Low | High | Medium |
| Medium | Low | Low |
| Medium | Medium | Medium |
| Medium | High | High |
| High | Low | Medium |
| High | Medium | High |
| High | High | High |

---

## Risk Register

| ID | Risk | Why does this risk exist? | Probability | Impact | Severity | Mitigation |
|----|------|---------------------------|-------------|--------|----------|------------|
| R-01 | Some requirements may change while the project is being developed. | The project is still evolving, and requirements may become clearer over time. | Medium | High | High | Review the requirements before starting each major phase and document every approved change. |
| R-02 | Official department data may contain errors or inconsistencies. | The system depends on existing data that I did not create. | High | High | High | Validate and clean the data before using it. |
| R-03 | Working alone means delays have a bigger impact. | There is only one developer working on the project. | Medium | High | High | Plan the work in small steps and keep the documentation updated. |
| R-04 | Bugs may remain unnoticed if testing is left until the end. | Every new feature can introduce unexpected problems. | Medium | High | High | Test the software regularly during development instead of waiting until the final stage. |
| R-05 | Some technical decisions may need to be changed later. | As I learn more about the project, I may find better solutions. | Medium | Medium | Medium | Review important technical decisions before implementing them. |
| R-06 | Multiple client machines connect to one shared database. If the network link between a client and the database drops, that client cannot function until it reconnects. | The architecture was chosen as multi-client over a shared database, not single-machine. | Medium | Medium | Medium | Give a clear, obvious message when the database is unreachable, instead of letting the app hang or fail silently. |
| R-07 | The database user created for the app has full privileges on its own database, more than the minimum it actually needs. | Chosen deliberately for simpler setup while the project is solo and local. | Low | High | Medium | Tighten the database user's privileges to only what each operation needs, before this database serves real, multi-client production use. |

---

## Notes

This is not a complete list forever.

As the project grows, some risks may disappear, new ones may appear, and the assessment of existing risks may change.
