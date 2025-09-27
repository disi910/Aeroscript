

## Build with tests:
./gradlew build

## Build withut tests:
./gradlew build -x test

## Run that shit
java −jar build/libs/aeroscript−1.0.jar example.txt

## Run with args
Usage: java -jar aeroscript.jar <path to file> [-b <battery level>] [-p <x> <y>]
Usage: java -jar aeroscript.jar build/libs/aeroscript-1.0.jar -b 100 -p 10 10



## What has been done:
- Completed antlr code
- Interpreter:
    - visitProgram started at least
    - Completed acMove which serves as a skeleton for the rest of the actions
    - Started on visitStatement where i need to fill in rest of actions
- All actions are implemented
- I think im done?


## TODO:
What the hell to do with the heap and stack (i understand it now (nevermind what the flip is the stack for))
Figure out how to "terminate" program


## Limitations
- Execution/mode names cannot have numbers in them.
- If two modes have the same ID there will be errors. 