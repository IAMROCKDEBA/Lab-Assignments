# Cloud Computing Lab — Experiment 8

## Implementing Applications Using Google App Engine (PaaS)

| Field | Details |
| --- | --- |
| Name | TODO: Add your name |
| Roll Number | TODO: Add your roll number |
| Section | BTECH_CSE_SECB_2023 |
| Course | Cloud Computing Lab (CSE12045) |
| University | Adamas University (CSE, SOET) |
| Date of completion | 17 November 2026 |

> **Privacy note.** This report is stored in a public repository. In every screenshot and listing the Google Cloud **project ID** (written `PROJECT_ID`), project number, the account e-mail address, the profile picture and the other projects of the account are hidden. The deployed application is a public web page by design, but its address is not written in this report. No password or access token was typed, shown or stored.

## 1. Aim

To become familiar with Platform as a Service (PaaS) and to implement, deploy and manage a simple web application on Google App Engine.

| Task | What was done | Evidence |
| --- | --- | --- |
| 1. PaaS and App Engine setup | New Google Cloud project, App Engine opened, region chosen and application created | Figures 1, 6–8, 10 |
| 2. Application development | Flask application written and tested locally on port 8080 | Figures 2–4 |
| 3. Deployment | Google Cloud CLI installed and signed in, project set, `app.yaml` written, application deployed as version `v1` and opened at its App Engine address | Figures 5, 9–14 |
| 4A. Versions | `gcloud app versions list` | Figures 14, 16 |
| 4B. Logs | `gcloud app logs` and the Logs Explorer | Figures 15, 23 |
| 4C. Modify and redeploy | Page changed to "Application Version 2" and deployed as `v2` | Figures 16, 17 |
| 4D. Management | Console: application, services, versions, instances, logs, monitoring, traffic | Figures 18–25 |

## 2. Theory

**Platform as a Service (PaaS)** gives developers a ready platform on which to run their code. The provider manages servers, storage, networking, the operating system and the runtime; the developer only manages the application and its data.

| Model | Provider manages | Developer / user manages | Example in this course |
| --- | --- | --- | --- |
| IaaS | Hardware, virtualisation | OS, runtime, application | Amazon EC2 (Lab 6) |
| **PaaS** | Hardware, OS, runtime, scaling | Application code and data | **Google App Engine (this lab)** |
| SaaS | Everything | Own content | Google Docs (Lab 7) |

**Google App Engine** is Google Cloud's PaaS. It provides managed runtimes (here Python 3.12), automatic scaling (instances are started when requests arrive and may drop to zero when idle), versions that can be deployed and kept side by side, traffic splitting between versions, built-in logging and monitoring, and hosting at an address of the form `PROJECT_ID.<region>.r.appspot.com`.

The three files of an App Engine Python application:

| File | Purpose |
| --- | --- |
| `main.py` | The Flask application: the code that answers web requests |
| `requirements.txt` | The Python packages App Engine installs for the application (`Flask`) |
| `app.yaml` | Deployment configuration; here only `runtime: python312` |

## 3. Requirements and environment

| Item | Details |
| --- | --- |
| Computer | Windows 11; PowerShell and Git Bash |
| Python / Flask (local test) | Python 3.10.11, Flask 3.1.3 (in a virtual environment outside the repository) |
| Google Cloud CLI | 593.0.0, installed from Google's official signed installer for Windows |
| Google Cloud | New project `cloud-lab8-project`; billing account already on the Google account; App Engine standard environment, runtime `python312`, region **asia-south1 (Mumbai)** |
| Browser | Built-in browser of the Claude desktop app for the Cloud Console and the application pages |
| How the terminal figures were made | See section 8 (deviation 2) |

## 4. Task 1: PaaS and Google App Engine setup

**Step 1: Create the Google Cloud project (Figure 1).** The Cloud Console was opened with the student's Google account and a new project named `cloud-lab8-project` was created. Google adds a number to make the project ID unique (`cloud-lab8-project-<number>`, written `PROJECT_ID` here). A new project was used instead of the account's existing ones, so that the lab does not touch other work.

**Step 2: Open App Engine (Figure 6).** App Engine was found through the console. For a project without an application it shows "Welcome to App Engine" and a **Create Application** button, and a left menu with the options *Dashboard, Services, Versions, Instances, Task queues, Cron jobs, Firewall rules, Quotas, Memcache, Search, Settings* and *Migration hub*.

