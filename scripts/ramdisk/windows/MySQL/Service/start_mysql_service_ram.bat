sc stop %MYSQL_SERVICE%
sc stop %MYSQL_SERVICE%RAM

imdisk -D -m R:
imdisk -a -s 1G -m R: -P  -p "/FS:NTFS /C /Y"
XCOPY 
mkdir R:\data
xcopy "%MySQL_DATA%\data" "R:\data" /S /E

"%MySQL_HOME%\bin\mysqld" --remove %MYSQL_SERVICE%RAM
"%MySQL_HOME%\bin\mysqld" --install %MYSQL_SERVICE%RAM --defaults-file="%MySQL_DATA%\my_ram.ini"

sc start %MYSQL_SERVICE%RAM