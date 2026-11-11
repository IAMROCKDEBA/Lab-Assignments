# Cloud Computing Lab — Experiment 6

## Familiarization and Usage of Cloud Services Using AWS and Open-Source Cloud Tools

| Field | Details |
| --- | --- |
| Name | TODO: Add your name |
| Roll Number | TODO: Add your roll number |
| Section | BTECH_CSE_SECB_2023 |
| Course | Cloud Computing Lab (CSE12045) |
| University | Adamas University (CSE, SOET) |
| Date of completion | 11 November 2026 |

> **Privacy note.** This report is stored in a public repository, and the lab manual says not to share sensitive account details. In every screenshot the AWS account ID, account name, e-mail address, canonical user ID and the names of unrelated resources in the account (other S3 buckets, IAM users and policies) are covered with black boxes. No password, access key or secret key was used, typed or captured.

## 1. Aim

To become familiar with basic cloud services and perform basic cloud operations using Amazon Web Services (AWS), Ubuntu Linux, Oracle VirtualBox and the AWS Command Line Interface (CLI).

| Task | What was done | Evidence |
| --- | --- | --- |
| 1. Virtual machine setup | Ubuntu 26.04.1 LTS running in VirtualBox; updated; basic utilities installed; basic Linux commands run | Figures 1–6 |
| 2. Cloud storage | Private S3 bucket created; file uploaded, checked and deleted; bucket deleted | Figures 7–23 |
| 3. Cloud service exploration | IAM, EC2 and VPC explored in the AWS Console | Figures 24–43 |
| 4. Monitoring and CLI | CloudWatch explored; AWS CLI commands run in CloudShell | Figures 44–56 |
| Cost check | Billing dashboard opened after the practical | Figure 57 |

## 2. Theory

| Service | What it is | Used here for |
| --- | --- | --- |
| **Oracle VirtualBox** | A hypervisor that runs virtual machines on one physical computer | The Ubuntu VM (Task 1) |
| **Amazon S3** | Object storage: files ("objects") are kept in named containers ("buckets") and fetched over the internet | Task 2 |
| **AWS IAM** | Controls who can do what in an AWS account, through users, groups, roles and policies | Task 3A |
| **Amazon EC2** | Virtual servers ("instances") rented from AWS | Task 3B |
| **Amazon VPC** | A logically isolated virtual network inside AWS (subnets, route tables, gateways, security groups) | Task 4A |
| **Amazon CloudWatch** | Collects metrics and logs and raises alarms when a metric crosses a threshold | Task 3D |
| **AWS CLI / CloudShell** | Command-line access to the same services; CloudShell is a browser terminal already signed in to the account | Task 4B |

An IAM policy is a JSON document. `Effect` says whether it allows or denies, `Action` lists the operations and `Resource` says what they apply to. The **principle of least privilege** means granting only the permissions a job really needs.

## 3. Requirements and environment

| Item | Value |
| --- | --- |
| Host | Windows 11, Oracle VirtualBox 7.2.18 |
| VM | `Ubuntu-Cloud-Lab`: Ubuntu 26.04.1 LTS, kernel 7.0.0-31-generic, 4 vCPU, about 5.3 GiB RAM visible, 25 GB disk |
| Browser | The Claude desktop app's built-in browser pane (AWS Console) |
| AWS Region | US East (N. Virginia) `us-east-1`, the Console's default region for the account |
| CLI | AWS CLI 2.39.6 (Python 3.14.8) in AWS CloudShell |
| Sample files | `lab-note.txt` (33 bytes) and `sample.txt` (27 bytes) |

## 4. Task 1: Virtual machine setup

The Ubuntu VM was created in Experiment 1 (see `Week-01/`: VirtualBox VM, Ubuntu installed from the checksum-verified ISO) and is the same machine used for Experiments 3–5, so Steps 1 and 2 of the manual ("Create a Virtual Machine", "Install Ubuntu") were already complete. The VM was started and used for this experiment.

