# Chess Game in Java Using Swing - README

## ChessGameJava

A Java-based Chess Game using Swing.

---

## 📌 Project Overview

This project is a simple 2-player Chess Game created using Java and the Swing library. It uses a GUI built with `JFrame`, `JPanel`, and `JLabel`, enabling players to interact by clicking on chess pieces and making moves.

---

## ✅ Features

- Interactive GUI chessboard (8x8 grid).
- Unicode symbols for representing pieces.
- Two-player turn-based gameplay.
- Legal move validation for each piece.
- King capture detection to end the game.
- Basic highlighting of selected squares.

---

## 🖥️ Technologies Used

- Java SE 8+
- Swing (for GUI)
- 2D arrays for board representation (JLabel[8][8])
- Event handling with MouseAdapter
- Nested loops and conditionals for board scanning and move validation

---

## 📂 Folder Structure

```
ChessGameJava/
├── src/
│   └── Chess.java
├── README.md
├── .gitignore
├── LICENSE (MIT)
```

---

## 🛠️ How to Run

1. Open the project in **BlueJ** or any Java IDE.
2. Compile and run `Chess.java`.
3. Click on pieces to move them. Each turn is alternated.
4. The game ends when one king is captured.

---

## ⚠️ Limitations

- ❌ No check/checkmate/stalemate detection.
- ❌ No castling, pawn promotion, or en passant.
- ❌ Only supports manual two-player mode.
- ❌ Does not follow full official chess rules.
- ❌ No undo, restart, or save/load support.
- ❌ Game ends only on king capture (not standard).

---

## 📌 Future Enhancements

- ✅ Full rule enforcement (check/checkmate/stalemate).
- ✅ Add AI for single-player mode.
- ✅ Implement castling, promotion, en passant.
- ✅ Add undo, reset, and save/load options.

---

## 👩‍💻 Author

**Anjali Khattar**

---

## 📝 License

This project is licensed under the **MIT License**.

---

## 🔗 Repository Link

[GitHub - ChessGameJava](https://github.com/Anjalikhattar/ChessGameJava)
