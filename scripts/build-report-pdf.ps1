# Regenerates a week's PDF report from its Markdown source.
# Usage (from the repository root):  .\scripts\build-report-pdf.ps1 -Week Week-01 -Report Lab-1-VM-Setup-Report.md -Pdf Lab-1-Report.pdf
# Requires Node.js (for npx marked) and Google Chrome.
param(
    [string]$Week = "Week-01",
    [string]$Report = "Lab-1-VM-Setup-Report.md",
    [string]$Pdf = "Lab-1-Report.pdf"
)
$ErrorActionPreference = "Stop"
$root = Split-Path -Parent $PSScriptRoot
$weekDir = Join-Path $root $Week
$body = Join-Path $env:TEMP "report-body.html"
$html = Join-Path $weekDir "_report.html"
$chrome = "C:\Program Files\Google\Chrome\Application\chrome.exe"

npx -y marked@12 -i (Join-Path $weekDir $Report) -o $body
node (Join-Path $PSScriptRoot "report-html.js") $body $html
$url = "file:///" + ($html.Replace('\', '/').Replace(' ', '%20'))
& $chrome --headless=new --disable-gpu --no-pdf-header-footer --user-data-dir="$env:TEMP\report-chrome" --print-to-pdf="$(Join-Path $weekDir $Pdf)" $url
Start-Sleep -Seconds 2
Remove-Item $html
Write-Host "Wrote $(Join-Path $weekDir $Pdf)"
