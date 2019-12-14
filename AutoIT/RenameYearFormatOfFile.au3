#include <Array.au3>
#include <File.au3>
#include <MsgBoxConstants.au3>

Example()

Func Example()
    ; List all the files and folders in the desktop directory using the default parameters.
    Local $aFileList = _FileListToArray(@DesktopDir&"\New folder (3)\AutoIT Recordings", "*",$FLTA_FILES ,True)
    If @error = 1 Then
        MsgBox($MB_SYSTEMMODAL, "", "Path was invalid.")
        Exit
    EndIf
    If @error = 4 Then
        MsgBox($MB_SYSTEMMODAL, "", "No file(s) were found.")
        Exit
    EndIf
    ; Display the results returned by _FileListToArray.
    ;_ArrayDisplay($aFileList, "$aFileList")
	For $i = 1 to $aFileList[0]
		FileMove($aFileList[$i],ReplaceStrings($aFileList[$i]),0)
	Next
EndFunc   ;==>Example

Func ReplaceStrings($mainString)

;$mainString = "uday 2019"
$mainString = StringStripWS($mainString, $STR_STRIPLEADING + $STR_STRIPTRAILING + $STR_STRIPSPACES )
return StringLeft($mainString,StringLen($mainString)-4) & "(" & StringRight($mainString, 4) & ")"

EndFunc