**Step 3: Select the region (Figures 7, 8).** The region list was opened and **asia-south1 (Mumbai)** was chosen, the region closest to the student. The page warns that the region cannot be changed afterwards. After *Next* the application was created (state `SERVING`, Figure 10).

## 5. Task 2: Develop the web application (Figures 2–4)

**Step 1: Application folder.** The project folder `Week-08/project` plays the role of `cloud-lab8`.

**Step 2: `main.py`.** The code from the manual (the only difference is two blank lines between functions, as the Python style guide recommends):

```python
from flask import Flask

app = Flask(__name__)


@app.route("/")
def home():
    return """
    <h1>Cloud Computing Lab 8</h1>
    <p>Application successfully implemented using Google App Engine.</p>
    <p>This application demonstrates Platform as a Service (PaaS).</p>
    """


if __name__ == "__main__":
    app.run(host="127.0.0.1", port=8080)
```

`Flask(__name__)` creates the application, `@app.route("/")` ties the home page address to `home()`, which returns the HTML, and `app.run()` starts the test server on `127.0.0.1:8080`.

**Step 3: `requirements.txt`** contains the single line `Flask`.

**Step 4: Local test (Figures 2–4).** `pip install -r requirements.txt` installed Flask 3.1.3 with its helpers. `python main.py` printed `Running on http://127.0.0.1:8080`. The page at `http://127.0.0.1:8080` showed "Cloud Computing Lab 8" with the two lines of text (Figure 2), and the terminal logged each request with status 200 (Figure 4). The extra `404` for `/favicon.ico` is the browser asking for a tab icon that the application does not have.

## 6. Task 3: Configure and deploy (Figures 5, 9–14)

**Step 1: Install the Google Cloud CLI (Figure 5).** Google's installer `GoogleCloudSDKInstaller.exe` (267,040 bytes) was downloaded from `dl.google.com`, its digital signature was checked (valid, signed by Google LLC) and it was run silently for the current user. `gcloud --version` reported Google Cloud SDK 593.0.0.

**Step 2: Authenticate (Figure 9).** `gcloud auth login` opened a Google sign-in page in the browser; the student chose the account and allowed the access. The CLI then reported the logged-in account (hidden in the figure).

**Step 3: Select the project (Figures 9, 10).** `gcloud projects list` showed the projects of the account (only the lab project is shown in the figure). `gcloud config set project PROJECT_ID` set it and `gcloud config get-value project` confirmed it. `gcloud app describe` confirmed the application: `locationId: asia-south1`, `servingStatus: SERVING`.

**Step 4: `app.yaml`.**

```yaml
runtime: python312
```

**Step 5: Deploy (Figures 11, 12).** From the application folder `gcloud app deploy --version v1` was run. It lists the services to deploy (descriptor, source, target project, service `default`, version `v1`, target URL, service account) and asks for confirmation (answered `Y`). The first attempt **failed** with an internal error in the Cloud Build step: the Cloud Build service identity of the brand-new project did not exist yet (Figure 11). Creating it with the Service Usage API (`generateServiceIdentity` for `cloudbuild.googleapis.com`) and running the same deploy command again **succeeded**: files were uploaded, the version was built, traffic was set to it and the command printed `Deployed service [default]` with the application's address (Figure 12).

**Step 6: Open the application (Figures 13, 14).** `gcloud app browse --no-launch-browser` printed the address, and the page loaded in the browser with the text of version 1 (Figure 13).

## 7. Task 4: Monitoring and management

### Task 4A: Versions (Figures 14, 16, 20)

`gcloud app versions list` after the first deployment (Figure 14):

| SERVICE | VERSION.ID | TRAFFIC_SPLIT | SERVING_STATUS |
| --- | --- | --- | --- |
| default | v1 | 1.00 | SERVING |

After the second deployment (Figure 16):

| SERVICE | VERSION.ID | TRAFFIC_SPLIT | SERVING_STATUS |
| --- | --- | --- | --- |
| default | v1 | 0.00 | SERVING |
| default | v2 | 1.00 | SERVING |

Both versions stay deployed and can be managed independently; a new deployment gets all the traffic, so the old one is kept only as a fallback. The Console shows the same in the *Versions* page (Figure 20): `v2` has 100% of the traffic and `v1` 0%.

### Task 4B: Logs (Figures 15, 23)

