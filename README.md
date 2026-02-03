# Tic Tac Toe Game (Android)

This project is an Android implementation of the Tic Tac Toe kata using Kotlin, Jetpack Compose and
MVVM Clean Architecture with Test Driven Development(TDD) Approach.

## Requirements

- Android Studio (latest stable recommended)
- JDK 17

## Requirements Covered

- X always goes first
- Players cannot play on a played position
- Players alternate placing X and O
- Game ends when:
    - A player has 3 in a row (row/column/diagonal) → Win
    - All 9 cells are filled with no winner → Draw
- Restart resets the game

---

## Tech Stack

- Kotlin
- Jetpack Compose (UI)
- MVVM (Presentation layer)
- Clean Architecture (minimal)
- JUnit (Unit testing)
- Kotlin Coroutines + StateFlow

---

## Architecture (Minimal Clean)

The project is split into:

### **Domain**

`com.kata.tictactoe.domain`

- Pure business logic
- No Android / UI dependencies
- Contains:
    - `Game`
    - `Board`
    - `Player`
    - `GameState`

### **Presentation**

`com.kata.tictactoe.presentation`

- ViewModel + UI State handling
- Compose screens/components
- Contains:
    - `GameViewModel`
    - `BoardScreen`
    - `BoardGrid`, `BoardCell`

---

## How to Run the App

1. Open the project in **Android Studio**
2. Sync Gradle
3. Run the **app** configuration

---

## How to Run Tests

### Run all unit tests

From Android Studio:

- `GameTest` / `GameViewModelTest` → Right click → **Run**

Or from terminal:

```bash
./gradlew test