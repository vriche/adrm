@echo off

rem %~dp0\core\senchasdktools2\sencha create jsb -a %~dp0\desktop.html -p %~dp0\test.jsb3

rem %~dp0\core\senchasdktools2\sencha build -p %~dp0\test.jsb3 -d %~dp0
%~dp0\core\senchasdktools2\sencha build -p %~dp0\app.jsb3 -d %~dp0
rem cd %~dp0\core\senchasdktools2
rem sencha.bat build -p ../../app.jsb3 -d .

pause