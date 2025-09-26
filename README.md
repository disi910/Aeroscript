

## Build with tests:
./gradlew build

## Build withut tests:
./gradlew build -x test

## Run that shit
java −jar build/libs/aeroscript −1.0.jar example.txt

## Run with args
Usage: java -jar aeroscript.jar <path to file> [-b <battery level>] [-p <x> <y>]



## What has been done:
- Completed antlr code
- Interpreter:
    - visitProgram started at least
    - Completed acMove which serves as a skeleton for the rest of the actions
    - Started on visitStatement where i need to fill in rest of actions


## TODO:
What the hell to do with the heap and stack