| Step | Commands | Result |
| --- | --- | --- |
| Basic Linux commands | `whoami`, `hostname`, `lsb_release -a`, `uname -a`, `systemd-detect-virt`, `date`, `pwd`, `ls -l`, `df -h /`, `free -h`, `nproc`, `ip -br address` | User `student`, host `ubuntu-cloud-lab`, Ubuntu 26.04.1 LTS, `systemd-detect-virt` prints `oracle` (running under VirtualBox), 4 CPUs, 25 GB disk (35% used), 2 network adapters up (Figures 1–2) |
| 3. Update Ubuntu | `sudo apt update`, `sudo apt upgrade -y` | Package index refreshed; only 5 packages left, of which 4 are held back by Ubuntu's phased roll-out and `openvpn` cannot be downloaded because this network answers `403 Forbidden` for it (Figures 3–4). The same package failed in Experiment 5, and it is not used in this lab. |
| 4. Install basic utilities | `sudo apt install -y curl wget vim htop tree net-tools unzip` | Installed and verified with their `--version` outputs, together with Git 2.53.0 from Experiment 5 (Figures 5–6) |

The manual does not list which "basic utilities" to install, so the set above is my choice of the usual command-line tools.

## 5. Task 2: Cloud storage with Amazon S3

### Task 2A: AWS Management Console

The Console was opened (`console.aws.amazon.com`) and the **search bar** was used to locate a service: typing `S3` lists the S3 service first (Figures 7–8). Signing in was done by the account holder in the browser, including multi-factor authentication.

### Task 2B: Create, upload, check and delete (Figures 9–23)

