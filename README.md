## graalvm-v2301-set-posix-file-permissions-test

- For https://github.com/linghengqian/graalvm-trace-metadata-smoketest/commit/952c75870f61b2f611355a0b24bcd47cbdea6cac and https://github.com/oracle/graalvm-reachability-metadata/issues/206.
- Also For https://github.com/oracle/graal/issues/7390 .

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
[native-image-plugin] Native Image executable path: /home/linghengqian/.sdkman/candidates/java/17.0.9-graalce/lib/svm/bin/native-image
========================================================================================================================
GraalVM Native Image: Generating 'graalvm-v2301-set-posix-file-permissions-test-tests' (executable)...
========================================================================================================================
For detailed information and explanations on the build output, visit:
https://github.com/oracle/graal/blob/master/docs/reference-manual/native-image/BuildOutput.md
------------------------------------------------------------------------------------------------------------------------
[1/8] Initializing...                                                                                    (5.8s @ 0.16GB)
 Java version: 17.0.9+9, vendor version: GraalVM CE 17.0.9+9.1
 Graal compiler: optimization level: 2, target machine: x86-64-v3
 C compiler: gcc (linux, x86_64, 11.4.0)
 Garbage collector: Serial GC (max heap size: 80% of RAM)
 1 user-specific feature(s)
 - org.graalvm.junit.platform.JUnitPlatformFeature
[junit-platform-native] Running in 'test listener' mode using files matching pattern [junit-platform-unique-ids*] found in folder [/home/linghengqian/TwinklingLiftWorks/git/public/graalvm-v2301-set-posix-file-permissions-test/build/test-results/test/testlist] and its subfolders.
[2/8] Performing analysis...  [****]                                                                    (26.2s @ 0.80GB)
   6,951 (81.50%) of  8,529 types reachable
  10,472 (62.62%) of 16,724 fields reachable
  31,121 (52.41%) of 59,385 methods reachable
   2,133 types,     0 fields, and   848 methods registered for reflection
      59 types,    59 fields, and    52 methods registered for JNI access
       4 native libraries: dl, pthread, rt, z
[3/8] Building universe...                                                                               (3.5s @ 1.01GB)
[4/8] Parsing methods...      [**]                                                                       (2.9s @ 1.27GB)
[5/8] Inlining methods...     [***]                                                                      (1.6s @ 1.04GB)
[6/8] Compiling methods...    [*****]                                                                   (27.7s @ 1.08GB)
[7/8] Layouting methods...    [**]                                                                       (2.8s @ 1.49GB)
[8/8] Creating image...       [**]                                                                       (3.4s @ 1.80GB)
  13.38MB (44.26%) for code area:    19,464 compilation units
  15.55MB (51.46%) for image heap:  173,670 objects and 68 resources
   1.30MB ( 4.29%) for other data
  30.23MB in total
------------------------------------------------------------------------------------------------------------------------
Top 10 origins of code area:                                Top 10 object types in image heap:
   5.94MB java.base                                            2.92MB byte[] for code metadata
   3.78MB java.xml                                             1.66MB java.lang.String
1007.42kB svm.jar (Native Image)                               1.65MB java.lang.Class
 997.01kB byte-buddy-1.12.21.jar                               1.47MB byte[] for general heap data
 224.44kB jdk.zipfs                                            1.37MB byte[] for java.lang.String
 205.25kB junit-jupiter-engine-5.10.0.jar                    752.10kB byte[] for embedded resources
 199.88kB jdk.proxy4                                         597.35kB com.oracle.svm.core.hub.DynamicHubCompanion
 137.84kB junit-platform-launcher-1.10.0.jar                 513.00kB int[][]
 114.85kB java.logging                                       448.88kB java.util.HashMap$Node
 111.12kB junit-platform-reporting-1.10.0.jar                353.02kB java.lang.String[]
 616.67kB for 17 more packages                                 3.00MB for 1695 more object types
------------------------------------------------------------------------------------------------------------------------
Recommendations:
 HEAP: Set max heap for improved and more predictable memory usage.
 CPU:  Enable more CPU features with '-march=native' for improved performance.
------------------------------------------------------------------------------------------------------------------------
                        3.8s (5.0% of total time) in 46 GCs | Peak RSS: 3.08GB | CPU load: 4.81
------------------------------------------------------------------------------------------------------------------------
Produced artifacts:
 /home/linghengqian/TwinklingLiftWorks/git/public/graalvm-v2301-set-posix-file-permissions-test/build/native/nativeTestCompile/graalvm-v2301-set-posix-file-permissions-test-tests (executable)
========================================================================================================================
Finished generating 'graalvm-v2301-set-posix-file-permissions-test-tests' in 1m 14s.
[native-image-plugin] Native Image written to: /home/linghengqian/TwinklingLiftWorks/git/public/graalvm-v2301-set-posix-file-permissions-test/build/native/nativeTestCompile

> Task :nativeTest FAILED
JUnit Platform on Native Image - report
----------------------------------------

com.lingh.ContestTest > test() FAILED


Failures (1):
  JUnit Jupiter:ContestTest:test()
    MethodSource [className = 'com.lingh.ContestTest', methodName = 'test', methodParameterTypes = '']
    => java.lang.UnsupportedOperationException
       java.base@17.0.9/java.nio.file.Files.setPosixFilePermissions(Files.java:2166)
       com.lingh.ContestTest.test(ContestTest.java:30)
       java.base@17.0.9/java.lang.reflect.Method.invoke(Method.java:568)
       java.base@17.0.9/java.util.ArrayList.forEach(ArrayList.java:1511)
       java.base@17.0.9/java.util.ArrayList.forEach(ArrayList.java:1511)

Test run finished after 3 ms
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

BUILD FAILED in 1m 17s
8 actionable tasks: 8 executed

```