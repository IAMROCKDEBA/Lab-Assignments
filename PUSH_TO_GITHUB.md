# Push This Repository to GitHub

The local repository is already initialized on the `main` branch.

## Option 1: GitHub CLI

Run these commands from this folder:

```powershell
gh auth login
gh repo create Lab-Assignments --public --source . --remote origin --push
```

After pushing, copy the repository URL and update:

- `submission-details.csv`
- the student details table in `README.md`

## Option 2: Existing GitHub Repository

If you create the GitHub repository in the browser first, run:

```powershell
git remote add origin https://github.com/YOUR_USERNAME/Lab-Assignments.git
git push -u origin main
```

Replace `YOUR_USERNAME` with your GitHub username.
