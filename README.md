## graalvm-v2301-set-posix-file-permissions-test

- Execute the following command on the new Ubuntu 22.04.3 LTS instance.
```shell
sudo apt install unzip zip curl sed -y
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk install java 17.0.8-graalce
sdk use java 17.0.8-graalce

git clone git@github.com:linghengqian/graalvm-v2301-set-posix-file-permissions-test.git
cd ./graalvm-v2301-set-posix-file-permissions-test/
./gradlew -Pagent clean test
./gradlew metadataCopy --task test
./gradlew clean nativeTest
```

- The Error Log is as follows.
```shell
$ ./gradlew clean nativeTest

> Task :generateTestResourcesConfigFile
[native-image-plugin] Resources configuration written into /home/linghengqian/TwinklingLiftWorks/git/public/graalvm-v2301-set-posix-file-permissions-test/build/native/generated/generateTestResourcesConfigFile/resource-config.json

> Task :nativeTestCompile
[native-image-plugin] GraalVM Toolchain detection is disabled
[native-image-plugin] GraalVM location read from environment variable: JAVA_HOME
[native-image-plugin] Native Image executable path: /home/linghengqian/.sdkman/candidates/java/17.0.8-graalce/lib/svm/bin/native-image
========================================================================================================================
GraalVM Native Image: Generating 'graalvm-v2301-set-posix-file-permissions-test-tests' (executable)...
========================================================================================================================
For detailed information and explanations on the build output, visit:
https://github.com/oracle/graal/blob/master/docs/reference-manual/native-image/BuildOutput.md
------------------------------------------------------------------------------------------------------------------------
[1/8] Initializing...                                                                                    (7.0s @ 0.16GB)
 Java version: 17.0.8+7, vendor version: GraalVM CE 17.0.8+7.1
 Graal compiler: optimization level: 2, target machine: x86-64-v3
 C compiler: gcc (linux, x86_64, 11.4.0)
 Garbage collector: Serial GC (max heap size: 80% of RAM)
 1 user-specific feature(s)
 - org.graalvm.junit.platform.JUnitPlatformFeature
[junit-platform-native] Running in 'test listener' mode using files matching pattern [junit-platform-unique-ids*] found in folder [/home/linghengqian/TwinklingLiftWorks/git/public/graalvm-v2301-set-posix-file-permissions-test/build/test-results/test/testlist] and its subfolders.
[2/8] Performing analysis...  [***]                                                                     (30.8s @ 0.56GB)
   6,871 (81.29%) of  8,452 types reachable
  10,238 (62.47%) of 16,389 fields reachable
  30,382 (51.77%) of 58,687 methods reachable
   2,116 types,     0 fields, and   843 methods registered for reflection
      59 types,    59 fields, and    52 methods registered for JNI access
       4 native libraries: dl, pthread, rt, z
[3/8] Building universe...                                                                               (3.7s @ 0.74GB)
[4/8] Parsing methods...      [**]                                                                       (2.3s @ 1.09GB)
[5/8] Inlining methods...     [****]                                                                     (1.5s @ 0.85GB)
[6/8] Compiling methods...    [*****]                                                                   (24.8s @ 1.10GB)
[7/8] Layouting methods...    [**]                                                                       (2.3s @ 1.48GB)
[8/8] Creating image...       [**]                                                                       (3.0s @ 1.79GB)
  12.96MB (43.67%) for code area:    18,898 compilation units
  15.45MB (52.07%) for image heap:  172,116 objects and 68 resources
   1.26MB ( 4.26%) for other data
  29.67MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 origins of code area:                                Top 10 object types in image heap:
   5.84MB java.base                                            2.82MB byte[] for code metadata
   3.78MB java.xml                                             1.65MB java.lang.String
 997.08kB byte-buddy-1.12.21.jar                               1.63MB java.lang.Class
 911.24kB svm.jar (Native Image)                               1.46MB byte[] for general heap data
 205.26kB junit-jupiter-engine-5.10.0.jar                      1.36MB byte[] for java.lang.String
 199.88kB jdk.proxy4                                         752.10kB byte[] for embedded resources
 137.81kB junit-platform-launcher-1.10.0.jar                 590.48kB com.oracle.svm.core.hub.DynamicHubCompanion
 114.85kB java.logging                                       513.00kB int[][]
 111.12kB junit-platform-reporting-1.10.0.jar                442.69kB java.util.HashMap$Node
 108.10kB assertj-core-3.24.2.jar                            349.84kB java.lang.String[]
 506.31kB for 16 more packages                                 2.99MB for 1680 more object types
------------------------------------------------------------------------------------------------------------------------
Recommendations:
 HEAP: Set max heap for improved and more predictable memory usage.
 CPU:  Enable more CPU features with '-march=native' for improved performance.
------------------------------------------------------------------------------------------------------------------------
                        4.2s (5.4% of total time) in 47 GCs | Peak RSS: 2.99GB | CPU load: 4.71
------------------------------------------------------------------------------------------------------------------------
Produced artifacts:
 /home/linghengqian/TwinklingLiftWorks/git/public/graalvm-v2301-set-posix-file-permissions-test/build/native/nativeTestCompile/graalvm-v2301-set-posix-file-permissions-test-tests (executable)
========================================================================================================================
Finished generating 'graalvm-v2301-set-posix-file-permissions-test-tests' in 1m 16s.
[native-image-plugin] Native Image written to: /home/linghengqian/TwinklingLiftWorks/git/public/graalvm-v2301-set-posix-file-permissions-test/build/native/nativeTestCompile

> Task :nativeTest FAILED
JUnit Platform on Native Image - report
----------------------------------------

com.lingh.ContestTest > test() FAILED


Failures (1):
  JUnit Jupiter:ContestTest:test()
    MethodSource [className = 'com.lingh.ContestTest', methodName = 'test', methodParameterTypes = '']
    => java.nio.file.NoSuchFileException: /script/demo.sh
       java.base@17.0.8/sun.nio.fs.UnixFileAttributeViews$Posix.setMode(UnixFileAttributeViews.java:277)
       java.base@17.0.8/sun.nio.fs.UnixFileAttributeViews$Posix.setPermissions(UnixFileAttributeViews.java:299)
       java.base@17.0.8/java.nio.file.Files.setPosixFilePermissions(Files.java:2167)
       com.lingh.ContestTest.test(ContestTest.java:24)
       java.base@17.0.8/java.lang.reflect.Method.invoke(Method.java:568)
       java.base@17.0.8/java.util.ArrayList.forEach(ArrayList.java:1511)
       java.base@17.0.8/java.util.ArrayList.forEach(ArrayList.java:1511)

Test run finished after 2 ms
[         2 containers found      ]
[         0 containers skipped    ]
[         2 containers started    ]
[         0 containers aborted    ]
[         2 containers successful ]
[         0 containers failed     ]
[         1 tests found           ]
[         0 tests skipped         ]
[         1 tests started         ]
[         0 tests aborted         ]
[         0 tests successful      ]
[         1 tests failed          ]


FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':nativeTest'.
> Process 'command '/home/linghengqian/TwinklingLiftWorks/git/public/graalvm-v2301-set-posix-file-permissions-test/build/native/nativeTestCompile/graalvm-v2301-set-posix-file-permissions-test-tests'' finished with non-zero exit value 1

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
> Get more help at https://help.gradle.org.

Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.

You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.

For more on this, please refer to https://docs.gradle.org/8.2/userguide/command_line_interface.html#sec:command_line_warnings in the Gradle documentation.

BUILD FAILED in 1m 19s
8 actionable tasks: 8 executed

```