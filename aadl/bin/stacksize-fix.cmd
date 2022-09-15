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

val aadlDir = Os.slashDir.up

val cmakeDir = aadlDir.up / "hamr" / "c" / "nix"

if (cmakeDir.exists) {
   val cmakelists = cmakeDir / "CMakeLists.txt"

   assert (cmakelists.exists)

   val contents = ops.StringOps(cmakelists.read)

   val stackSize: String = 
   if(Os.isMac) "2375680"
   else if(Os.isWin) "2334720"
   else if(Os.isLinux) "doesn't-matter?"
   else "-1"

   val newContent = contents.replaceAllLiterally("229376", stackSize)
   
   cmakelists.writeOver(newContent)

   println(s"Updated: ${cmakelists.value}")
   println(s" Changed stack-size from 229376 to ${stackSize}")
} else {
    println(s"CMake directory does not exists.  Have you transpiled yet?")
}
