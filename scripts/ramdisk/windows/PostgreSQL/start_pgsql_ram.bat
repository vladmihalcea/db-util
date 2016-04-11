sc stop %PGSQL_SERVICE%

imdisk -D -m R:
imdisk -a -s 2G -m R: -P  -p "/FS:NTFS /C /Y"
XCOPY 
mkdir R:\data
xcopy "%PGSQL_DATA%" "R:\data" /S /E
xcopy postgresql.conf "R:\data" /Y 

"%PGSQL_HOME%\bin\pg_ctl" start -D R:\data