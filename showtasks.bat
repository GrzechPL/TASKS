call runcrud
if "%ERRORLEVEL%" == "0" goto google
goto fail

:google
START http://localhost:8080/crud/v1/task/getTasks
goto end

:fail
echo.
echo There were errors

:end
echo.
echo No errors