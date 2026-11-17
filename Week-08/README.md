# Week 08 — Applications on Google App Engine (PaaS)

**Status:** Completed on 17 November 2026. The application is deployed (versions `v1` and `v2`); see "Things to know" about the running app and the billing reminder.

- Assignment: [Lab-8-Assignment.pdf](Lab-8-Assignment.pdf)
- Report (PDF): [Lab-8-Report.pdf](Lab-8-Report.pdf)
- Report (Markdown source): [Lab-8-App-Engine-PaaS-Report.md](Lab-8-App-Engine-PaaS-Report.md)
- Application files: [project/](project/) (`main.py`, `requirements.txt`, `app.yaml`; `main.py` is the Version 2 text)
- Both page versions: [versions/](versions/) (`main-v1.py`, `main-v2.py`)

> The Google Cloud project ID, project number, account e-mail, profile picture and the account's other projects are hidden in every screenshot and in the report. No password or token is stored in this repository.

## Summary

| Task | What was done | Result |
| --- | --- | --- |
| 1. PaaS and App Engine setup | New project `cloud-lab8-project`, App Engine application created in **asia-south1 (Mumbai)** | Done |
| 2. Application | Flask app (`main.py`, `requirements.txt`) run locally on port 8080 | Done, page "Cloud Computing Lab 8" |
| 3. Deployment | Google Cloud CLI 593.0.0 installed, `gcloud auth login`, project set, `app.yaml` (`python312`), `gcloud app deploy` | Done as `v1` (first attempt failed on a Cloud Build identity error, fixed and redeployed) |
| 4A. Versions | `gcloud app versions list` | `v1` 100% → after redeploy `v1` 0%, `v2` 100% |
| 4B. Logs | `gcloud app logs read`, Logs Explorer | Request lines `GET / 200` visible |
| 4C. Modify and redeploy | Text changed to "Application Version 2", deployed as `v2` | Done |
| 4D. Management | Console: dashboard, services, versions, instances, logs, monitoring, traffic menu, settings | Done |

## Things to know

- **Terminal figures are drawn from real command output** (the tools used could not photograph a Windows terminal): the text was copied from the commands as they ran, with the project ID, project number and e-mail replaced by `PROJECT_ID`, `PROJECT_NUMBER` and `ACCOUNT_EMAIL`. The browser and Console figures are real screenshots. Details in section 8 of the report.
- **The application is still deployed and public** (a small Flask page, within the free quota). To stop it: App Engine Console → Settings → *Disable application*, or delete the project `cloud-lab8-project`.
- **Billing-account reminder:** the Google billing account of the student showed "account verification past due". It was not completed; billing was linked and the deployment worked. Google may suspend an unverified billing account.
- **The Google Cloud CLI is installed on this computer and signed in.** Run `gcloud auth revoke` to sign it out.
- `.gcloudignore` was created by `gcloud app deploy` and is kept in `project/`.

## Screenshots

Twenty-five screenshots are in [screenshots/](screenshots/), numbered in the order of the tasks. The full list with captions is in section 9 of the report. Highlights:

| # | Screenshot |
| --- | --- |
| 1 | [New project form](screenshots/01-gcp-new-project-form.png) |
| 2–4 | [local page](screenshots/02-local-app-in-browser.png) · [files and pip](screenshots/03-local-files-and-pip-install.png) · [Flask on 8080](screenshots/04-local-flask-running-port-8080.png) |
| 5 | [Google Cloud CLI installed](screenshots/05-gcloud-cli-installed-version.png) |
| 6–8 | [App Engine welcome](screenshots/06-app-engine-dashboard-welcome.png) · [regions](screenshots/07-app-engine-region-list.png) · [asia-south1](screenshots/08-app-engine-region-selected.png) |
| 9–10 | [auth and projects](screenshots/09-gcloud-auth-login-and-projects.png) · [project and app describe](screenshots/10-gcloud-set-project-and-app-describe.png) |
| 11–14 | [first deploy error](screenshots/11-deploy-first-attempt-error.png) · [v1 deployed](screenshots/12-deploy-v1-succeeded.png) · [v1 in browser](screenshots/13-deployed-app-version-1.png) · [versions list](screenshots/14-gcloud-app-browse-and-versions.png) |
| 15–17 | [logs](screenshots/15-gcloud-app-logs.png) · [redeploy v2](screenshots/16-redeploy-v2-and-versions-list.png) · [v2 in browser](screenshots/17-deployed-app-version-2.png) |
| 18–25 | [dashboard](screenshots/18-console-app-engine-dashboard.png) · [services](screenshots/19-console-services.png) · [versions](screenshots/20-console-versions-traffic.png) · [traffic](screenshots/21-console-migrate-traffic-option.png) · [instances](screenshots/22-console-instances.png) · [Logs Explorer](screenshots/23-console-logs-explorer.png) · [monitoring](screenshots/24-console-monitoring-overview.png) · [settings](screenshots/25-console-app-settings.png) |
