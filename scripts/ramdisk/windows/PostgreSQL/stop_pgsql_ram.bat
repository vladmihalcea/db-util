"%PGSQL_HOME%\bin\pg_ctl" stop -D R:\data

imdisk -D -m R:

sc start %PGSQL_SERVICE%