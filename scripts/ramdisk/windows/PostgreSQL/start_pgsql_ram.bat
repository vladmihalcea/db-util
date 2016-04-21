sc stop %PGSQL_SERVICE%

REM imdisk -D -m R:
REM imdisk -a -s 1G -m R: -P  -p "/FS:NTFS /C /Y"

for %%* in (.) do set PWD=%~dp0

rd /s /q R:\
mkdir R:\data
xcopy "%PGSQL_DATA%" "R:\data" /S /E
xcopy "%PWD%postgresql.conf" "R:\data" /Y 

"%PGSQL_HOME%\bin\pg_ctl" start -D R:\data