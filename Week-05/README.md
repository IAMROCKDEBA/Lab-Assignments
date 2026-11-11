# Week 05 — Cloud Scheduling with CloudSim Plus

**Status:** Completed on 11 November 2026.

- Assignment: [Lab-5-Assignment.pdf](Lab-5-Assignment.pdf)
- Report (PDF): [Lab-5-Report.pdf](Lab-5-Report.pdf)
- Report (Markdown source): [Lab-5-Cloud-Scheduling-Report.md](Lab-5-Cloud-Scheduling-Report.md)
- Final project that was run: [project/](project/) (`pom.xml`, `SchedulingExperiment.java`)
- Exactly as printed in the manual: [original-from-manual/](original-from-manual/)
- The three fixes needed to make it run: [patches/](patches/)

## Summary

| Step | Command | Result |
| --- | --- | --- |
| Update | `sudo apt update`, `sudo apt upgrade -y` | 221 packages upgraded (`openvpn` skipped: mirror returns 403) |
| Toolchain | `sudo apt install openjdk-17-jdk maven git -y` | Java/javac 17.0.21, Maven 3.9.12, Git 2.53.0 |
| Project | `mkdir`, `nano pom.xml`, `nano SchedulingExperiment.java` | typed as in the manual; checksum-verified |
| Dependencies | `mvn dependency:resolve`, `mvn clean` | BUILD SUCCESS |
| Compile | `mvn clean compile` | BUILD SUCCESS (javac release 17) |
| Run | `mvn exec:java -Dexec.mainClass="lab.SchedulingExperiment" -Dexec.classpathScope=compile` | scenarios A–D: 4 / 4 cloudlets SUCCESS, 0.10 → 20.10 |

## The manual needed three fixes

The code in the manual does not run as printed. Each failure was kept as a screenshot before it was fixed.

| # | Problem | Fix |
| --- | --- | --- |
| 1 | `pom.xml` asks for CloudSim Plus 8.5.5, but the code uses the 7.x API (`org.cloudbus.cloudsim.*`, `CloudSim`, `getExecStartTime()`), so it does not compile | dependency version changed to **7.3.0** (code untouched) |
| 2 | `IllegalArgumentException`: the same `CloudletScheduler` object was given to both VMs | one scheduler per VM, via a `Supplier` |
| 3 | Cloudlets asked for 100% of the VM's RAM and bandwidth, so the second cloudlet on each VM got finish time `9223372076.74` | cloudlet RAM and bandwidth utilization set to 25% |

Details and the before/after output are in the report, section 5.

## Screenshots

Thirty-five screenshots are in [screenshots/](screenshots/), numbered in the order things happened. The full list with captions is in section 7 of the report. The main ones:

| # | Screenshot |
| --- | --- |
| 1–3 | [apt update](screenshots/01-apt-update.png) · [apt upgrade](screenshots/02-apt-upgrade.png) · [remaining upgradable](screenshots/03-remaining-upgradable.png) |
| 4–5 | [install Java/Maven/Git](screenshots/04-install-java-maven-git.png) · [version checks](screenshots/05-version-checks.png) |
| 6–14 | [folders](screenshots/06-create-project-folders.png) · [pom.xml](screenshots/07-nano-pom-xml.png) · [Java code](screenshots/09-nano-java-code-1of5.png) (5 pages) · [saved](screenshots/14-nano-java-saved.png) |
| 15–24 | [resolve](screenshots/15-mvn-dependency-resolve-8-5-5.png) · [compile fails with 8.5.5](screenshots/17-compile-fails-8-5-5.png) · [pin 7.3.0](screenshots/22-pin-cloudsimplus-7-3-0.png) · [compile OK](screenshots/24-mvn-clean-compile-success.png) |
| 25–27 | [scheduler error](screenshots/25-run-fails-shared-scheduler.png) · [fix](screenshots/26-patch1-scheduler-per-vm-diff.png) |
| 28–30 | [Run 1 output](screenshots/28-run1-manual-command-output.png) · [summary](screenshots/29-run1-summary-all-scenarios.png) · [warnings](screenshots/30-run1-warnings.png) |
| 31–35 | [fix](screenshots/31-patch2-ram-bw-diff.png) · [Run 2 output](screenshots/33-run2-manual-command-output.png) · [summary](screenshots/34-run2-summary-all-scenarios.png) · [final layout](screenshots/35-final-project-layout.png) |
