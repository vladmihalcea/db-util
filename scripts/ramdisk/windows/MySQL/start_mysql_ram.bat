sc stop %MYSQL_SERVICE%

imdisk -D -m R:
imdisk -a -s 2G -m R: -P  -p "/FS:NTFS /C /Y"

mkdir R:\data
xcopy "%MySQL_DATA%\data" "R:\data" /S /E

"%MySQL_HOME%\bin\mysqld" --defaults-file="%MySQL_DATA%\my_ram.ini"