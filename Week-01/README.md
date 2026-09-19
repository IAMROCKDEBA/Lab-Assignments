# Week 01 — Installation of Hypervisors and Initiation of VMs with Image File

**Status:** Completed on 19 September 2026.

- Assignment: [Lab-1-Assignment.pdf](Lab-1-Assignment.pdf)
- Report (PDF): [Lab-1-Report.pdf](Lab-1-Report.pdf)
- Report (Markdown source): [Lab-1-VM-Setup-Report.md](Lab-1-VM-Setup-Report.md)
- VM configuration dump: [vm-configuration.txt](vm-configuration.txt)

## Summary

| Item | Value |
| --- | --- |
| Hypervisor | Oracle VirtualBox 7.2.18 |
| Guest image | Ubuntu 26.04.1 LTS Desktop (amd64) ISO |
| VM | `Ubuntu-Cloud-Lab` — 4 vCPU, 6144 MB RAM, 25 GB VDI (dynamic), NAT network |
| Guest kernel | 7.0.0-31-generic |
| Build tools | `build-essential` 12.12ubuntu2.26.04.2, gcc 15.2.0, GNU Make 4.4.1 |
| Kernel headers | `linux-headers-7.0.0-31-generic` |

## Screenshots

| # | Screenshot |
| --- | --- |
| 1 | [VirtualBox Manager](screenshots/01-virtualbox-manager.png) |
| 2 | [VM configuration with install media attached](screenshots/02-vm-configuration.png) |
| 3 | [Booting from Ubuntu ISO](screenshots/03-live-iso-boot.png) |
| 4 | [Ubuntu installer](screenshots/04-ubuntu-installing.png) |
| 5 | [Login screen](screenshots/05-ubuntu-login.png) |
| 6 | [Ubuntu desktop](screenshots/06-ubuntu-desktop.png) |
| 7 | [VM verification](screenshots/07-vm-verification.png) |
| 8 | [apt update + build-essential + linux-headers](screenshots/08-apt-update-and-install.png) |
| 9 | [Build tools verified](screenshots/09-build-tools-verified.png) |
| 10 | [VM running after install](screenshots/10-vm-running-after-install.png) |