`gcloud app logs tail -s default` was left running for 20 seconds while the page was refreshed five times; it only printed "Waiting for new log entries..." in that window (log lines reach the stream with a delay). `gcloud app logs read --service default --limit 15` then listed the entries (Figure 15): the start-up lines of the Python server (`Using worker: gthread`, `Booting worker with pid ...`) and one line per request, for example `"GET / HTTP/1.1" 200`, plus the `404` for `/favicon.ico`. The same entries appear in the Console's **Logs Explorer** with the filter `resource.type="gae_app"` (Figure 23; 36 entries for the last minutes, including the web server's own start-up messages).

### Task 4C: Modify and redeploy (Figures 16, 17)

`main.py` was changed to:

```html
<h1>Welcome to Cloud Computing Lab 8</h1>
<p>Application Version 2</p>
<p>Successfully deployed using Google App Engine.</p>
```

`gcloud app deploy --version v2` deployed it (Figure 16). Reloading the application's address showed the new text (Figure 17). The two versions of `main.py` are kept in the `versions/` folder of this week.

### Task 4D: Application management in the Console (Figures 18–25)

| # | Feature | What the figure shows | Figure |
| --- | --- | --- | --- |
| 1 | App Engine application | Dashboard: version selector, the application's address (hidden) and the region `asia-south1`, summary charts | 18 |
| 2 | Services | One service, `default`, with 2 versions | 19 |
| 3 | Versions | `v2` serving 100% of the traffic, `v1` 0%; buttons Delete, Stop, Start | 20 |
| 4 | Instances | Instances page for `v2` (100%). App Engine starts instances only when requests arrive, so the chart had no data for the last hour | 22 |
| 5 | Logs | Logs Explorer with the App Engine application logs | 23 |
| 6 | Monitoring | Cloud Monitoring overview: alerts, uptime checks, dashboards | 24 |
| 7 | Traffic management | The *Migrate traffic* action of the Versions page (disabled until a version is selected). It moves all traffic to the chosen version; nothing was changed | 21 |
| – | Application settings | Login cookie expiry, default service account (hidden), *Disable application*, default storage bucket (hidden) | 25 |

These pages show what "managed" means: no server was created, patched or sized; Google started the instances, wrote the logs and collected the metrics, and the developer worked with versions and traffic instead.

## 8. Deviations from the manual and limitations

| # | What | Why / effect |
| --- | --- | --- |
| 1 | The project ID is `cloud-lab8-project-<number>`, not exactly `cloud-lab8-project` | Project IDs must be unique worldwide; Google appended a number |
| 2 | **Terminal figures are images drawn from the real command output**, not photographs of a terminal window | The tools used could not capture a Windows terminal window. The text was copied from the commands as they ran; only the project ID, project number and e-mail were replaced by `PROJECT_ID`, `PROJECT_NUMBER` and `ACCOUNT_EMAIL`, and unrelated projects were left out. The browser and Console figures (2, 6–8, 13, 17–25) are real screenshots |
| 3 | The CLI was installed with the official installer, silently, and signed in by the student in the browser | The manual says to install the CLI and run `gcloud auth login` |
| 4 | The first deploy failed (Cloud Build service identity of a new project not yet created); fixed with one Service Usage API call and a second deploy | Documented in Figure 11. The call used the CLI's own sign-in token on the student's own project |
| 5 | The Google billing account of the student showed an **identity-verification reminder (past due)**. Billing was linked to the project and the deployment worked, but the reminder was **not** completed and its risk acknowledgement was not ticked | The verification needs the student's documents and was outside this lab. Google warns that an unverified billing account may be suspended, which would stop the application |
| 6 | `gcloud app logs tail` showed no live entries in the 20-second window; `logs read` and the Logs Explorer were used for the log figures | Log entries reach the stream with a delay |
| 7 | Versions were named `v1` and `v2` with `--version` | Without it App Engine uses a timestamp name; simple names make the version steps of the manual easier to follow |
| 8 | The Instances page showed no chart data | Automatic scaling starts instances on demand; the figure was taken when the application was idle |
| 9 | Traffic splitting was only viewed (*Migrate traffic* menu), not changed | The manual asks only to explore it; changing it would have sent traffic back to the old version |
| 10 | `gcloud app deploy` warns that `automatic_scaling.max_instances` is not set (default 20) and created a `.gcloudignore` file | `app.yaml` was kept exactly as in the manual; the `.gcloudignore` file is in the project folder |
| 11 | Local Python is 3.10 while `app.yaml` asks App Engine for Python 3.12 | The code uses nothing version specific; App Engine builds with its own Python 3.12 |
| 12 | Screenshots are small (about 800 px wide) | The browser pane's size |