| Step | What was done | Result |
| --- | --- | --- |
| Open S3 | Searched for S3 and opened it | General purpose buckets list (Figure 9) |
| Create bucket | Name `cse12045-cloud-lab6-student01-4829` (the manual's example name plus a number to make it globally unique), Region us-east-1, **Block all public access left ON**, default encryption **SSE-S3** left ON | "Successfully created bucket" (Figures 10–13) |
| Create sample file in Ubuntu | `mkdir cloud-lab6`, `cd cloud-lab6`, `echo "Cloud Computing Lab Experiment 6" > lab-note.txt`, `cat lab-note.txt` | File created; SHA-256 `3c0ba7ea…7758` (Figure 14) |
| Upload | Console **Upload → Add files → Upload** of `lab-note.txt` | "Upload succeeded", 1 file, 33.0 B (Figures 15–17) |
| Download and verify | Object selected, Download clicked (Figure 18); object detail page checked (Figure 19) | The object's ETag `a0da91df…9712` equals the MD5 of the original file, so its content is identical. The browser pane did not save a file to disk (see section 8), so the CLI download in Task 4B was used to check a real download. |
| Delete object | **Delete → type "permanently delete"** | "Successfully deleted objects", 1 object, 33.0 B (Figures 20–21) |
| Delete bucket | Bucket filtered to the one test bucket, **Delete → type the bucket name** | "Successfully deleted bucket" (Figures 22–23) |

Order of events: the manual lists the object/bucket deletion in Task 2 but uses the same bucket again in Task 4B, so the CLI steps (Task 4B) were done before the deletion in the Console.

The bucket was never public, and nothing is left in S3 from this experiment.

## 6. Task 3: Exploring IAM, EC2 and VPC

This task is an observation activity: no users, groups, roles, access keys, policies, instances or VPC resources were created, changed or deleted.

### Task 3A: IAM (Figures 24–29)

| Section | What was observed |
| --- | --- |
| Dashboard | Security recommendations: "Root user has MFA" and "Root user has no active access keys". Resources in the account: 0 user groups, 2 users, 5 roles, 2 policies. The Account ID and sign-in URL are hidden. |
| Users | 2 IAM users (names hidden), neither in a group; the list shows last activity, MFA and password age |
| User groups | 0 |
| Roles | 5 roles, all AWS service-linked roles (for example Organizations, Support, Trusted Advisor, SSO) |
| Policies | 1,603 policies, almost all "AWS managed" (written and maintained by AWS); the 2 "Customer managed" policies counted on the dashboard are the account's own (the one visible on the first page has its name hidden) |
| Policy structure | AWS-managed `AmazonS3ReadOnlyAccess` opened in JSON view: `"Version": "2012-10-17"`, one `Statement` with `"Effect": "Allow"`, `"Action"` of `s3:Get*`, `s3:List*`, `s3:Describe*`, `s3-object-lambda:Get*`, `s3-object-lambda:List*` and `"Resource": "*"` |

**Least privilege.** `AmazonS3ReadOnlyAccess` shows the idea: it can read and list every bucket but cannot upload, change or delete anything. A user who only has to look at files should get this and not full S3 access. The manual's example policy (`s3:ListBucket` on a single bucket) is narrower still, because it names the one bucket in `Resource`.

### Task 3B: EC2 (Figures 30–35)

The EC2 dashboard shows 0 running instances, 1 security group and the default VPC in `us-east-1`. The Instances page says "No instances in this region". **Launch instance** was opened and each section of the launch wizard was reviewed, up to the review stage; the instance was **not launched** (the manual only allows launching with the instructor's approval and a Free Tier-eligible configuration).

| Wizard section | What was shown |
| --- | --- |
| Name and tags | An instance name can be entered (`cse12045-lab6-demo` was typed but never submitted) |
| AMI | Quick Start list (Amazon Linux, macOS, Ubuntu, Windows, Red Hat, SUSE, Debian); default Amazon Linux 2023 (kernel 6.18), 64-bit x86, user name `ec2-user` |
| Instance type | `t3.micro`: 2 vCPU, 1 GiB memory; the page shows on-demand prices, for example Linux about 0.0104 USD per hour. This is why the manual warns that not every instance is free. |
| Key pair | A key pair is required to log in, and none was selected |
| Network settings | Default VPC, auto-assign public IP enabled, new security group with "Allow SSH traffic from Anywhere (0.0.0.0/0)" ticked by default and a warning that this allows all IP addresses; a safer setup limits SSH to known addresses |
| Storage | 1 × 8 GiB `gp3` root volume (3000 IOPS), not encrypted |

### Task 4A: VPC (Figures 36–43)

| Component | What was observed |
| --- | --- |
| Your VPCs | 1 VPC, state Available. This is the account's default VPC; it was not changed. |
| Subnets | 6 subnets, all in that VPC (a default VPC normally has one subnet per Availability Zone) |
| Route tables | 1 route table, the **main** one, linked to the VPC. Routes: `172.31.0.0/16 → local` and `0.0.0.0/0 → igw-…` (an internet gateway), both Active |
| Internet gateways | 1, state **Attached** to the default VPC |
| Security groups | 1, the `default` group. Inbound: 1 rule, All traffic. Outbound: 1 rule, IPv4 All traffic. (Standard default behaviour: inbound traffic is allowed from the group's own members; the Source column was off screen.) |

**How this fits the manual's architecture.** A subnet whose route table has a route to an internet gateway for `0.0.0.0/0` is a **public subnet**, which is what the default VPC provides. A **private subnet** would have no such route. The security group then decides which traffic may reach the instances.

## 7. Task 4: Monitoring and the AWS CLI

### Task 3D: CloudWatch (Figures 44–48)

| Section | What was observed |
| --- | --- |
| Overview | "You don't have any alarms, metrics or default dashboard" yet; the overview offers to configure the CloudWatch agent |
| Metrics | 184 metrics, grouped by service (namespace): Rekognition 6, STS 2, Usage 176. There are no EC2 metrics because there are no instances; with one, CPU utilisation would appear under EC2. |
| Dimensions | Opening the `Usage` namespace shows how metrics are subdivided by dimensions: "Class, Resource, ResourceId, Service, Type" (8) and "By AWS Resource" (175) |
| Alarms | 0 alarms. **Create alarm** opens a 4-step wizard: (1) specify metric and conditions (choose **Select metric**, then a threshold), (2) configure actions (for example notify an administrator), (3) add alarm details, (4) preview and create. An alarm moves between OK, In alarm and Insufficient data when its threshold condition is met. |

No alarm, dashboard or log group was created, to avoid charges.

### Task 4B: AWS CLI in CloudShell (Figures 49–56)

CloudShell (the manual's first option) gives a browser terminal that is already authenticated through the Console session, so no access keys were created, typed or stored. Installing the CLI in Ubuntu would have needed access keys, which the manual says must never appear in source code, screenshots or reports, so it was not done.

| Step | Command | Result |
| --- | --- | --- |
| 2 | `aws --version` | `aws-cli/2.39.6 Python/3.14.8 … exec-env/CloudShell` |
| 3 | `aws sts get-caller-identity` | Returns `UserId`, `Account` and `Arn` (hidden); the ARN ends in `:root`, so the session is the account's root user (see section 8) |
| 4 | `aws s3 ls` | Lists the account's buckets (one name hidden) including the test bucket |
| 5 | `mkdir cloud-lab6-cli`, `cd cloud-lab6-cli`, `echo "AWS CLI Cloud Storage Test" > sample.txt` | `sample.txt`, 27 bytes |
| 6 | `aws s3 cp sample.txt s3://cse12045-cloud-lab6-student01-4829/sample.txt` | `upload: ./sample.txt to s3://…/sample.txt` |
| 7 | `aws s3 ls s3://cse12045-cloud-lab6-student01-4829/` | Shows `lab-note.txt` (33 B, uploaded from the Console) and `sample.txt` (27 B), so the Console and CLI see the same bucket |
| 8 | `aws s3 cp s3://cse12045-cloud-lab6-student01-4829/sample.txt downloaded.txt` | `download: s3://…/sample.txt to ./downloaded.txt` |
| 9 | `cat downloaded.txt`, then `cmp sample.txt downloaded.txt && echo files are identical` | Prints `AWS CLI Cloud Storage Test` and "files are identical" |
| 10 | `aws s3 rm s3://cse12045-cloud-lab6-student01-4829/sample.txt` | `delete: …/sample.txt`; a listing then shows only `lab-note.txt` |

The test folder in CloudShell was removed afterwards (`rm -r cloud-lab6-cli`).

### Cost check (Figure 57)

After the practical the **Billing and Cost Management** home page was opened. It showed "We're preparing your cost and usage data. This process can take up to 24 hours after you first visit", and every figure read "Data unavailable", so charges could **not** be confirmed on the day. What was used is tiny: two objects of 33 and 27 bytes for about 20 minutes in S3, and read-only browsing; no EC2 instance, volume, snapshot, Elastic IP, alarm, dashboard or log group was created. The billing page should be checked again after 24 hours.

## 8. Deviations from the manual and limitations

| # | What | Why / effect |
| --- | --- | --- |
| 1 | The AWS Console and CloudShell were used while signed in as the **root user** of the account | The manual's precaution 3 says not to use the root account for routine activities. Only the free, low-risk steps of the manual were done. Next time an IAM user with limited permissions (and approval from the instructor) is better. The dashboard shows MFA is on for the root user and it has no active access keys. |
| 2 | The sample file was created in Ubuntu as in Step 3, but the file uploaded in the Console was a copy created on the host | The Console runs in a browser on Windows, outside the VM. The copy has the same content; the upload size (33.0 B) and the ETag (equal to the MD5 of the original) confirm it. To attach the file, the page's file input was filled with the file's contents instead of using the operating-system file dialog (which the automation cannot operate). |
| 3 | "Download the file" in the Console did not save a file | The browser pane used here does not store downloads or open new tabs. The object was therefore checked by its ETag, and a real download was done with the CLI (Task 4B, Step 8–9). |
| 4 | The CLI part ran in CloudShell, not in Ubuntu | See section 7: avoids creating access keys. |
| 5 | The EC2 optional launch activity was **skipped** | It needs the instructor's approval and can cost money. |
| 6 | The Billing check could not be completed | AWS had not yet prepared the data (section 7). |
| 7 | `openvpn` was not upgraded in Ubuntu | Download blocked by the network (HTTP 403); unrelated to the lab. |

## 9. Screenshots

| # | Description | Screenshot |
| --- | --- | --- |
| 1 | Ubuntu: `whoami`, `hostname`, `lsb_release -a`, `uname -a`, `systemd-detect-virt`, `date` | ![](screenshots/01-ubuntu-basic-commands-system.png) |
| 2 | Ubuntu: `df -h /`, `free -h`, `nproc`, `ip -br address` | ![](screenshots/02-ubuntu-basic-commands-resources.png) |
| 3 | Ubuntu: `sudo apt update` | ![](screenshots/03-ubuntu-apt-update.png) |
| 4 | Ubuntu: `sudo apt upgrade -y` (only `openvpn` blocked, 403) | ![](screenshots/04-ubuntu-apt-upgrade.png) |
| 5 | Ubuntu: `sudo apt install -y curl wget vim htop tree net-tools unzip` | ![](screenshots/05-ubuntu-install-basic-utilities.png) |
| 6 | Ubuntu: version output of the installed utilities | ![](screenshots/06-ubuntu-utilities-verified.png) |
| 7 | AWS Management Console home page | ![](screenshots/07-aws-console-home.png) |
| 8 | Console search bar: typing `S3` | ![](screenshots/08-aws-console-search-s3.png) |
| 9 | S3 console: buckets list (another bucket's name hidden) | ![](screenshots/09-s3-console-buckets.png) |
| 10 | Create bucket: Region, bucket type and name | ![](screenshots/10-s3-create-bucket-name.png) |
| 11 | Create bucket: Block all public access enabled | ![](screenshots/11-s3-create-bucket-block-public-access.png) |
| 12 | Create bucket: default encryption (SSE-S3) and Create bucket button | ![](screenshots/12-s3-create-bucket-encryption.png) |
| 13 | "Successfully created bucket" | ![](screenshots/13-s3-bucket-created.png) |
| 14 | Ubuntu: `mkdir`, `cd`, `echo`, `cat`, `sha256sum` of `lab-note.txt` | ![](screenshots/14-ubuntu-create-sample-file.png) |
| 15 | Upload page with `lab-note.txt` added (33.0 B) | ![](screenshots/15-s3-upload-file-added.png) |
| 16 | "Upload succeeded" | ![](screenshots/16-s3-upload-succeeded.png) |
| 17 | `lab-note.txt` listed in the bucket | ![](screenshots/17-s3-object-in-bucket.png) |
| 18 | Object selected (Download, Open, Delete available) | ![](screenshots/18-s3-object-selected.png) |
| 19 | Object details: size, storage class, ETag (owner hidden) | ![](screenshots/19-s3-object-etag-verified.png) |
| 20 | Delete objects: confirmation page | ![](screenshots/20-s3-delete-object-confirm.png) |
| 21 | "Successfully deleted objects" | ![](screenshots/21-s3-object-deleted.png) |
| 22 | Delete bucket: confirmation page | ![](screenshots/22-s3-delete-bucket-confirm.png) |
| 23 | "Successfully deleted bucket" | ![](screenshots/23-s3-bucket-deleted.png) |
| 24 | IAM dashboard (account details hidden) | ![](screenshots/24-iam-dashboard.png) |
| 25 | IAM users (names hidden) | ![](screenshots/25-iam-users.png) |
| 26 | IAM user groups (0) | ![](screenshots/26-iam-groups.png) |
| 27 | IAM roles (5 service-linked roles) | ![](screenshots/27-iam-roles.png) |
| 28 | IAM policies (1,603) | ![](screenshots/28-iam-policies.png) |
| 29 | `AmazonS3ReadOnlyAccess` policy in JSON view | ![](screenshots/29-iam-policy-json.png) |
| 30 | EC2 dashboard | ![](screenshots/30-ec2-dashboard.png) |
| 31 | EC2 Instances (none) | ![](screenshots/31-ec2-instances.png) |
| 32 | Launch an instance: name and Application and OS Images | ![](screenshots/32-ec2-launch-name-and-ami.png) |
| 33 | Launch an instance: AMI details and instance type | ![](screenshots/33-ec2-launch-ami-and-instance-type.png) |
| 34 | Launch an instance: key pair and network settings | ![](screenshots/34-ec2-launch-keypair-and-network.png) |
| 35 | Launch an instance: storage (reviewed, not launched) | ![](screenshots/35-ec2-launch-storage-review.png) |
| 36 | VPC: Your VPCs | ![](screenshots/36-vpc-your-vpcs.png) |
| 37 | VPC: Subnets | ![](screenshots/37-vpc-subnets.png) |
| 38 | VPC: route table details (owner hidden) | ![](screenshots/38-vpc-route-table-details.png) |
| 39 | VPC: route table routes (local and internet gateway) | ![](screenshots/39-vpc-route-table-routes.png) |
| 40 | VPC: Internet gateways | ![](screenshots/40-vpc-internet-gateways.png) |
| 41 | VPC: default security group details (owner hidden) | ![](screenshots/41-vpc-security-group-details.png) |
| 42 | VPC: security group inbound rules | ![](screenshots/42-vpc-security-group-inbound.png) |
| 43 | VPC: security group outbound rules | ![](screenshots/43-vpc-security-group-outbound.png) |
| 44 | CloudWatch overview | ![](screenshots/44-cloudwatch-overview.png) |
| 45 | CloudWatch metrics by service | ![](screenshots/45-cloudwatch-metrics-namespaces.png) |
| 46 | CloudWatch metric dimensions in the Usage namespace | ![](screenshots/46-cloudwatch-metric-dimensions.png) |
| 47 | CloudWatch alarms (0) | ![](screenshots/47-cloudwatch-alarms.png) |
| 48 | CloudWatch Create alarm wizard (not created) | ![](screenshots/48-cloudwatch-create-alarm-wizard.png) |
| 49 | AWS CloudShell welcome | ![](screenshots/49-cloudshell-welcome.png) |
| 50 | CLI: `aws --version` | ![](screenshots/50-cli-aws-version.png) |
| 51 | CLI: `aws sts get-caller-identity` (account numbers hidden) | ![](screenshots/51-cli-sts-get-caller-identity.png) |
| 52 | CLI: `aws s3 ls` (one bucket name hidden) | ![](screenshots/52-cli-s3-ls.png) |
| 53 | CLI: create `sample.txt` | ![](screenshots/53-cli-create-local-file.png) |
| 54 | CLI: upload and list the bucket | ![](screenshots/54-cli-upload-and-list.png) |
| 55 | CLI: download, `cat` and `cmp` | ![](screenshots/55-cli-download-and-verify.png) |
| 56 | CLI: delete the object and list the bucket | ![](screenshots/56-cli-delete-object.png) |
| 57 | Billing and Cost Management home ("Data unavailable") | ![](screenshots/57-billing-dashboard.png) |

## 10. Result

All four tasks were carried out. Ubuntu 26.04.1 runs in VirtualBox and was updated, with basic utilities installed. A private, encrypted S3 bucket was created; a file was uploaded and its integrity confirmed, then the object and the bucket were deleted. IAM, EC2, VPC and CloudWatch were explored through the Console without changing anything, and the AWS CLI was used from CloudShell to upload, list, download, verify and delete an object (the downloaded file was identical to the original). The only parts not completed as written are the optional EC2 launch (skipped on purpose) and the Billing check (data not yet available), as explained in section 8.

## 11. Conclusion

The same storage operation was done two ways, through the web Console and through the CLI, and both showed the same bucket, which shows that every AWS feature is an API that a graphical console and the command line both use. The tour of IAM, EC2 and VPC showed how access, compute and networking fit together: policies decide who may act, a security group in a VPC decides which traffic reaches a server, and a route to an internet gateway is what makes a subnet public. The EC2 wizard's defaults (SSH open to `0.0.0.0/0`, an unencrypted volume, on-demand prices) and the root-user session are reminders of why the manual stresses least privilege, deleting unused resources and checking billing: cloud resources are easy to create, and they only stay safe and cheap when they are configured and cleaned up deliberately.
