@echo off
cd /d %~dp0
start javaw -Xms5m -Xmx5m -Dfile.encoding=UTF-8 -jar remote-1.0-SNAPSHOT.jar
exit