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

val hamrDir = Os.slashDir.up.up / "hamr"

println("Deleting everything except user modified files")

def del(p: Os.Path): Unit = {
  if(p.exists){
    p.removeAll()
    println(s"Removed ${p}")
  }
}

// keep the ExternalConfig<Js/Jvm> files in app folder,
// keep files in components folder
// keep files in common/library

val slangDir = hamrDir / "slang"
del(slangDir / "bin")
del(slangDir / "src" / "app" / "js" / "src" / "main" / "scala" / "isolette" / "config" / "AppPlatformJs.scala")
del(slangDir / "src" / "app" / "js" / "src" / "main" / "scala" / "isolette" / "Demo.scala")
del(slangDir / "src" / "app" / "jvm" / "src" / "main" / "scala" / "isolette" / "config" / "AppPlatformJvm.scala")
del(slangDir / "src" / "app" / "jvm" / "src" / "main" / "scala" / "isolette" / "Demo.scala")
del(slangDir / "src" / "app" / "shared")
del(slangDir / "src" / "common" / "data")
del(slangDir / "src" / "infrastructure")
del(slangDir / "src" / "inspector")
del(slangDir / "src" / "test")
del(slangDir / "versions.properties")

val cDir = hamrDir / "c"
del(cDir / "bin")
del(cDir / "etc")
del(cDir / "etc-c" / "ext.h")
del(cDir / "ext-schedule")
del(cDir / "nix")
