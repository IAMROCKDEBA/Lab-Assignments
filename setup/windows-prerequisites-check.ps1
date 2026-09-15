$ErrorActionPreference = "SilentlyContinue"

Write-Host "Cloud Computing Lab - Windows Prerequisites Check"
Write-Host "================================================="

Write-Host ""
Write-Host "Host OS:"
Get-CimInstance Win32_OperatingSystem |
    Select-Object Caption, Version, OSArchitecture |
    Format-List

Write-Host "CPU:"
Get-CimInstance Win32_Processor |
    Select-Object Name, NumberOfCores, NumberOfLogicalProcessors, VirtualizationFirmwareEnabled |
    Format-List

Write-Host "Memory:"
$memory = Get-CimInstance Win32_ComputerSystem
"Total physical memory: {0:N2} GB" -f ($memory.TotalPhysicalMemory / 1GB)

Write-Host ""
Write-Host "Disk Free Space:"
Get-CimInstance Win32_LogicalDisk -Filter "DriveType = 3" |
    Select-Object DeviceID, @{Name = "FreeGB"; Expression = { "{0:N2}" -f ($_.FreeSpace / 1GB) } }, @{Name = "SizeGB"; Expression = { "{0:N2}" -f ($_.Size / 1GB) } } |
    Format-Table -AutoSize

Write-Host ""
Write-Host "Installed Tools:"
$git = Get-Command git
if ($git) {
    git --version
} else {
    Write-Host "Git: Not found"
}

$vboxManage = Get-Command VBoxManage
if ($vboxManage) {
    VBoxManage --version
} else {
    Write-Host "VirtualBox: Not found on PATH"
}

Write-Host ""
Write-Host "Official links:"
Write-Host "VirtualBox: https://www.virtualbox.org/wiki/Downloads"
Write-Host "Ubuntu ISO:  https://ubuntu.com/download/desktop"
