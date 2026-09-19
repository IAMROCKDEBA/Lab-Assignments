# Week 02 — Connecting Two VMs Using a VirtualBox NAT Network

**Status:** Completed on 19 September 2026.

- Assignment: [Lab-2-Assignment.docx](Lab-2-Assignment.docx)
- Report (PDF): [Lab-2-Report.pdf](Lab-2-Report.pdf)
- Report (Markdown source): [Lab-2-NAT-Network-Report.md](Lab-2-NAT-Network-Report.md)
- Network configuration export: [network-configuration.txt](network-configuration.txt)

## Summary

| Item | VM 1 `Ubuntu-Cloud-Lab` | VM 2 `Ubuntu-Cloud-Lab-2` |
| --- | --- | --- |
| IP on default NAT | 10.0.2.15 | 10.0.2.15 |
| IP on NAT Network `CloudLabNAT` | 192.168.50.5 | 192.168.50.4 |
| Ping to the other VM | 5/5 received, 0% loss | 5/5 received, 0% loss |

NAT Network: `CloudLabNAT`, 192.168.50.0/24, gateway 192.168.50.1, DHCP enabled.

## Screenshots

| # | Screenshot |
| --- | --- |
| 1 | [Both VMs on default NAT — `ip a`](screenshots/01-two-vms-default-nat-ip-a.png) |
| 2 | [Two VMs in VirtualBox Manager](screenshots/02-two-vms-in-virtualbox.png) |
| 3 | [NAT Network created](screenshots/03-nat-network-created.png) |
| 4 | [VM 1 attached to NAT Network](screenshots/04-vm1-attached-to-nat-network.png) |
| 5 | [VM 2 attached to NAT Network](screenshots/05-vm2-attached-to-nat-network.png) |
| 6 | [VMs pinging each other](screenshots/06-ping-between-vms-success.png) |
| 7 | [VM 1 → VM 2 ping](screenshots/07-vm1-ping-vm2.png) |
| 8 | [VM 2 → VM 1 ping](screenshots/08-vm2-ping-vm1.png) |
