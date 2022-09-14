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

val to: Z = if(Os.isMac) 30000 else 10000

println("-------------------------------------------------------------")
println(s"Attempting to run the C demo for ${to}ms at ${demoBin.value}")
println("-------------------------------------------------------------")

println("It will use the following CMakeLists.txt")
val cmakeLists = cBinDir.up / "nix" / "CMakeLists.txt"
println(cmakeLists.read)

println(s"Demo exists? ${demoBin.exists}")
if(Os.isMac) {
  proc"ls -laig ${demoBin.up}".console.run()
}
println("------------ B E G I N   ${to}ms  O F  D E M O   O U T P U T --------------")

val results = proc"${demoBin}".timeout(to).console.run()

println("------------ E N D   D E M O   O U T P U T --------------")

println(s"exitcode: ${results.exitCode}")

println("stdout proc stream:")
println(results.out)

println("stderr proc stream:")
eprintln(results.err)
