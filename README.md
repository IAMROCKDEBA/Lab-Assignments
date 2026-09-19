# Lab Assignments

This repository holds my Cloud Computing lab submissions for the semester. Each week has its own folder with the report (Markdown + PDF) and screenshots.

## Student Details

| Field | Details |
| --- | --- |
| Name | TODO: Add your name |
| Roll Number | TODO: Add your roll number |
| Section | BTECH_CSE_SECB_2023 |
| University | Adamas University |
| GitHub Repository | https://github.com/IAMROCKDEBA/Lab-Assignments |

## Lab Index

| Week | Experiment | Report | Status |
| --- | --- | --- | --- |
| Week 01 | Installation of Hypervisors and initiation of VMs with image file (Oracle VirtualBox + Ubuntu 26.04.1 LTS) | [PDF](Week-01/Lab-1-Report.pdf) · [Markdown](Week-01/Lab-1-VM-Setup-Report.md) | Completed |

## Repository Structure

```text
Lab-Assignments/
├── Week-01/
│   ├── Lab-1-Assignment.pdf        # assignment handout
│   ├── Lab-1-Report.pdf            # submitted report
│   ├── Lab-1-VM-Setup-Report.md    # report source
│   ├── vm-configuration.txt        # VBoxManage showvminfo dump
│   ├── README.md
│   └── screenshots/
├── scripts/
│   ├── build-report-pdf.ps1        # regenerate a week's PDF from its Markdown
│   └── report-html.js
├── setup/
│   ├── system-check-summary.md
│   └── windows-prerequisites-check.ps1
├── submission-details.csv
└── README.md
```

## Regenerating a PDF

After editing a report's Markdown (for example to fill in the student details), run from the repository root:

```powershell
.\scripts\build-report-pdf.ps1 -Week Week-01 -Report Lab-1-VM-Setup-Report.md -Pdf Lab-1-Report.pdf
```

## Official Download Links

- Oracle VirtualBox: https://www.virtualbox.org/wiki/Downloads
- Ubuntu Desktop ISO: https://ubuntu.com/download/desktop

ISO files and VirtualBox disk images are not committed (see `.gitignore`).
