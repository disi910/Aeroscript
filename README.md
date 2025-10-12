

## Build with tests:
./gradlew build

## Build without tests:
./gradlew build -x test

## Run with args
Usage: java -jar build/libs/aeroscript-1.0.jar <path to file> [-b <battery level>] [-p <x> <y>]

## How to run
Step 1:
./gradlew build -x test

Step 2:
java -jar build/libs/aeroscript-1.0.jar build/resources/test/program.aero -b 100 -p 10 10

