# Week 03 — Network Emulation with Mininet

**Status:** Completed on 21 September 2026.

- Assignment: [Lab-3-Assignment.docx](Lab-3-Assignment.docx)
- Report (PDF): [Lab-3-Report.pdf](Lab-3-Report.pdf)
- Report (Markdown source): [Lab-3-Mininet-Report.md](Lab-3-Mininet-Report.md)
- Topology diagrams: [single,3](topology-single-3.png) · [tree,3](topology-tree-3.png)

## Summary

| Test | Command | Result |
| --- | --- | --- |
| Version | `sudo mn --version` | 2.3.0 |
| Built-in test | `sudo mn --test pingall` | 0% dropped (2/2 received) |
| single,3 | `sudo mn --topo single,3` → `links`, `pingall` | 3 links OK, 0% dropped (6/6 received) |
| tree,3 | `sudo mn --topo tree,3` → `links`, `pingall` | 14 links OK, 0% dropped (56/56 received) |

Environment: Ubuntu 26.04.1 LTS VM on VirtualBox 7.2.18, Mininet 2.3.0, Open vSwitch 3.7.1.

## Screenshots

| # | Screenshot |
| --- | --- |
| 0 | [Ubuntu VM in VirtualBox](screenshots/00-ubuntu-vm-in-virtualbox.png) |
| 1 | [Installing Mininet](screenshots/01-install-mininet.png) |
| 2 | [`mn --version` and `mn --test pingall`](screenshots/02-mn-version-and-test-pingall.png) |
| 3 | [single,3: links, nodes, pingall](screenshots/03-topo-single-3-links-pingall.png) |
| 4 | [single,3: net, dump, h1 ping h3](screenshots/04-topo-single-3-net-dump-ping.png) |
| 5 | [tree,3: links, pingall](screenshots/05-topo-tree-3-links-pingall.png) |
