sc stop %MYSQL_SERVICE%

REM imdisk -D -m R:
REM imdisk -a -s 1G -m R: -P  -p "/FS:NTFS /C /Y"

rd /s /q R:\
mkdir R:\data
xcopy "%MySQL_DATA%\data" "R:\data" /S /E

"%MySQL_HOME%\bin\mysqld" --defaults-file="%CD%\my_ram.ini"