"%MySQL_HOME%\bin\mysqladmin" -u mysql -p shutdown

REM imdisk -D -m R:

sc start %MYSQL_SERVICE%