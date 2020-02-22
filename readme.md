## Symja Library - Java Symbolic Math System

**Note**: this repository contains the **Java 8** version of the project. The [NCalc](https://github.com/tranleduy2000/ncalc) and [Natural Calc](https://github.com/tranleduy2000/naturalcalc)  projects maintains a [Java 7 branch based on Retrolambda](https://github.com/tranleduy2000/symja_android_library).

Use especially the "2nd" button in the following calculator interfaces:

<a href="https://play.google.com/store/apps/details?id=com.duy.calc.casio.v2">
	<img src="en_badge_web_generic.png" alt="Google Play" width="200"></a>
<a href="https://itunes.apple.com/us/app/ncalc-scientific-calculator/id1449106995">
	<img src="http://www.lawprose.org/wordpress/wp-content/uploads/App-Store-Badge.png" alt="App Store" width="200"></a>

- [Quick start](#quick-start)
- [Features](#features)
- [Applications](#applications)
- [Examples](#examples)
- [Gradle Usage](#gradle-usage)
- [Getting started](#getting-started)
- [Github GIT](#github-git)
- [Contact](#contact)
- [License](#license)
  
### Quick start 

Read the [Symja Manual](symja_android_library/doc/index.md) for the description of the Symja language or [browse the available functions](symja_android_library/doc/functions/). We encourage everyone to participate in our [Wiki](https://github.com/axkr/symja_android_library/wiki).

[![Join the chat at https://gitter.im/symja_android_library/Lobby](https://badges.gitter.im/symja_android_library/Lobby.svg)](https://gitter.im/symja_android_library/Lobby?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

### Features

Features of the Symja language:

* arbitrary precision integers, rational and complex numbers
* [differentiation](https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/D.md), [integration](https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/Integrate.md), [equation solving](https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/Solve.md), [linear algebra](https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/linear-algebra.md), [number theory](https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/number-theoretic-functions.md), [combinatorial](https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/combinatorial.md), [logic](https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/logic.md) and polynomial functions...
* a general purpose [Term Rewriting System and Pattern Matching engine](symja_android_library/doc/functions-and-patterns.md)
* use human readable math expression strings or the internal abstract syntax tree (AST) representation to code in Java. See the [Unit test examples](symja_android_library/matheclipse-core/src/test/java/org/matheclipse/core/system/LowercaseTestCase.java)
* two [REPLs](https://en.wikipedia.org/wiki/Read%E2%80%93eval%E2%80%93print_loop) are available in the library. A [Console.java](https://github.com/axkr/symja_android_library/blob/master/symja_android_library/matheclipse-core/src/main/java/org/matheclipse/core/eval/Console.java) for standard math input and a [MMAConsole.java](https://github.com/axkr/symja_android_library/blob/master/symja_android_library/matheclipse-core/src/main/java/org/matheclipse/core/eval/MMAConsole.java) for "Mathematica like syntax" input.
* Symja with "Mathematica like syntax" input can also be used interactively in a [BeakerX/Jupyter Lab](https://github.com/axkr/symja_android_library/wiki/BeakerX-usage) environment
* Symja can also be used interactively in the [Java jshell](https://github.com/axkr/symja_android_library/wiki/JShell-usage)
* the [Rubi symbolic integration rules](https://github.com/axkr/symja_android_library/wiki/Porting-Rubi-Integration-rules-to-Symja) are used to implement the [Integrate](https://github.com/axkr/symja_android_library/blob/master/symja_android_library/doc/functions/Integrate.md) function, they can be systematically applied to determine the antiderivative of a wide variety of mathematical expressions. 

### Applications

* [Appengine web interface symjaweb.appspot.com](http://symjaweb.appspot.com/) - available as open source in this [Github repository](https://github.com/axkr/symja_web) 

* [Android App Calculator N+ on Google play store](https://play.google.com/store/apps/details?id=com.duy.calculator.free) - available as open source in this [Github repository](https://github.com/tranleduy2000/ncalc) provides an **IDE mode** to calculate arbitrary Symja expressions.

* [Eclipse EASE extension - use Symja as a REPL in Eclipse](https://github.com/axkr/ease_symja) with this [example Github repository](https://github.com/axkr/symja_examples) which contains some Symja example scripts.

### Examples

To get an idea of the kinds of expressions Symja handles, see the [tests in this file](https://github.com/axkr/symja_android_library/blob/master/symja_android_library/matheclipse-core/src/test/java/org/matheclipse/core/system/LowercaseTestCase.java).

![Console Examples](console.gif)

```mma
>>> 24/60
2/5

>>> N(24/60)
0.4

>>> sin(30*degree)
1/2

>>> sin(pi/2)
1

>>> a+a+4*b^2+3*b^2
2*a+7*b^2

>>> solve({x^2-11==y, x+y==-9}, {x,y})
{{x->-2,y->-7},{x->1,y->-10}}

>>> dsolve({y'(x)==y(x)+2,y(0)==1},y(x), x)
{{y(x)->-2+3*E^x}}

>>> integrate(cos(x)^5, x)
-2/3*Sin(x)^3+Sin(x)^5/5+Sin(x)

>>> D(sin(x^3), x)
3*x^2*Cos(x^3)

>>> factor(-1+x^16)
(-1+x)*(1+x)*(1+x^2)*(1+x^4)*(1+x^8)

>>> factor(5+x^12, Modulus->7)
(2+x^3)*(4+x^6)*(5+x^3)

>>> expand((-1+x)*(1+x)*(1+x^2)*(1+x^4)*(1+x^8))
-1+x^16

>>> det({{1,2},{3,4}})
-2

>>> inverse({{1,2},{3,4}})
{{-2,1},
 {3/2,-1/2}}

>>> factorinteger(2^15-5)
{{3,1},{67,1},{163,1}}

>>> refine(abs(n*abs(m)), n<0)
-n*Abs(m)
```


### Maven Usage

1. Download latest version from https://github.com/tranleduy2000/symja_android_library/releases
2. Compile project using Android Studio
- Select ``File`` -> ``New`` -> ``Module``
- Select ``Import jar/aar package``
- Enter path of ``*.aar`` has been downloaded and click ``Finish``

3. In your submodule ``gradle`` file, add

```gradle
dependencies {
    implementation project(':symja_android_library-release')
}
```

```gradle
android {
    defaultConfig {
        multiDexEnabled true
    }
}
```

5. To build android app, open ``gradle.properties`` and add this line. This project required ``8GB RAM`` to build
```
org.gradle.jvmargs=-Xmx8192M -XX:+HeapDumpOnOutOfMemoryError -Dfile.encoding=UTF-8
```

5. Sync project

### Github GIT

a) Fork the Symja repository to use as a starting point.

* Navigate to [github.com/axkr/symja_android_library](https://github.com/axkr/symja_android_library)  in your browser.
* Click the "Fork" button in the top-right of the page.
* Once your fork is ready, open the new repository's "Settings" by clicking the link in the menu bar on the left.
* Change the repository name to the name of your Library and save your changes.
  
b) Clone your new repository to your ``Google Android Studio`` or ``JetBrains IntelliJ Ideas`` workspace.

* Download at https://www.jetbrains.com/idea/ or https://developer.android.com/studio/index.html
* Select ``File`` -> ``New`` -> ``Project from version control`` -> ``GitHub``
* Enter your git repo -> click ``Clone``
* Wait for sync project

For more information, see https://developer.android.com/studio/intro/migrate.html

### Contact

If you have any questions about using or developing for this project, send me an [email][1]!

### License

* the complete Symja system is published under the GNU GENERAL PUBLIC LICENSE Version 3.

If you would like to use parts of the system here are the associated licenses:

* the [JAS Java Algebra System](http://krum.rz.uni-mannheim.de/jas/) is published under the (LESSER) GNU GENERAL PUBLIC LICENSE licence. The Java bytecode is dual licenced also under the Apache 2.0 licence to allow usage in Android projects.  
* the [Hipparchus Mathematics Library](https://www.hipparchus.org/) is published under the Apache software licence
* the Symja parser libraries (org.matheclipse.parser* packages) are published under the APACHE LICENSE Version 2.0.

[1]: mailto:axelclk@gmail.com
