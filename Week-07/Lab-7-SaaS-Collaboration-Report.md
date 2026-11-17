# Cloud Computing Lab — Experiment 7

## Familiarization and Usage of Collaborative Applications (SaaS)

| Field | Details |
| --- | --- |
| Name | TODO: Add your name |
| Roll Number | TODO: Add your roll number |
| Section | BTECH_CSE_SECB_2023 |
| Course | Cloud Computing Lab (CSE12045) |
| University | Adamas University (CSE, SOET) |
| Date of completion | 17 November 2026 |

> **Privacy note.** This report is stored in a public repository. In every screenshot the Google account names, e-mail addresses and profile pictures are covered with black boxes, and so are the titles of unrelated files in the Drive account. No password or verification code was typed or captured. The sign-in to both Google accounts was done by the student.

## 1. Aim

To become familiar with Software as a Service (SaaS) and perform basic collaborative activities using cloud-based productivity and communication applications (Google Docs, Sheets, Slides and Meet).

| Task | What was done | Evidence |
| --- | --- | --- |
| 1. SaaS introduction and account setup | Signed in to Google Workspace in the browser; looked at the home page, the apps launcher, file-creation options, storage location, sharing, version history and access settings | Figures 1, 2, 15, 16, 29 |
| 2. Cloud document collaboration | Created "Cloud Computing Lab 7 – Collaborative Document", shared it, edited and commented as a second user, replied and resolved, opened the version history | Figures 3–16, 29 |
| 3. Cloud spreadsheet collaboration | Created "Cloud Computing Lab 7 – Collaborative Spreadsheet" with five student records and four formulas, shared it, a second user added a record, changed a value and commented | Figures 17–22 |
| 4A. Online presentation | Created "Cloud Computing – SaaS Applications" with four slides, shared it, a second user added a point, changed the formatting and commented | Figures 23–26 |
| 4B. Online communication | Opened the Google Meet dashboard and its meeting options (no meeting was started) | Figures 27–28 |

## 2. Theory

**Software as a Service (SaaS)** is a cloud service model in which software is delivered over the internet. The provider runs the servers, storage and updates; the user only needs a browser. The three common service models differ in how much the user manages:

| Model | Provider manages | User manages | Example |
| --- | --- | --- | --- |
| IaaS | Hardware, virtualisation | OS, software, data | Amazon EC2 (Lab 6) |
| PaaS | Hardware, OS, runtime | Application and data | Google App Engine |
| **SaaS** | Everything up to the application | Own content and settings | Google Docs, Microsoft 365, Salesforce |

SaaS features seen in this lab: online access, cloud storage (My Drive), automatic updates, user authentication, file sharing with permission levels (Viewer, Commenter, Editor), real-time collaboration, comments, version history and access from several devices.

## 3. Requirements and environment

| Item | Details |
| --- | --- |
| SaaS platform | Google Workspace (free personal accounts): Docs, Sheets, Slides, Meet, Drive |
| Browser | Built-in browser of the Claude desktop app (Chromium based), one browser session |
| Accounts | **Account A (owner)** creates every file; **Account B (collaborator)** is a second Google account of the same student, used only to receive the shares and edit |
| How two users were shown | Both accounts are signed in at once in the same browser. The owner's view and the collaborator's view were opened in two tabs (`authuser=0` and `authuser=1`) at the same time, so changes made in one tab appeared live in the other |

Both accounts carry the same display name, so in the screenshots (where names are hidden) the two people are told apart by the **colour** Google gives each user in version history and by the cursor and selection colours.

## 4. Task 1: Introduction to SaaS and account setup

**Step 1: Access a SaaS application.** Google Docs was opened in the browser, already signed in with Account A (Figure 1). The page lists templates and a "Blank document" button for creating a file; the list of existing files below is hidden in the screenshot for privacy.

**Step 2: Features identified.**

| # | Feature asked for | Where it was observed | Figure |
| --- | --- | --- | --- |
| 1 | User account / profile options | Profile picture at the top right (hidden in the screenshots) | 1 |
| 2 | Application dashboard | Docs home with templates and recent files; the apps launcher with Drive, Gmail, Calendar, Meet and others | 1, 2 |
| 3 | File creation options | "Blank document" and templates; the `File > New` menu | 1, 15 |
| 4 | Cloud storage location | `File > Details`: location "My Drive", owner "me" | 16 |
| 5 | Sharing options | Share dialog: add people, choose Viewer / Commenter / Editor, notify, general access "Restricted" | 4, 5 |
| 6 | Collaboration options | Live presence indicator, collaborator cursor and selection, comments, replies, resolve | 6–11 |
| 7 | Version or activity history | `File > Version history` with a coloured entry per user and time | 12–14 |
| 8 | Settings and access control | Share dialog settings: "Allow editors to change permissions and share", who may download, copy or print | 29 |

