# AeroScript

A domain-specific language (DSL) for programming autonomous drone flight plans. AeroScript lets you define named execution modes with drone actions like movement, turning, ascending, and descending, connected through state transitions.

## Example

```
-> RandomTour { ascend by 20 } -> TakeOff
TakeOff {
    ascend by 20
    move to point (random[0, 100], random[0, 100])
    descend by 10
} -> Explore
Explore {
    ascend by 20 at speed 10
    move to point (random[0, 100], random[0, 100])
    descend by 10
} -> Investigate
Investigate {
    ascend by 20 for 10 seconds
    move by 600
    turn left by 360 at speed 10
    descend by 10
} -> GoHome
GoHome {
    return to base
}
```

## Language Features

**Actions:**
- `move by <distance>` / `move to point (<x>, <y>)` — translate the drone
- `turn left|right by <degrees>` — rotate the drone
- `ascend by <altitude>` / `descend by <altitude>` — change altitude
- `return to base` — return to the starting position and land

**Modifiers:**
- `at speed <n>` — set action speed
- `for <n> seconds` — set action duration

**Expressions:**
- Numbers, arithmetic (`+`, `-`, `*`)
- `point (<x>, <y>)` — 2D coordinates
- `random[<min>, <max>]` — random value within a range

**Execution modes:** Named blocks connected with `->` to define state transitions.

## Build & Run

Requires Java 17+ and Gradle.

```bash
# Build (with tests)
./gradlew build

# Build (without tests)
./gradlew build -x test

# Run
java -jar build/libs/aeroscript-1.0.jar <file.aero> [-b <battery>] [-p <x> <y>]
```

### CLI Options

| Flag | Description | Default |
|------|-------------|---------|
| `-b <level>` | Initial battery level (0–100) | 100 |
| `-p <x> <y>` | Initial position | 0, 0 |

### Example

```bash
./gradlew build -x test
java -jar build/libs/aeroscript-1.0.jar src/test/resources/program.aero -b 100 -p 10 10
```

## Testing

```bash
./gradlew test
```

## Architecture

Built with ANTLR4 for lexing/parsing and a visitor-based interpreter pattern.

```
src/main/
├── antlr/AeroScript.g4          # Grammar definition
└── java/no/uio/aeroscript/
    ├── Main.java                 # CLI entry point
    ├── ast/
    │   ├── expr/                 # Expression AST nodes
    │   └── stmt/                 # Statement/action AST nodes
    ├── runtime/Interpreter.java  # Visitor-based execution engine
    └── type/                     # Domain types (Point, Direction, Range)
```

The interpreter tracks drone state (position, altitude, battery, distance travelled) and simulates battery consumption based on action parameters.
