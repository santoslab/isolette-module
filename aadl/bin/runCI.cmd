::#! 2> /dev/null                                   #
@ 2>/dev/null # 2>nul & echo off & goto BOF         #
if [ -z ${SIREUM_HOME} ]; then                      #
  echo "Please set SIREUM_HOME env var"             #
  exit -1                                           #
fi                                                  #
exec ${SIREUM_HOME}/bin/sireum slang run "$0" "$@"  #
:BOF
setlocal
if not defined SIREUM_HOME (
  echo Please set SIREUM_HOME env var
  exit /B -1
)
%SIREUM_HOME%\\bin\\sireum.bat slang run "%0" %*
exit /B %errorlevel%
::!#
// #Sireum

import org.sireum._

val cBinDir = Os.slashDir.up.up / "hamr" / "c" / "bin"

// the run script forks off the process in a separate
// terminal so we'd lose our handle to it.  Instead just
// invoke Demo directly
val demoBin = cBinDir / "slang-build" / (if (Os.isWin) "Demo.exe" else "Demo")

proc"${demoBin}".timeout(7000).console.run()