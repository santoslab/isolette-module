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


val sireumBin = Os.path(Os.env("SIREUM_HOME").get) / "bin" 
val sireum = sireumBin / (if(Os.isWin) "sireum.bat" else "sireum")

val fmide : Os.Path = 
  if(Os.isWin) sireumBin / "win" / "fmide" / "fmide.exe"
  else if(Os.isLinux) sireumBin / "linux" / "fmide" / "fmide"
  else if(Os.isMac) sireumBin / "mac" / "fmide.app" / "Contents" / "MacOS" / "osate"
  else sireum / "unsupported-OS"

if(!fmide.exists) {
  println(s"Please install FMIDE by running ${ (sireumBin / "install" / "fmide.cmd").canon.string }");
  Os.exit(-1);
}
  
val osireum = ISZ(fmide.string, "-nosplash", "-console", "-consoleLog", "-data", "@user.home/.sireum", "-application", "org.sireum.aadl.osate.cli")

if(Os.cliArgs.size > 1) {
  eprintln("Only expecting a single argument")
  Os.exit(1)
}

val platform: String =
  if(Os.cliArgs.nonEmpty) Os.cliArgs(0)
  else "JVM"

val codegenArgs = ISZ("hamr", "codegen",
  "--verbose",
  "--platform", platform,
  "--package-name", "isolette",
  "--output-dir", (aadlDir.up / "hamr" / "slang").string,
  "--output-c-dir", (aadlDir.up / "hamr" / "c").string,
  "--camkes-output-dir", (aadlDir.up / "hamr" / "camkes").string,
  "--no-proyek-ive",
  "--run-transpiler", 
  "--max-string-size", "500",
  "--aadl-root-dir", aadlDir.string,
  (aadlDir / ".system").string)

val results = Os.proc(osireum ++ codegenArgs).console.run()

// Running under windows results in 23 which is an indication 
// a platform restart was requested. Codegen completes 
// successfully and the cli app returns 0 so 
// not sure why this is being issued.
if(results.exitCode == 0 || results.exitCode == 23) {
  Os.exit(0)
} else {
  println(results.err)
  Os.exit(results.exitCode)
}
