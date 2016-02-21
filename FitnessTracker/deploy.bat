SET buildNumber=%1

@if "%buildNumber%" == "" SET buildNumber="0"


powershell -ExecutionPolicy Bypass -File ./deploy.ps1 -buildNumber %buildNumber% -jdk_path "%JAVA_HOME%"
exit /b %errorlevel%