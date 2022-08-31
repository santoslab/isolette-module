# ISOLETTE

<table>
<tr><td>Master</td>
<td> 
  <a href="https://github.com/santoslab/isolette-module/actions/workflows/CI-macOS.yml?query=branch%3Amaster">
  <img src="https://github.com/santoslab/isolette-module/actions/workflows/CI-macOS.yml/badge.svg" alt="macOS"></a>
  <a href="https://github.com/santoslab/isolette-module/actions/workflows/CI-linux.yml?query=branch%3Amaster">
  <img src="https://github.com/santoslab/isolette-module/actions/workflows/CI-linux.yml/badge.svg" alt="Linux"></a>
  <a href="https://github.com/santoslab/isolette-module/actions/workflows/CI-windows.yml?query=branch%3Amaster">
  <img src="https://github.com/santoslab/isolette-module/actions/workflows/CI-windows.yml/badge.svg" alt="Windows"></a>
</tr></table>

Click through one of the badges to download the CI artifacts (ie. the generated website/files)

## Build HAMR Codegen 'module' version of sireum.jar

The following assumes you don't want to modify your current working version of ``sireum.jar``

```bash
mkdir ~/temp
cd ~/temp
git clone --rec https://github.com/sireum/kekinian

cd ./kekinian/hamr/codegen/arsit
git checkout module
git pull --recurse

cd ../../../     # cd back to the root kekinian directory
./bin/build.cmd  # DO NOT PASS THE setup ARGUMENT -- see 'Opening in IVE'!
```

The rest of this readme assumes you've run the following in the shell you're using

```bash
export SIREUM_HOME=~/temp/kekinian
export PATH=$SIREUM_HOME/bin:$PATH
```

## Install FMIDE 

This version of FMIDE will use the ``sireum.jar`` built above

```bash
$SIREUM_HOME/bin/install/fmide.cmd fixed
```

##  Clone This Repository

```bash
git clone git@github.com:santoslab/isolette-module.git
```

## Regenerate Code

Optionally remove all previously generated code that wasn't modified by the user 
(e.g. keep component behavior code, code hooking up operating interfaces, library files)

```bash
./isolette-module/aadl/bin/clean.cmd
```

Refer to the run script
[run-hamr-jvm.cmd](aadl/bin/run-hamr-linux.cmd)
to see what options were passed to codegen if you want to generate code from inside FMIDE.  

From the command line you'd do:

```bash
./isolette-module/aadl/bin/run-hamr-jvm.cmd
```

## Opening in IVE

Realistically you can only have one installation each of IVE-Dev and IVE-Ultimate so the 
build steps above didn't install IVE under `$SIREUM_HOME/bin/`.  Hence the run scripts
use the `no-proyek-ive` codegen option meaning you have run proyek ive yourself.  Assuming 
your pristine copy of Sireum kekinian is at `$SIREUM_HOME_PRISTINE`, do the following

```bash
$SIREUM_HOME_PRISTINE/bin/sireum proyek ive ./isolette-module/hamr/slang
```

## Running on JVM

Refer to the comments in [hamr/slang/bin/project.cmd](hamr/slang/bin/project.cmd)

## Running via Browser

Generate the JS library

```bash
./isolette-module/hamr/slang/bin/scalajs.cmd
```

Then open [hamr/slang/index.html](hamr/slang/index.html) in a browser.  For example, on Linux

```bash
xdg-open ./isolette-module/hamr/slang/index.html
```

or on Mac

```bash
open ./isolette-module/hamr/slang/index.html
```

## Running Under Linux

Run the following script that adds additional Slang code to your project along with the necessary C infrastructure code.

```bash
./isolette-module/aadl/bin/run-hamr-linux.cmd
```


If you're on Mac or Windows then modify the stack-size using [stacksize-fix.cmd](aadl/bin/stacksize-fix.cmd).  Note this could also be done by modifying the ``StackSize`` [property](aadl/aadl/propertysets/Isolette_Properties.aadl#L97) in the model (or by modifying the ``stack-size`` argument in the generated [transpile.cmd](hamr/slang/bin/transpile.cmd#L111)).  However, the required Mac/Windows values are much larger than what is needed for Linux/seL4.

```bash
./isolette-module/aadl/bin/stacksize-fix.cmd
```

Any Slang code reachable from the JVM Demo's main method will be transpiled down to C automatically
since codegen'e `run-transpiler` option is used. This includes component behavior code since 
the `exclude-component-impl` option was not used.  Therefore you only need to implement the extension
methods in C as is done in [./hamr/c/ext-c/ext.c](./hamr/c/ext-c/ext.c) for this project.

Now compile and run the code (you'll of course need a C compiler like gcc and CMake)

```bash
./isolette-module/hamr/c/bin/compile.cmd
./isolette-module/hamr/c/bin/run.sh
```