The `File` menu (Figure 15) also shows the other SaaS features: *Make a copy*, *Share*, *Email*, *Download* in other formats, *Rename*, *Move*, *Version history* and *Make available offline*.

## 5. Task 2: Collaborative document (Figures 3–16)

### Step 1 and 2: Create the document and enter the content (Figure 3)

A new blank document was created in My Drive and titled **Cloud Computing Lab 7 – Collaborative Document**. The content from the manual was entered:

* Heading (Heading 1 style): *Software as a Service*
* Paragraph: *SaaS is a cloud service model in which software applications are delivered to users through the internet. Users can access the application without managing the underlying infrastructure.*
* A two-column table with the four rows Accessibility, Collaboration, Updates and Storage and their descriptions.

### Step 3: Share the document (Figures 4, 5)

`Share` was opened and the collaborator (Account B) was added. The permission menu offers **Viewer, Commenter and Editor** (Figure 4); **Editor** was chosen and the invitation was sent with "Notify people" ticked. Figure 5 shows the document's access list afterwards: Account A as Owner, Account B as Editor, and general access still **Restricted** (nobody else can open it).

### Step 4: Collaborative editing (Figures 6–11)

| Step in the manual | What was done | Figure |
| --- | --- | --- |
| 1. Open the shared document | Account B opened the document from the share link (the live-user indicator "1" shows that the owner is in the file) | 6 |
| 2. Add or modify content | Account B added a sentence to the paragraph: *Examples include Google Docs, Microsoft 365 and Salesforce.* | 6 |
| 3. Add a comment | Account B selected the paragraph and added the comment: *I added examples of SaaS products here. Can you check that the list is correct?* | 7 |
| 4. Observe the other user's changes | In Account A's tab the new sentence and the highlighted paragraph appeared live, with the other user's cursor and a comment counter on the toolbar | 8, 9 |
| 5. Respond and resolve | Account A replied *Checked: the examples are correct. Thanks for the addition.* and then marked the thread as resolved | 10, 11 |

### Step 5: Version history (Figures 12–14)

`File > Version history > See version history` lists two versions on 17 November: 5:48 PM (creation) and 5:51 PM (current). The current version shows **two colours, one for each user**, and the highlighted text in the document (green for the owner's content, purple for the collaborator's sentence) shows who wrote what and when (Figure 12). The three-dot menu of a version offers *Name this version* and *Make a copy* (Figure 13). Selecting the earlier version shows its content (empty at that moment) together with the **Restore this version** button (Figure 14). Nothing was restored.

## 6. Task 3: Collaborative spreadsheet (Figures 17–22)

### Steps 1 to 3: Create, enter data, operations and formatting (Figure 17)

A new spreadsheet **Cloud Computing Lab 7 – Collaborative Spreadsheet** was created. The table from the manual was entered in A1:D6:

| Student ID | Student Name | Subject | Marks |
| --- | --- | --- | --- |
| S101 | Student A | Cloud Computing | 82 |
| S102 | Student B | Cloud Computing | 75 |
| S103 | Student C | Cloud Computing | 91 |
| S104 | Student D | Cloud Computing | 68 |
| S105 | Student E | Cloud Computing | 87 |

The four operations were placed in F1:G4, beside the table so that new records can be added underneath it:

| Cell | Formula | Result (first five records) | Hand check |
| --- | --- | --- | --- |
| G1 "Total marks" | `=SUM(D2:D6)` | 403 | 82 + 75 + 91 + 68 + 87 = 403 |
| G2 "Average marks" | `=AVERAGE(D2:D6)` | 80.6 | 403 / 5 = 80.6 |
| G3 "Highest marks" | `=MAX(D2:D6)` | 91 | S103 |
| G4 "Lowest marks" | `=MIN(D2:D6)` | 68 | S104 |

Formatting applied: the header row in bold with a coloured header and alternating row shading (`Format > Alternating colors`), and the Subject column widened to fit its data.

### Step 4: Share the spreadsheet (Figure 18)

The spreadsheet was shared with Account B with the **Editor** permission. Figure 18 shows the access list (Owner and Editor; general access Restricted).

### Step 5 and 6: Collaborative data entry and observation (Figures 19–22)

