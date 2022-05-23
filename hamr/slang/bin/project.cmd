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

// Example Sireum Proyek build definitions -- the contents of this file will not be overwritten
//
// To install Sireum (Proyek and IVE) see https://github.com/sireum/kekinian#installing
//
// The following commands should be executed in the parent of the 'bin' directory.
//
// Command Line:
//   To run the demo from the command line using the default scheduler:
//     sireum proyek run . isolette.Demo
//
//   To see the available CLI options:
//     sireum proyek run . isolette.Demo -h
//
//   To run the example unit tests from the command line:
//     sireum proyek test .
//
//   To build an executable jar:
//     sireum proyek assemble --uber --main isolette.Demo .
//
// Sireum IVE:
//
//   If you prevented HAMR from running Proyek IVE then first generate the IVE project:
//     sireum proyek ive .
//
//   Then in IVE select 'File > Open ...' and navigate to the parent of the
//   'bin' directory and click 'OK'.
//
//   To run the demo from within Sireum IVE:
//     Right click src/app/jvm/src/main/scala/isolette/Demo.scala and choose "Run 'Demo'"
//
//   To run the unit test cases from within Sireum IVE:
//     Right click the src/test/bridge and choose "Run ScalaTests in bridge"
//
//   NOTE: A ClassNotFoundException may be raised the first time you try to
//         run the demo or unit tests.  If this occurs simply delete the directory
//         named 'target' and retry

import org.sireum._
import org.sireum.project.{JSON, Module, Project, ProjectUtil, Target}

def usage(): Unit = {
  println("Usage: [ json ]")
}

var isDot = T

Os.cliArgs match {
  case ISZ(string"json") => isDot = F
  case ISZ(string"-h") =>
    usage()
    Os.exit(0)
  case ISZ() =>
  case _ =>
    usage()
    Os.exit(-1)
}

val homeDir: Os.Path = Os.slashDir.up.canon

val jsTarget: ISZ[Target.Type] = ISZ(Target.Js)

val jvmTarget: ISZ[Target.Type] = ISZ(Target.Jvm)
val jvmLibrary: ISZ[String] = ISZ("org.sireum.kekinian::library:")

val sharedTarget: ISZ[Target.Type] = Module.allTargets
val sharedLibrary: ISZ[String] = ISZ("org.sireum.kekinian::library-shared:")

val jsDeps: ISZ[String] = ISZ("org.scala-js::scalajs-dom_sjs1:")

def module(id: String,
           baseDir: Os.Path,
           subPathOpt: Option[String],
           deps: ISZ[String],
           targets: ISZ[Target.Type],
           ivyDeps: ISZ[String],
           sources: ISZ[String],
           testSources: ISZ[String]): Module = {
  return Module(
    id = id,
    basePath = baseDir.string,
    subPathOpt = subPathOpt,
    deps = deps,
    targets = targets,
    ivyDeps = ivyDeps,
    resources = ISZ(),
    sources = sources,
    testSources = testSources,
    testResources = ISZ(),
    publishInfoOpt = None())
}

val artShared: Module = module(
  id = "art-shared",
  baseDir = homeDir / "src" / "infrastructure" / "art",
  subPathOpt = Some("shared"),
  deps = ISZ(),
  targets = sharedTarget,
  ivyDeps = sharedLibrary,
  sources = ISZ("src/main/scala"),
  testSources = ISZ())

val artJs: Module = module(
  id = "art-js",
  baseDir = homeDir / "src" / "infrastructure" / "art",
  subPathOpt = Some("js"),
  deps = ISZ(artShared.id),
  targets = sharedTarget,
  ivyDeps = sharedLibrary ++ jsDeps,
  sources = ISZ("src/main/scala"),
  testSources = ISZ())

val data: Module = module(
  id = "data",
  baseDir = homeDir / "src" / "common" / "data",
  subPathOpt = None(),
  deps = ISZ(artShared.id),
  targets = sharedTarget,
  ivyDeps = ISZ(),
  sources = ISZ("main"),
  testSources = ISZ())

val library: Module = module(
  id = "library",
  baseDir = homeDir / "src" / "common" / "library",
  subPathOpt = None(),
  deps = ISZ(data.id),
  targets = sharedTarget,
  ivyDeps = ISZ(),
  sources = ISZ("main"),
  testSources = ISZ())

val processes: ISZ[ISZ[String]] = ISZ(
  ISZ("thermostat","regulate_temperature"),
  ISZ("thermostat","monitor_temperature"),
  ISZ("operator_interface","oip"),
  ISZ("temperature_sensor","cpi"),
  ISZ("heat_source","cpi")
)

var apis: ISZ[Module] = ISZ()
var bridges: ISZ[Module] = ISZ()
var sharedComponents: ISZ[Module] = ISZ()
var jsComponents: ISZ[Module] = ISZ()
var jvmComponents: ISZ[Module] = ISZ()

