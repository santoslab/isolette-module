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

val hamrDir = Os.slashDir.up.up / "hamr" / "slang"

println("Only keep the behavior code in src/components")

ISZ("bin", "src/app", "src/common", "src/infrastructure", "src/inspector", "src/test", "versions.properties").foreach(p => {
  val _p = (hamrDir / p)
  println(s"Removing: ${_p}" )
  _p.removeAll()
})