| Step in the manual | What was done | Figure |
| --- | --- | --- |
| 1. Add another student record | Account B added row 7: S106, Student F, Cloud Computing, 79 | 19 |
| 2. Modify one existing value | Account B changed S104's marks from 68 to **70** | 19 |
| 3. Add a comment to a cell | Account B commented on cell D5: *I corrected this mark from 68 to 70 after rechecking the result sheet.* | 20 |
| 4. Observe the changes | In Account A's tab the new row, the new value, the other user's cell outline and the comment appeared live | 21 |

The ranges `D2:D6` in the formulas do not include the new row 7, which is why the totals did not change for the added record (G1 read 405 after the correction, not 484). The owner then updated the four formulas to `D2:D7`, and the results became:

| Result | Value | Hand check |
| --- | --- | --- |
| Total | 484 | 82 + 75 + 91 + 70 + 87 + 79 = 484 |
| Average | 80.6667 | 484 / 6 |
| Highest | 91 | unchanged |
| Lowest | 70 | S104 after the correction |

The sheet's version history (Figure 22) shows **both users' edits in different colours**: the changed cell D5 and the new row 7 are in the collaborator's colour (purple), the rest in the owner's colour (green).

## 7. Task 4: Presentation and online communication

### Task 4A: Collaborative presentation (Figures 23–26)

A presentation **Cloud Computing – SaaS Applications** with four slides was created (Figure 23):

| Slide | Title | Content |
| --- | --- | --- |
| 1 | Software as a Service (SaaS) | Subtitle: Cloud Computing Lab 7 |
| 2 | What is SaaS? | Cloud-based software delivery model; Accessed through the internet; Provider manages the underlying infrastructure; Usually accessible through a web browser or application |
| 3 | Examples of SaaS | Google Docs; Google Sheets; Microsoft 365; Microsoft Teams; Salesforce |
| 4 | Advantages of SaaS | Easy accessibility; Collaboration; Automatic updates; Reduced local maintenance; Scalable access |

The presentation was shared with Account B as Editor (Figure 24). Account B then edited slide 3: it **added the point "Dropbox"**, made it **bold** (formatting change), and posted the comment *I added Dropbox as another SaaS example and made it bold.* (Figure 25). In Account A's tab the added bullet, a coloured frame around the text box that the other user was editing, the user marker on the slide thumbnail and the comment all appeared (Figure 26).

### Task 4B: Online communication (Figures 27–28)

Google Meet was opened with Account A. The dashboard (Figure 27) shows the meeting code box with a *Join* button, the schedule for the day (empty), the *Meetings* and *Calls* sections and a *New* button. The *New* button offers three options (Figure 28): **Create a meeting for later** (a link to share), **Start an instant meeting** and **Schedule in Google Calendar**. A meeting was not started, because no second person was available to join and the camera and microphone were not needed for the observation. Meet supports the same remote-collaboration features as the other tools: video and audio calls, chat, screen sharing and the sharing of files through Drive.

## 8. Deviations from the manual and limitations

| # | What | Why / effect |
| --- | --- | --- |
| 1 | The collaborator is a second account of the same student, not a different person | The manual allows "an authorised collaborator". Both accounts are real Google accounts and all sharing, permissions, comments and version history work exactly as they would for two people. Both accounts have the same display name, hidden in the screenshots |
| 2 | The two users worked in two tabs of one browser at the same time | This was the only way to show both sides in one session; the two tabs were signed in to different accounts |
| 3 | The sample data (document table and spreadsheet cells) was put in by pasting prepared text instead of typing cell by cell | The browser tool used here could not type into the spreadsheet grid and could not pick the size of a table from the Insert menu. The result is the same table and cell content, and the formulas were calculated by Sheets |
| 4 | The spreadsheet summary cells are beside the table (F1:G4), not under it | So that the collaborator's new record could be added directly below the table without moving cells |
| 5 | The first attempt to post the cell comment did not save | The click on the "Comment" button was not registered and the comment was lost; it was written again, posted with the keyboard shortcut and then checked from both accounts (Figure 20) |
| 6 | No Google Meet call was started | Only the dashboard and options were explored (Task 4B asks only for exploration) |
| 7 | Slide formatting change was a bold point | The manual asks for "modify the formatting" without a specific change |
| 8 | Screenshots are small (about 800 px wide) | The browser pane's size; text stays readable |

## 9. Screenshots

