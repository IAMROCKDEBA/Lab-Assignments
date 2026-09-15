# System Check Summary

Checked on: 2026-09-15

## Host System

| Item | Result |
| --- | --- |
| Operating System | Microsoft Windows 11 Home Single Language, 64-bit |
| CPU | 12th Gen Intel(R) Core(TM) i7-12700H |
| CPU Cores / Logical Processors | 14 cores / 20 logical processors |
| RAM | 15.63 GB |
| C: Drive Free Space | 540.65 GB |
| R: Drive Free Space | 255.66 GB |
| Git | Installed |
| Oracle VirtualBox | Not found on PATH |
| Hardware Virtualization | Reported as disabled |

## Action Needed Before Creating the VM

1. Enable hardware virtualization in BIOS/UEFI.
2. Install Oracle VirtualBox.
3. Download the Ubuntu Desktop ISO.
4. Create the Ubuntu VM and capture the screenshots listed in `Week-01/README.md`.

## Notes

The laptop resources are sufficient for the recommended VM configuration, but VirtualBox may fail to start a 64-bit Ubuntu VM until virtualization is enabled.
