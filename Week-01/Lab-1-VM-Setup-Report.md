# Cloud Computing Lab 1 Report

## Title

Creating an Ubuntu Virtual Machine Using Oracle VirtualBox

## Student Details

| Field | Details |
| --- | --- |
| Name | TODO: Add your name |
| Roll Number | TODO: Add your roll number |
| Section | BTECH_CSE_SECB_2023 |
| Course | Cloud Computing Lab |

## Objective

The objective of this lab is to create an Ubuntu virtual machine using Oracle VirtualBox on the host operating system.

## Software Used

| Software | Purpose | Link |
| --- | --- | --- |
| Oracle VirtualBox | Virtualization platform for creating and running the VM | https://www.virtualbox.org/wiki/Downloads |
| Ubuntu Desktop ISO | Guest operating system image | https://ubuntu.com/download/desktop |

## System Requirements Checked

| Requirement | Status |
| --- | --- |
| 64-bit processor | TODO |
| Hardware virtualization enabled | TODO |
| Minimum 6 GB free RAM recommended for Ubuntu Desktop | TODO |
| Minimum 25 GB free disk space | TODO |

## Procedure

1. Downloaded Oracle VirtualBox from the official VirtualBox download page.
2. Downloaded the Ubuntu Desktop ISO image for Intel/AMD 64-bit architecture from the official Ubuntu download page.
3. Opened Oracle VirtualBox and created a new virtual machine named `Ubuntu-Cloud-Lab`.
4. Selected Linux as the type and Ubuntu 64-bit as the version.
5. Allocated RAM and CPU cores according to available host system resources.
6. Created a dynamically allocated virtual hard disk with at least 25 GB capacity.
7. Attached the Ubuntu ISO image to the virtual optical drive.
8. Started the VM and followed the Ubuntu installation steps.
9. Restarted the VM after installation and logged in to the Ubuntu desktop.
10. Opened Terminal and verified the Ubuntu version using:

```bash
lsb_release -a
```

## Screenshots

Add the required screenshots in `Week-01/screenshots/` and reference them below.

| Step | Screenshot |
| --- | --- |
| VirtualBox installed/opened | TODO |
| VM settings | TODO |
| Ubuntu ISO selected | TODO |
| Ubuntu installer | TODO |
| Ubuntu desktop | TODO |
| Ubuntu version verification | TODO |

## Result

TODO: Complete the Ubuntu VM installation, add screenshots, and then confirm that the virtual machine was created successfully.

## Conclusion

This lab demonstrated the process of setting up an Ubuntu virtual machine for Cloud Computing lab work. The VM can now be used for future lab assignments.