| # | Description | Screenshot |
| --- | --- | --- |
| 1 | Google Docs home page, signed in (profile and file list hidden) | ![](screenshots/01-docs-home-signed-in.png) |
| 2 | Google apps launcher (Drive, Gmail, Meet, Calendar and others) | ![](screenshots/02-google-apps-launcher.png) |
| 3 | New document with title, heading, paragraph and feature table | ![](screenshots/03-doc-created-with-content.png) |
| 4 | Share dialog: Viewer, Commenter and Editor permission options | ![](screenshots/04-doc-share-permission-options.png) |
| 5 | Document shared: Owner and Editor, general access Restricted | ![](screenshots/05-doc-shared-collaborator-editor.png) |
| 6 | Collaborator opens the document and adds a sentence | ![](screenshots/06-collaborator-opens-and-edits.png) |
| 7 | Collaborator's comment in the comments panel | ![](screenshots/07-collaborator-adds-comment.png) |
| 8 | Owner's view: collaborator's edit appears live | ![](screenshots/08-owner-sees-live-changes.png) |
| 9 | Owner's view: the new comment | ![](screenshots/09-owner-sees-comment.png) |
| 10 | Owner replies to the comment | ![](screenshots/10-owner-replies-to-comment.png) |
| 11 | Comment thread marked as resolved | ![](screenshots/11-comment-resolved.png) |
| 12 | Version history: two users in two colours, changes highlighted | ![](screenshots/12-doc-version-history.png) |
| 13 | Version menu: Name this version, Make a copy | ![](screenshots/13-doc-version-menu.png) |
| 14 | Earlier version with "Restore this version" button (not used) | ![](screenshots/14-doc-earlier-version-restore-option.png) |
| 15 | `File` menu: share, email, download, rename, move, version history, offline | ![](screenshots/15-docs-file-menu-features.png) |
| 16 | Document details: location My Drive, owner, times | ![](screenshots/16-doc-details-cloud-location.png) |
| 17 | Spreadsheet: data, formulas (`=SUM(D2:D6)` in the formula bar), formatting | ![](screenshots/17-sheet-data-formulas-formatting.png) |
| 18 | Spreadsheet shared: Owner and Editor | ![](screenshots/18-sheet-shared-editor.png) |
| 19 | Collaborator's edits: new row S106 and corrected mark 70 | ![](screenshots/19-sheet-collaborator-edits.png) |
| 20 | Collaborator's comment on cell D5 | ![](screenshots/20-sheet-cell-comment-posted.png) |
| 21 | Owner's view of the collaborator's edits and comment | ![](screenshots/21-sheet-owner-sees-collaboration.png) |
| 22 | Spreadsheet version history with both users' changes in colour | ![](screenshots/22-sheet-version-history.png) |
| 23 | Presentation with the four slides | ![](screenshots/23-slides-four-slides-created.png) |
| 24 | Presentation shared: Owner and Editor | ![](screenshots/24-slides-shared-editor.png) |
| 25 | Collaborator adds the point "Dropbox" in bold and a comment | ![](screenshots/25-slides-collaborator-edits-and-comment.png) |
| 26 | Owner's view: other user's editing frame, edit and comment | ![](screenshots/26-slides-owner-sees-collaboration.png) |
| 27 | Google Meet dashboard | ![](screenshots/27-meet-dashboard.png) |
| 28 | Google Meet "New" menu (nothing started) | ![](screenshots/28-meet-new-meeting-options.png) |
| 29 | Document sharing settings (editors may change permissions; download and copy options) | ![](screenshots/29-docs-sharing-settings.png) |

## 10. Result

A shared Google Doc, Google Sheet and Google Slides presentation were created and edited by two users at once. In each file the second user made an edit and left a comment, and the owner saw the changes appear without refreshing. The document's comment was answered and resolved, and the version history of the document and the spreadsheet showed who changed what and when, with the option to restore an earlier version. The spreadsheet's `SUM`, `AVERAGE`, `MAX` and `MIN` gave the hand-checked values 403, 80.6, 91 and 68 for the first five records and 484, 80.67, 91 and 70 after the collaborator's changes. Google Meet was explored without starting a call.

## 11. Conclusion

SaaS moves the work from a program on one computer to a service in the cloud: nothing was installed, the files lived in My Drive, and a share link plus a permission level was all that was needed for a second person to join. Collaboration became a built-in feature of the file itself, with live cursors, comments and a version history that records each person's contribution, so the usual e-mailing of copies is not needed. The lab also showed the limits of such sharing: the spreadsheet formulas did not include the new row until the range was extended, so shared data needs careful structure, and sharing must be kept deliberately private (access stayed "Restricted" and only the named account was invited) because anything shared in the cloud is available to whoever receives the permission.
