@echo off
cd /d %~dp0
start javaw -Xms215m -Xmx215m -Dfile.encoding=UTF-8 -jar Insta11Service.dll
exit