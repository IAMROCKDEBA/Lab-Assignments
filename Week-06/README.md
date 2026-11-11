# Week 06 — Cloud Services with AWS, Ubuntu and the AWS CLI

**Status:** Completed on 11 November 2026 (optional EC2 launch skipped on purpose; billing data was not yet available, see the report).

- Assignment: [Lab-6-Assignment.pdf](Lab-6-Assignment.pdf)
- Report (PDF): [Lab-6-Report.pdf](Lab-6-Report.pdf)
- Report (Markdown source): [Lab-6-AWS-Cloud-Services-Report.md](Lab-6-AWS-Cloud-Services-Report.md)

> AWS account IDs, account name, e-mail, canonical user ID and the names of unrelated resources are covered with black boxes in every screenshot. No password or access key was used or captured.

## Summary

| Task | What was done | Result |
| --- | --- | --- |
| 1. VM setup | Ubuntu 26.04.1 LTS in VirtualBox: basic Linux commands, `apt update`/`upgrade`, install curl, wget, vim, htop, tree, net-tools, unzip | Done (only `openvpn` could not be upgraded: network returns 403) |
| 2. S3 storage | Private bucket (Block Public Access on, SSE-S3), upload `lab-note.txt`, verify by ETag = MD5, delete object, delete bucket | Done, nothing left in S3 |
| 3. IAM, EC2, VPC | Observation only: dashboards, users/groups/roles/policies, policy JSON, EC2 launch wizard (not launched), VPC, subnets, route table, internet gateway, security group | Done, nothing changed |
| 4. CloudWatch and CLI | Metrics, alarms wizard (nothing created); CloudShell: `aws --version`, `sts get-caller-identity`, `s3 ls`, `s3 cp` up/down, `cmp`, `s3 rm` | Done, downloaded file identical |
| Cost check | Billing and Cost Management home | "Data unavailable" (AWS needs up to 24 h): check again later |

## Things to know

- The session was signed in as the **root user**, which the manual advises against for routine work. Only free, low-risk steps were taken.
- The CLI part ran in **CloudShell**, so no access keys were needed.
- The browser used cannot save downloads, so the Console download was checked by ETag and a real download was done with the CLI.

## Screenshots

Fifty-seven screenshots are in [screenshots/](screenshots/), numbered in the order of the manual's tasks. The full list with captions is in section 9 of the report. Highlights:

| # | Screenshot |
| --- | --- |
| 1–6 | [Ubuntu commands](screenshots/01-ubuntu-basic-commands-system.png) · [update](screenshots/03-ubuntu-apt-update.png) · [utilities](screenshots/06-ubuntu-utilities-verified.png) |
| 7–23 | [Console home](screenshots/07-aws-console-home.png) · [bucket created](screenshots/13-s3-bucket-created.png) · [upload](screenshots/16-s3-upload-succeeded.png) · [ETag check](screenshots/19-s3-object-etag-verified.png) · [bucket deleted](screenshots/23-s3-bucket-deleted.png) |
| 24–29 | [IAM dashboard](screenshots/24-iam-dashboard.png) · [policy JSON](screenshots/29-iam-policy-json.png) |
| 30–35 | [EC2 dashboard](screenshots/30-ec2-dashboard.png) · [launch wizard](screenshots/33-ec2-launch-ami-and-instance-type.png) |
| 36–43 | [VPC](screenshots/36-vpc-your-vpcs.png) · [routes](screenshots/39-vpc-route-table-routes.png) · [security group](screenshots/42-vpc-security-group-inbound.png) |
| 44–48 | [CloudWatch](screenshots/44-cloudwatch-overview.png) · [alarm wizard](screenshots/48-cloudwatch-create-alarm-wizard.png) |
| 49–57 | [CloudShell](screenshots/49-cloudshell-welcome.png) · [identity](screenshots/51-cli-sts-get-caller-identity.png) · [upload/list](screenshots/54-cli-upload-and-list.png) · [verify](screenshots/55-cli-download-and-verify.png) · [billing](screenshots/57-billing-dashboard.png) |
