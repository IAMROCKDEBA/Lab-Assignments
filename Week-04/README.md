# Week 04 — Linear Topology with Five Switches (Mininet)

**Status:** Completed on 24 September 2026.

- Report (PDF): [Lab-4-Report.pdf](Lab-4-Report.pdf)
- Report (Markdown source): [Lab-4-Linear-Topology-Report.md](Lab-4-Linear-Topology-Report.md)
- Recorded terminal session: [linear5-session.log](linear5-session.log)
- Topology diagram: [topology-linear-5.png](topology-linear-5.png)

## Problem

Simulate a network in which multiple switches are connected sequentially, each switch linked to the next, using **five switches in a linear topology**; show and explain every link and the communication flow.

## Summary

| Step | Command | Result |
| --- | --- | --- |
| Clean up | `sudo mn -c` | Cleanup complete |
| Build topology | `sudo mn --topo linear,5` | 5 switches (s1–s5), 5 hosts (h1–h5), 9 links |
| Inspect | `nodes`, `links`, `net`, `dump` | All 9 links `(OK OK)` |
| Connectivity | `pingall` | 0% dropped (20/20 received) |
| Longest path | `h1 ping -c 4 h5` | 4/4 received across all 5 switches |
| Link failure | `link s3 s4 down` → `pingall` | 60% dropped (8/20) — chain split into {h1,h2,h3} and {h4,h5} |
| Recovery | `link s3 s4 up` → `pingall` | 0% dropped (20/20 received) |

## The 9 links

| Link | Connection | Role |
| --- | --- | --- |
| L1–L5 | `hN-eth0 ↔ sN-eth1` | Access link: each host to its own switch |
| L6 | `s1-eth2 ↔ s2-eth2` | Backbone: switch 1 → switch 2 |
| L7 | `s2-eth3 ↔ s3-eth2` | Backbone: switch 2 → switch 3 |
| L8 | `s3-eth3 ↔ s4-eth2` | Backbone: switch 3 → switch 4 (middle of the chain) |
| L9 | `s4-eth3 ↔ s5-eth2` | Backbone: switch 4 → switch 5 |

## Screenshots

| # | Screenshot |
| --- | --- |
| 1 | [Mininet cleanup](screenshots/01-mininet-cleanup.png) |
| 2 | [Creating linear,5](screenshots/02-create-linear5.png) |
| 3 | [nodes, links, net](screenshots/03-nodes-links-net.png) |
| 4 | [dump, pingall, h1 ping h5](screenshots/04-dump-pingall-h1-h5.png) |
| 5 | [Link s3–s4 down: 60% dropped](screenshots/05-link-s3-s4-down-pingall.png) |
| 6 | [Link restored: 0% dropped](screenshots/06-link-restored-pingall.png) |