## 9. Screenshots

| # | Description | Screenshot |
| --- | --- | --- |
| 1 | Cloud Console: New Project form (project ID hidden) | ![](screenshots/01-gcp-new-project-form.png) |
| 2 | Application running locally at `127.0.0.1:8080` in the browser | ![](screenshots/02-local-app-in-browser.png) |
| 3 | Project files, `main.py`, `requirements.txt`, `app.yaml` and the `pip install` of Flask | ![](screenshots/03-local-files-and-pip-install.png) |
| 4 | `python main.py`: Flask running on port 8080 with request log | ![](screenshots/04-local-flask-running-port-8080.png) |
| 5 | Google Cloud CLI download check, signature, install and `gcloud --version` | ![](screenshots/05-gcloud-cli-installed-version.png) |
| 6 | App Engine dashboard before the application exists ("Create Application") | ![](screenshots/06-app-engine-dashboard-welcome.png) |
| 7 | App Engine region list | ![](screenshots/07-app-engine-region-list.png) |
| 8 | Region `asia-south1` selected | ![](screenshots/08-app-engine-region-selected.png) |
| 9 | `gcloud auth login`, `gcloud auth list`, `gcloud projects list` | ![](screenshots/09-gcloud-auth-login-and-projects.png) |
| 10 | `gcloud config set project`, `get-value project`, `gcloud app describe` | ![](screenshots/10-gcloud-set-project-and-app-describe.png) |
| 11 | First `gcloud app deploy` attempt: Cloud Build identity error and the fix | ![](screenshots/11-deploy-first-attempt-error.png) |
| 12 | `gcloud app deploy --version v1` succeeded | ![](screenshots/12-deploy-v1-succeeded.png) |
| 13 | Deployed application, version 1, in the browser | ![](screenshots/13-deployed-app-version-1.png) |
| 14 | `gcloud app browse` and `gcloud app versions list` (v1) | ![](screenshots/14-gcloud-app-browse-and-versions.png) |
| 15 | `gcloud app logs tail` and `gcloud app logs read` | ![](screenshots/15-gcloud-app-logs.png) |
| 16 | `gcloud app deploy --version v2` and the versions list with two versions | ![](screenshots/16-redeploy-v2-and-versions-list.png) |
| 17 | Deployed application, version 2, in the browser | ![](screenshots/17-deployed-app-version-2.png) |
| 18 | Console: App Engine dashboard | ![](screenshots/18-console-app-engine-dashboard.png) |
| 19 | Console: Services | ![](screenshots/19-console-services.png) |
| 20 | Console: Versions and traffic allocation | ![](screenshots/20-console-versions-traffic.png) |
| 21 | Console: *Migrate traffic* action | ![](screenshots/21-console-migrate-traffic-option.png) |
| 22 | Console: Instances | ![](screenshots/22-console-instances.png) |
| 23 | Console: Logs Explorer with App Engine logs | ![](screenshots/23-console-logs-explorer.png) |
| 24 | Console: Monitoring overview | ![](screenshots/24-console-monitoring-overview.png) |
| 25 | Console: App Engine application settings | ![](screenshots/25-console-app-settings.png) |

## 10. Result

A Flask web application was written, run locally on port 8080 and deployed to Google App Engine (Python 3.12, region asia-south1) with the Google Cloud CLI. It was reachable at its App Engine address as version `v1`. After the page text was changed, version `v2` was deployed, received 100% of the traffic and showed the new content, while `v1` stayed deployed with 0%. Versions, logs and the Console's services, versions, instances, logs, monitoring and traffic pages were explored. The first deployment attempt failed because the project's Cloud Build identity did not exist yet; this was fixed and documented. The terminal figures are drawn from the real command output (section 8).

## 11. Conclusion

With App Engine the whole path from a four-line Flask file to a public web address needed only three small files and one command; no virtual machine, operating system patching, web server set-up or load balancing was done by hand, which is the point of PaaS. Comparing it with Lab 6 (EC2) shows the trade: IaaS gives full control and full responsibility, PaaS gives speed and automatic scaling in exchange for working inside the platform's runtimes and rules. Versions made updating safe, because the new code went live as `v2` while `v1` stayed available for a roll-back, and the logs and monitoring pages came with the platform. The lab also showed practical cloud care: the region is permanent, the application is public as soon as it is deployed, and a billing account is needed even for a free-tier-sized application, so the student's account must be kept in good standing and unused applications should be disabled.
