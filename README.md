"""# 🎰 Linux Russian Roulette (Java Edition)

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![OS: Linux](https://img.shields.io/badge/OS-Linux-orange.svg)](https://www.linux.org/)
[![Safety: Absolute Zero](https://img.shields.io/badge/Safety-Absolute%20Zero-red.svg)]()

A highly volatile, purely chaotic text-based party game written in Java for Linux systems. It brings the thrilling experience of Russian Roulette straight to your filesystem. Run it as `root` and let destiny decide the fate of your OS.

> **⚠️ DISCLOSURE & DISCLAIMER (AS IS):** > This software is a joke/prank project. It contains highly destructive payloads including system-bricking commands (`rm -rf`). It is provided **"AS IS"**, without warranty of any kind. The author holds absolute zero liability for lost data, obliterated filesystems, vaporized kernel spaces, or any other digital or emotional damage. **Do not run this on any machine you care about.**

---

## 🛠️ Features (The Bullets)

When you pull the trigger, the chamber rotates, and you receive one of the following "bullets":

1. **Empty Chamber (`NoAction`)** — Congratulations, you survived! You get to live another day.
2. **Fork Bomb (`ForkBomb`)** — Spawns infinite Java and Bash processes to exhaust system resources until the machine locks up entirely.
3. **Kernel Panic (`KernelPanic`)** — Triggers an immediate hard crash via SysRq (`/proc/sysrq-trigger`), simulating a cold, unyielding blue screen / panic.
4. **Root Purge (`RmRfAll`)** — Deletes everything in the root filesystem *except* `/sys`, meaning your data is gone, but the UEFI variables might just survive.
5. **System Wipe (`RmRfSys`)** — Nukes the `/sys` directory, instantly bricking the running OS state.
6. **The Barmin Patch (`RmRfAllAndSys`)** — The ultimate destructive payload: `rm -rf / --no-preserve-root`. Total annihilation.

### 🪤 Anti-Cheat Mechanism
Think you can just `Ctrl+C` your way out during the 10-second countdown? The application catches `InterruptedException` and **instantly drops a `RmRfSys` bullet** to punish cowards. 

---

## 🚀 How to Run (If you are brave or foolish)

### Prerequisites
* Linux OS (strictly enforced via runtime checks)
* Root privileges (UID 0 check)
* Java 17 or higher