for(p <- processes) {
  val id = ops.ISZOps(p).foldLeft((a: String, b: String) => s"${a}_${b}", "")

  val api = module(
    id = s"apis${id}",
    baseDir = (homeDir / "src" / "infrastructure" / "apis") /+ p,
    subPathOpt = None(),
    deps = ISZ(data.id),
    targets = sharedTarget,
    ivyDeps = ISZ(),
    sources = ISZ("main"),
    testSources = ISZ())

  val bridge: Module = module(
    id = s"bridges${id}",
    baseDir = (homeDir / "src" / "infrastructure" / "bridges") /+ p,
    subPathOpt = None(),
    deps = ISZ(api.id),
    targets = sharedTarget,
    ivyDeps = ISZ(),
    sources = ISZ("main"),
    testSources = ISZ())

  val componentShared: Module = module(
    id = s"components${id}_shared",
    baseDir = (homeDir / "src" / "components") /+ p,
    subPathOpt = Some("shared"),
    deps = ISZ(api.id, library.id),
    targets = sharedTarget,
    ivyDeps = ISZ[String](),
    sources = ISZ("main"),
    testSources = ISZ())

  val componentJs: Module = module(
    id = s"components${id}_js",
    baseDir = (homeDir / "src" / "components") /+ p,
    subPathOpt = Some("js"),
    deps = ISZ(componentShared.id),
    targets = jsTarget,
    ivyDeps = ISZ[String]() ++ jsDeps,
    sources = ISZ("main"),
    testSources = ISZ())

  val componentJvm: Module = module(
    id = s"components${id}_jvm",
    baseDir = (homeDir / "src" / "components") /+ p,
    subPathOpt = Some("jvm"),
    deps = ISZ(componentShared.id),
    targets = jvmTarget,
    ivyDeps = ISZ[String](),
    sources = ISZ("main"),
    testSources = ISZ())

  apis = apis :+ api
  bridges = bridges :+ bridge
  jsComponents = jsComponents :+ componentJs
  jvmComponents = jvmComponents :+ componentJvm
  sharedComponents = sharedComponents :+ componentShared
}

val architecture: Module = module(
  id = "architecture",
  baseDir = homeDir / "src" / "infrastructure" / "architecture",
  subPathOpt = None(),
  deps = bridges.map((m: Module) => m.id),
  targets = sharedTarget,
  ivyDeps = ISZ(),
  sources = ISZ("main"),
  testSources = ISZ())

val schedulers: Module = module(
  id = "schedulers",
  baseDir = homeDir / "src" / "infrastructure" / "schedulers",
  subPathOpt = None(),
  deps = ISZ(architecture.id),
  targets = sharedTarget,
  ivyDeps = ISZ(),
  sources = ISZ("main"),
  testSources = ISZ())

val appShared: Module = module(
  id = "app",
  baseDir = homeDir / "src" / "app",
  subPathOpt = Some("shared"),
  deps = sharedComponents.map((m: Module) => m.id),
  targets = sharedTarget,
  ivyDeps = ISZ(),
  sources = ISZ("src/main/scala"),
  testSources = ISZ())

val appJvm: Module = module(
  id = "appJvm",
  baseDir = homeDir / "src" / "app",
  subPathOpt = Some("jvm"),
  deps = ISZ(appShared.id, schedulers.id) ++ jvmComponents.map((m: Module) => m.id),
  targets = jvmTarget,
  ivyDeps = ISZ(),
  sources = ISZ("src/main/scala"),
  testSources = ISZ())

val appJs: Module = module(
  id = "appJs",
  baseDir = homeDir / "src" / "app",
  subPathOpt = Some("js"),
  deps = ISZ(appShared.id, artJs.id, schedulers.id) ++ jsComponents.map((m: Module) => m.id),
  targets = jsTarget,
  ivyDeps = ISZ(),
  sources = ISZ("src/main/scala"),
  testSources = ISZ())

val test: Module = module(
  id = "test",
  baseDir = homeDir / "src" / "test",
  subPathOpt = None(),
  deps = ISZ(appJvm.id),
  targets = jvmTarget,
  ivyDeps = ISZ(),
  sources = ISZ(),
  testSources = ISZ("bridge", "util"))

var nixModules: ISZ[Module] = ISZ()

val nixDir = homeDir / "src" / "infrastructure" / "nix"
if(nixDir.exists) {
  nixModules = nixModules :+ module(id = nixDir.name,
                                    baseDir = nixDir,
                                    subPathOpt = None(),
                                    deps = ISZ(appJvm.id),
                                    targets = jvmTarget,
                                    ivyDeps = ISZ(),
                                    sources = ISZ("main"),
                                    testSources = ISZ())
}

val seL4NixDir = homeDir / "src" / "infrastructure" / "seL4Nix"
if(seL4NixDir.exists) {
  nixModules = nixModules :+ module(id = seL4NixDir.name,
                                    baseDir = seL4NixDir,
                                    subPathOpt = None(),
                                    deps = (bridges ++ sharedComponents).map((m: Module) => m.id) :+ appShared.id,
                                    targets = jvmTarget,
                                    ivyDeps = ISZ(),
                                    sources = ISZ("main"),
                                    testSources = ISZ())
}

var mods = ISZ(artShared, artJs, architecture, data, library, schedulers, appShared, appJvm, appJs, test) ++
  apis ++ bridges ++ sharedComponents ++ jsComponents ++ jvmComponents ++ nixModules

var slangProject: Project = Project.empty
for(m <- mods) {
  slangProject = slangProject + m
}

val project: Project = slangProject

if (isDot) {
  val projectDot = homeDir / "project.dot"
  projectDot.writeOver(ProjectUtil.toDot(project))
  println(s"Wrote $projectDot")
} else {
  println(JSON.fromProject(project, T))
}
