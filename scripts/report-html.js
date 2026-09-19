const fs = require('fs');
const path = require('path');
const [, , bodyPath, outPath] = process.argv;
let body = fs.readFileSync(bodyPath, 'utf8');

// Turn the screenshot table into full-width captioned figures for print.
body = body.replace(/(<h2[^>]*>7\. Screenshots<\/h2>)\s*<table>[\s\S]*?<tbody>([\s\S]*?)<\/tbody>\s*<\/table>/, (m, h, rows) => {
  const figs = [...rows.matchAll(/<tr>\s*<td>(\d+)<\/td>\s*<td>([\s\S]*?)<\/td>\s*<td><img src="([^"]+)"[^>]*><\/td>\s*<\/tr>/g)]
    .map(([, n, cap, src]) => `<figure><img src="${src}"><figcaption>Figure ${n}: ${cap}</figcaption></figure>`);
  return h + figs.join('\n');
});

const html = `<!doctype html><html><head><meta charset="utf-8"><title>Cloud Computing Lab 1 Report</title>
<style>
@page { size: A4; margin: 18mm 16mm; }
body { font-family: "Segoe UI", Calibri, Arial, sans-serif; font-size: 10.5pt; line-height: 1.45; color: #111; }
h1 { font-size: 20pt; text-align: center; margin: 0 0 4pt; }
h1 + h2 { text-align: center; font-size: 13pt; font-weight: 600; border: 0; margin-top: 0; }
h2 { font-size: 13pt; border-bottom: 1.5px solid #333; padding-bottom: 2pt; margin-top: 16pt; }
h3 { font-size: 11pt; margin-bottom: 4pt; }
table { border-collapse: collapse; width: 100%; margin: 6pt 0; page-break-inside: avoid; }
th, td { border: 1px solid #999; padding: 3pt 6pt; text-align: left; vertical-align: top; }
th { background: #eee; }
code { font-family: Consolas, monospace; font-size: 9pt; background: #f2f2f2; padding: 0 2px; }
pre { background: #f5f5f5; border: 1px solid #ddd; padding: 6pt; white-space: pre-wrap; word-break: break-all; page-break-inside: avoid; }
pre code { background: none; padding: 0; }
figure { margin: 10pt 0; page-break-inside: avoid; text-align: center; }
figure img { max-width: 100%; max-height: 110mm; border: 1px solid #aaa; }
figcaption { font-size: 9.5pt; font-style: italic; margin-top: 3pt; }
a { color: #0b4f9c; }
</style></head><body>${body}</body></html>`;
fs.writeFileSync(outPath, html);
console.log('figures:', (html.match(/<figure>/g) || []).length);
