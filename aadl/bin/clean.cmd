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

println("Only keep the user code in src/components and src/common/library")

def del(p: Os.Path): Unit = {
  assert (p.exists, s"${p} does not exist")
  p.removeAll()
  println(s"Removed ${p}")
}

del(hamrDir / "bin")
del(hamrDir / "src" / "app")
del(hamrDir / "src" / "common" / "data")
del(hamrDir / "src" / "infrastructure")
del(hamrDir / "src" / "inspector")
del(hamrDir / "src" / "test")
del(hamrDir / "versions.properties")
