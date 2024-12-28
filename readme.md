# Terminal-based Tic Tac Toe

A classic Tic Tac Toe game implemented in Java that runs in the terminal. Players take turns marking spaces on a 3x3 grid, trying to get three of their marks in a row (horizontally, vertically, or diagonally).

## Features

- Interactive terminal-based gameplay
- Two-player support (X and O)
- Input validation and error handling
- Clear board display after each move
- Win detection for horizontal, vertical, and diagonal matches
- Draw detection when the board is full

## Prerequisites

To run this game, you need:
- Java Development Kit (JDK) 8 or higher
- A terminal/command prompt

## Installation

1. Clone this repository to your local machine:
```bash
git clone https://github.com/tleivy/tictactoe.git
cd tictactoe
```

2. Compile the Java file:
```bash
javac TicTacToe.java
```

## How to Play

1. Run the game:
```bash
java TicTacToe
```

2. The game board is numbered from 1-9, corresponding to positions on the 3x3 grid:
```
   1 2 3
  -------
A | | | |
  -------
B | | | |
  -------
C | | | |
  -------
```

3. Players take turns entering a number (1-9) to place their mark (X or O) in the corresponding position.
4. The game ends when either:
   - A player gets three marks in a row (horizontally, vertically, or diagonally)
   - The board is full (draw)

## Game Rules

- The first player in each round is chosen randomly.
- Players cannot place their mark in an already occupied position
- The game announces the winner or declares a draw when the game ends

## Contributing

Feel free to fork this project and submit pull requests with improvements. Some ideas for enhancement:
- Add computer player with AI
- Implement difficulty levels
- Create a GUI version

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Author

tleivy

## Acknowledgments

- Inspired by the classic Tic Tac Toe game