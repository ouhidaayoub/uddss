# UDDSS Setup Guide

This document covers the development environment and tools needed to build and maintain UDDSS. It's written so a developer can clone the repository, install what's needed, and get the project running without already knowing Git, Java, or MariaDB.

> [!IMPORTANT]
> **How to read the labels in this document**
>
> 🟢 = Arch Linux / WSL2. The environment I actually use. Every command under this label has been run by me personally.
>
> ⚪ = Ubuntu/Debian, macOS, Windows. Standard, well-documented practice for each tool, not personally run end-to-end by me. If something under these labels doesn't match what you see, trust your own terminal over this document, and check that tool's official docs.

---

## Table of Contents

- [Development Environment](#development-environment)
- [Required Tools](#required-tools)
- [Installing the Tools](#installing-the-tools)
  - [Git](#git)
  - [Java 21](#java-21)
  - [Maven](#maven)
  - [MariaDB](#mariadb)
  - [VS Code](#vs-code)
- [GitHub Account and SSH Key](#github-account-and-ssh-key)
- [Database Setup](#database-setup)
- [Environment Variables](#environment-variables)
- [Build and Run](#build-and-run)
- [Optional Tools](#optional-tools)
- [Secrets](#secrets)
- [Documentation Policy](#documentation-policy)
- [Goal](#goal)

---

## Development Environment

I do my development on Arch Linux, running inside WSL2.

> [!NOTE]
>
> - The project itself is not tied to Arch or WSL2.
>
> - Any OS that can install the required tools should be able to build and run it.
>
> - This guide covers Arch, Ubuntu/Debian, macOS, and Windows for every tool.

---

## Required Tools

| Tool | Why it's needed |
|---|---|
| Git | Version control for the entire project |
| GitHub | Remote hosting, backup, pull requests |
| Java 21 | LTS release: stable, long supported, the language the app is built in |
| Maven | Dependency management, builds, tests, packaging |
| MariaDB | The project's relational database |

VS Code is the editor used day to day, but any editor that fits the workflow is fine. It's not a hard requirement like the five above.

---

## Installing the Tools

### Git

> **Purpose:**
>
> Version control for every file in this project. Everything downstream (branches, commits, GitHub) depends on it existing first.

**Quick Reference**

| OS | Command |
|---|---|
| 🟢 Arch Linux | `sudo pacman -S git` |
| ⚪ Ubuntu/Debian | `sudo apt update && sudo apt install git` |
| ⚪ macOS | `brew install git` |
| ⚪ Windows | `winget install --id Git.Git -e` |

**Step 1: Check if already installed**

```bash
git --version
```

Expected output: `git version 2.43.0` (or similar). Any version number = already installed, skip to Step 3.

**Step 2: Install**

<details open>
<summary>🟢 Arch Linux</summary>

```bash
sudo pacman -S git
```

Expect a dependency list, then `Proceed with installation? [Y/n]`, type `y`.

</details>

<details>
<summary>⚪ Ubuntu/Debian</summary>

```bash
sudo apt update
sudo apt install git
```

`apt update` refreshes the package index first. Skipping it risks installing a stale version or a "package not found" error.

</details>

<details>
<summary>⚪ macOS</summary>

```bash
brew install git
```

Needs Homebrew already installed. If `brew` itself isn't found, install Homebrew from brew.sh first.

> [!NOTE]
>
> - On a brand-new Mac, running any `git` command for the first time may pop up a system dialog offering to install Apple's Command Line Tools instead.
>
> - Click **Install**, wait a few minutes, then re-check. Git is usually already there afterward.

</details>

<details>
<summary>⚪ Windows</summary>

```powershell
winget install --id Git.Git -e
```

If `winget` itself isn't recognized, update **App Installer** from the Microsoft Store.

</details>

**Step 3: Verify**

```bash
git --version
```

Still not found right after a successful-looking install? Close and reopen the terminal. PATH only refreshes on a new session.

<details>
<summary>🔧 Troubleshooting</summary>

| Symptom | What's happening | Fix |
|---|---|---|
| `error: failed to synchronize all databases` (Arch) | Local package index is stale | `sudo pacman -Syu`, then retry |
| `warning: git ... up to date -- skipping` (Arch) | Already installed and current | Nothing to do, move on |
| `E: Unable to locate package git` (Ubuntu) | Index wasn't refreshed | `sudo apt update`, confirm no errors, retry |
| `git is already the newest version` (Ubuntu) | Already installed | Nothing to do, move on |
| `E: Could not get lock /var/lib/dpkg/lock-frontend` (Ubuntu) | Another apt process is running | Wait a minute, retry |
| `Warning: git ... already installed and up-to-date` (macOS) | Already installed | Nothing to do, move on |
| `'winget' is not recognized` (Windows) | App Installer is outdated or missing | Update it via Microsoft Store |
| `Installer failed with exit code 1603` (Windows) | A previous partial Git install exists | Uninstall existing Git via Settings → Apps, restart, retry |

</details>

---

### Java 21

> **Purpose:**
>
> The language and runtime the whole application runs on.

**Quick Reference**

| OS | Command |
|---|---|
| 🟢 Arch Linux | `sudo pacman -S jdk21-openjdk` |
| ⚪ Ubuntu/Debian | `sudo apt install openjdk-21-jdk` |
| ⚪ macOS | `brew install openjdk@21` (extra step required, see below) |
| ⚪ Windows | `winget install --id EclipseAdoptium.Temurin.21.JDK -e` |

**Step 1: Check what's already there**

```bash
java -version
javac -version
```

Checked separately on purpose. `java` can exist without `javac` (a JRE without a full JDK). Both should show `21.x.x`.

**Step 2: Install**

<details open>
<summary>🟢 Arch Linux</summary>

```bash
sudo pacman -S jdk21-openjdk
```

Arch can hold multiple JDKs side by side. Check which one is active:

```bash
sudo archlinux-java status
```

If `java-21-openjdk` is listed but not marked current:

```bash
sudo archlinux-java set java-21-openjdk
```

</details>

<details>
<summary>⚪ Ubuntu/Debian</summary>

```bash
sudo apt install openjdk-21-jdk
```

Multiple Java versions installed? Pick the active one:

```bash
sudo update-alternatives --config java
```

Select the number next to `21` from the list shown.

</details>

<details>
<summary>⚪ macOS</summary>

```bash
brew install openjdk@21
```

> [!IMPORTANT]
>
> The install output ends with a block starting **"For the system Java wrapper to find this JDK, symlink it with..."**.
> 
> Read it and run that exact command. Java is "keg-only" in Homebrew (multiple versions can't share one symlink automatically).
> 
> Skipping this is the single most common trip-up on macOS: `java -version` will still look wrong even though Homebrew reported success.

</details>

<details>
<summary>⚪ Windows</summary>

```powershell
winget install --id EclipseAdoptium.Temurin.21.JDK -e
```

Open a **new** terminal window afterward. An already-open one won't see the updated PATH.

</details>

**Step 3: Verify and set JAVA_HOME**

```bash
java -version
javac -version
```

Both should report `21.x.x`. If Maven later reports the wrong Java version despite this being correct, set `JAVA_HOME`:

| OS | Set JAVA_HOME |
|---|---|
| 🟢 Arch | Usually unnecessary. If needed: `export JAVA_HOME=/usr/lib/jvm/java-21-openjdk` in `~/.bashrc` |
| ⚪ Ubuntu/Debian | `export JAVA_HOME=/usr/lib/jvm/java-21-openjdk-amd64` in `~/.bashrc` |
| ⚪ macOS | `export JAVA_HOME=$(/usr/libexec/java_home -v 21)` in `~/.zshrc` |
| ⚪ Windows | System Properties → Environment Variables → New system variable `JAVA_HOME`, pointing at the install folder |

Reopen the terminal (or `source ~/.bashrc`) after editing any shell config file.

<details>
<summary>🔧 Troubleshooting</summary>

| Symptom | What's happening | Fix |
|---|---|---|
| `java` works but `javac` says not found | Only a JRE is installed, no compiler | Install the full JDK package, not a JRE-only one |
| Both show a different version (e.g. 17) | An older JDK exists alongside | Install 21 too, then set it active per Step 2 |
| `E: Unable to locate package openjdk-21-jdk` (Ubuntu) | Older Ubuntu release, repos may not carry Java 21 | `sudo apt update` first; if still missing, the release is too old for this package name, flag it back |
| Ubuntu/apt installed an older JDK as a dependency of something else | A different package pulled in its own Java | Re-run `update-alternatives --config java`, pick 21 |
| macOS: `java -version` still wrong after install | The symlink step was skipped | Re-run the exact command Homebrew printed after installing |

</details>

---

### Maven

> **Purpose:**
> 
> Builds the project, manages dependencies, runs tests, packages the app.

**Quick Reference**

| OS | Command |
|---|---|
| 🟢 Arch Linux | `sudo pacman -S maven` |
| ⚪ Ubuntu/Debian | `sudo apt install maven` |
| ⚪ macOS | `brew install maven` |
| ⚪ Windows | No reliable package, manual install, see below |

**Step 1: Check**

```bash
mvn -version
```

Check **two** lines in the output: the Maven version, and the Java version printed underneath it. Maven can be installed and working, but silently pointed at the wrong Java version.

**Step 2: Install**

<details open>
<summary>🟢 Arch Linux</summary>

```bash
sudo pacman -S maven
```

</details>

<details>
<summary>⚪ Ubuntu/Debian</summary>

```bash
sudo apt install maven
```

> [!NOTE]
>
> This can sometimes pull in an older JDK as a dependency and quietly make it the system default. Re-check `java -version` right after this step.

</details>

<details>
<summary>⚪ macOS</summary>

```bash
brew install maven
```

Not keg-only, so no extra symlink step is needed, unlike Java above.

</details>

<details>
<summary>⚪ Windows: manual install</summary>

> [!NOTE]
>
> There is no official, reliable winget package for Maven, only an old, unresolved request. Manual install is the correct path here, not a missing shortcut.

1. Go to `maven.apache.org/download.cgi`.
2. Download the **Binary zip archive** (not the source archive).
3. Extract it somewhere permanent, e.g. `C:\Program Files\Apache\maven`.
4. Add its `bin` folder to PATH: System Properties → Environment Variables → `Path` (System variables) → Edit → New → paste the full path to the `bin` folder.
5. Open a **new** terminal window.

</details>

**Step 3: Verify**

```bash
mvn -version
```

Confirm both the Maven version and Java version lines look correct.

<details>
<summary>🔧 Troubleshooting</summary>

| Symptom | What's happening | Fix |
|---|---|---|
| Maven version shown, Java line shows the wrong version | `JAVA_HOME` points elsewhere | Fix `JAVA_HOME` per the Java 21 section above |
| Windows: `mvn` still not recognized after manual install | PATH entry points at the wrong folder | Confirm it points exactly at the `bin` folder, not its parent |

</details>

---

### MariaDB

> **Purpose:**
>
> The relational database the whole app depends on for every piece of student/department data.

**Quick Reference**

| OS | Commands |
|---|---|
| 🟢 Arch Linux | `sudo pacman -S mariadb` then `sudo mariadb-install-db ...` then `sudo systemctl enable --now mariadb` |
| ⚪ Ubuntu/Debian | `sudo apt install mariadb-server` (auto-starts) |
| ⚪ macOS | `brew install mariadb` then `brew services start mariadb` |
| ⚪ Windows | `winget install --id MariaDB.Server -e` (auto-starts) |

**Step 1: Check**

```bash
mysql --version
```

MariaDB ships client tools under the `mysql` name for compatibility, expected, not a mix-up. Look for "MariaDB" in the output.

**Step 2: Install**

<details open>
<summary>🟢 Arch Linux (the most manual of the four)</summary>

```bash
sudo pacman -S mariadb
```

> [!WARNING]
>
> - Before starting the service, initialize the data directory.
>
> - Arch does **not** do this automatically, unlike the other three OSes.
>
> - Skipping this step is the single most common MariaDB failure on Arch.

```bash
sudo mariadb-install-db --user=mysql --basedir=/usr --datadir=/var/lib/mysql
```

Then start and enable it:

```bash
sudo systemctl enable --now mariadb
sudo systemctl status mariadb
```

Expect a green `active (running)` line.

</details>

<details>
<summary>⚪ Ubuntu/Debian</summary>

```bash
sudo apt install mariadb-server
```

This initializes the data directory and starts the service automatically. No separate install-db step needed. Verify with `sudo systemctl status mariadb`.

</details>

<details>
<summary>⚪ macOS</summary>

```bash
brew install mariadb
brew services start mariadb
```

Verify with `brew services list`. `mariadb` should show `started`.

</details>

<details>
<summary>⚪ Windows</summary>

```powershell
winget install --id MariaDB.Server -e
```

Sets up and starts a Windows service automatically. Check via the *Services* app.

</details>

**Step 3: Secure the installation**

All four OSes, same command (Windows: run from the MariaDB install folder's bin directory):

```bash
sudo mysql_secure_installation
```

Expected prompts, in this order:

| # | Prompt | Answer for this project |
|---|---|---|
| 1 | `Enter current password for root (enter for none):` | Press Enter (blank) |
| 2 | `Switch to unix_socket authentication [Y/n]` *(Linux only)* | `n`, the app uses its own separate user, not root |
| 3 | `Change the root password? [Y/n]` | `Y`, then set one |
| 4 | `Remove anonymous users? [Y/n]` | `Y` |
| 5 | `Disallow root login remotely? [Y/n]` | `Y` |
| 6 | `Remove test database and access to it? [Y/n]` | `Y` |
| 7 | `Reload privilege tables now? [Y/n]` | `Y` |

Ends with `Cleaning up... All done!`

<details>
<summary>🔧 Troubleshooting</summary>

| Symptom | What's happening | Fix |
|---|---|---|
| `Job for mariadb.service failed...` (Arch) | `mariadb-install-db` was skipped or failed | Check `sudo journalctl -xe` for the real error, or reset with `sudo rm -rf /var/lib/mysql/*` and redo the install-db step (only safe on a fresh setup) |
| `Address already in use` (any OS) | Something else is already using port 3306 | Identify: `sudo lsof -i :3306` (Linux/macOS) or `netstat -ano \| findstr :3306` (Windows). Stop that service, or change this one's port and update `DB_PORT` in `.env` to match |
| Forgot the root password just set | No simple recovery step exists | Every OS needs a special safe-mode restart to reset it, and the steps differ by OS, flag it back rather than guessing |

</details>

---

### VS Code

> **Purpose:**
>
> The editor used day to day. Not required by the project itself (any editor works), but included here for completeness.

**Quick Reference**

| OS | Command |
|---|---|
| 🟢 Arch Linux | `yay -S visual-studio-code-bin` (AUR) |
| ⚪ Ubuntu/Debian | `sudo snap install code --classic` |
| ⚪ macOS | `brew install --cask visual-studio-code` |
| ⚪ Windows | `winget install --id Microsoft.VisualStudioCode -e` |

**Step 1: Check**

```bash
code --version
```

**Step 2: Install**

<details open>
<summary>🟢 Arch Linux</summary>

```bash
yay -S visual-studio-code-bin
```

Not in the official repos. Lives in the AUR. No `yay` set up yet? Grab the `.tar.gz` directly from code.visualstudio.com instead, or set up an AUR helper first (its own separate topic).

</details>

<details>
<summary>⚪ Ubuntu/Debian</summary>

```bash
sudo snap install code --classic
```

</details>

<details>
<summary>⚪ macOS</summary>

```bash
brew install --cask visual-studio-code
```

</details>

<details>
<summary>⚪ Windows</summary>

```powershell
winget install --id Microsoft.VisualStudioCode -e
```

</details>

**Step 3: Verify**

Inside a project folder:

```bash
code .
```

Should open VS Code with that folder loaded.

<details>
<summary>🔧 Troubleshooting</summary>

| Symptom | What's happening | Fix |
|---|---|---|
| `error: too early for operation, device not yet seeded` (Ubuntu, right after fresh install) | snapd hasn't finished starting | Wait 30-60 seconds, retry |
| `code` not recognized right after install | PATH not refreshed | Open a new terminal window |

</details>

---

## GitHub Account and SSH Key

> **Purpose:**
>
> Push and pull without typing a password every time.

**Step 1: Create an account**

A free account at github.com, if you don't already have one.

**Step 2: Check for an existing SSH key**

```bash
ls -al ~/.ssh
```

Files like `id_ed25519` and `id_ed25519.pub` already there? Skip to Step 4.

**Step 3: Generate a key**

```bash
ssh-keygen -t ed25519 -C "your_email@example.com"
```

Expected prompts: a save location (Enter accepts the default) and an optional passphrase (Enter twice for none, or set one).

**Step 4: Add it to GitHub**

```bash
cat ~/.ssh/id_ed25519.pub
```

Copy the entire output (starts with `ssh-ed25519`). On GitHub: Settings → SSH and GPG keys → New SSH key → paste → Add SSH key.

**Step 5: Test the connection**

```bash
ssh -T git@github.com
```

Expected: `Hi <username>! You've successfully authenticated, but GitHub does not provide shell access.`

> [!TIP]
>
> The first time you ever connect, you'll see `The authenticity of host 'github.com' can't be established... continue connecting (yes/no)?`.
>
> - Type `yes`.
>
> - This is normal and only happens once.

<details>
<summary>🔧 Troubleshooting</summary>

| Symptom | What's happening | Fix |
|---|---|---|
| `Overwrite (y/n)?` during key generation | A key already exists at that exact path | `y` replaces it, `n` cancels and keeps the old one |
| `Permission denied (publickey)` | Key wasn't pasted fully into GitHub, or isn't loaded | Re-check Step 4 was pasted as one complete line; try `ssh-add ~/.ssh/id_ed25519` |

</details>

---

## Database Setup

> **Purpose:**
>
> Create the actual `uddss` database and a dedicated app user, separate from root.

**Step 1: Connect as root**

```bash
sudo mysql -u root -p
```

Windows: open the MariaDB client the installer added, or run `mysql -u root -p` from its install folder. Prompt should change to `MariaDB [(none)]>`.

**Step 2: Create the database**

```sql
CREATE DATABASE uddss;
```

**Step 3: Create the app user and grant privileges**

```sql
CREATE USER 'uddss_app'@'localhost' IDENTIFIED BY 'choose_a_password';
GRANT ALL PRIVILEGES ON uddss.* TO 'uddss_app'@'localhost';
FLUSH PRIVILEGES;
```

> [!IMPORTANT]
>
> This grants every privilege type, but scoped only to the `uddss` database, nothing else on the server. That's the trade-off chosen here: simpler setup over tightly scoped permissions. Worth revisiting if this same database ever ends up serving the real, multi-client version of the system rather than just this one machine.

**Step 4: Verify from outside**

```sql
EXIT;
```

```bash
mysql -u uddss_app -p uddss
```

Should log straight in, prompt shows `MariaDB [uddss]>`.

<details>
<summary>🔧 Troubleshooting</summary>

| Symptom | What's happening | Fix |
|---|---|---|
| `Access denied for user 'root'@'localhost'` | Depends how `mysql_secure_installation` was answered | Try without `sudo` if unix_socket auth was chosen, with `sudo` if not |
| `database exists` on `CREATE DATABASE` | Already created from an earlier attempt | Not an error, continue |
| `Operation CREATE USER failed` | User already exists | `DROP USER 'uddss_app'@'localhost';` and redo, or just re-run `GRANT`/`FLUSH` |
| `Access denied` when logging in as `uddss_app` | Password typo, or `FLUSH PRIVILEGES` was skipped | Redo Step 3 carefully |

</details>

---

## Environment Variables

`.env.example` lists every setting the app needs. Copy it to `.env` and fill in real values.

> [!WARNING]
>
> Only `.env.example` ever gets committed. `.env` itself never does.

| Variable | What it's for |
|---|---|
| `DB_HOST` | Where MariaDB is running. `localhost` for your own machine. |
| `DB_PORT` | MariaDB's port. Default `3306`. |
| `DB_NAME` | `uddss`, from Database Setup above. |
| `DB_USER` | `uddss_app`, from Database Setup above. |
| `DB_PASSWORD` | That user's password. |
| `APP_ENV` | Which mode the app runs in, e.g. `development`. |
| `APP_LOG_LEVEL` | How much detail gets logged, e.g. `INFO`. |
| `MAIL_HOST`, `MAIL_PORT`, `MAIL_USERNAME`, `MAIL_PASSWORD` | For email notifications. Not used yet, reserved for later. |

---

## Build and Run

**Step 1: Clone**

```bash
git clone git@github.com:ouhidaayoub/uddss.git
cd uddss
```

**Step 2: Environment**

```bash
cp .env.example .env
```

Fill in `.env` with the real values from Database Setup.

**Step 3: Build**

```bash
mvn clean install
```

`clean` clears old build output, `install` compiles, tests, and packages. Expected end: `[INFO] BUILD SUCCESS`.

**Step 4: Run**

```bash
mvn javafx:run
```

Should open the JavaFX window directly.

> [!NOTE]
>
> **🟢 WSL2/Arch specific:**
>
> - WSL2 needs its GUI layer (WSLg) active to show the window at all.
>
> - Check with `echo $WAYLAND_DISPLAY`. Nothing printed means it's likely off.
>
> - Fix, from Windows itself (not inside WSL): `wsl --update`, then `wsl --shutdown`, reopen the Arch terminal, retry.

<details>
<summary>🔧 Troubleshooting</summary>

| Symptom | What's happening | Fix |
|---|---|---|
| `Permission denied (publickey)` on clone | SSH key isn't set up correctly | Revisit the GitHub Account and SSH Key section |
| `BUILD FAILURE` with a compile error | Something doesn't compile | Read the error line directly above `BUILD FAILURE`. It names the exact file and line |
| `BUILD FAILURE`, "Could not resolve dependencies" | Maven can't reach its remote repository | Check internet connection; restricted networks (school wifi) may need Maven proxy settings |
| `BUILD SUCCESS` but test failures listed above it | Build finished, something's logically broken | Read the test failure output before moving on |
| `"JavaFX runtime components are missing"` | App was launched a different way than intended | Should not happen via `mvn javafx:run`. This usually means the `.jar` was double-clicked or run directly with `java -jar` instead |
| Window opens then immediately closes, no error | Possibly a stale build | `mvn clean javafx:run` instead, forces a clean rebuild |

</details>

---

## Optional Tools

| Tool | Purpose |
|---|---|
| Docker | Deployment and dev automation, later |
| ChatGPT / Claude | Documentation, reviews, debugging, learning |
| Notion | Planning, research, organization |

---

## Secrets

> [!WARNING]
>
> Passwords, tokens, API keys, anything sensitive. None of that goes into Git, ever.

Local secrets live in a local `.env` file. Only `.env.example` gets committed.

---

## Documentation Policy

The Git repository is the source of truth for this project. Official documentation should end up inside the repo. Personal notes, drafts, and rough research can live elsewhere first, before making their way into the real docs.

---

## Goal

Clone the repo, install the required tools, set up the environment, and the project should build and run without a fight. If that ever stops being true, this document needs an update.
