# 2048 Game

This is a Java implementation of the classic 2048 game. The game is played on a 4x4 grid, where the goal is to reach the tile with a value of 2048. Tiles with the same value can be merged when they are adjacent, and the player can make moves in four directions: up, down, left, and right.

#How to Play

Run the TwentyFortyEight class, and the game will initialize with two random tiles (90% chance for a 2, 10% chance for a 4) placed on the grid.
The game will present the current state of the board, along with your score. The score is the sum of all the values on the board.
Enter your move using the following keys:

w: Move tiles upwards.

a: Move tiles to the left.

s: Move tiles downwards.

d: Move tiles to the right.

After each move, a new tile will be added to the board (if there's an empty cell). Tiles with the same value will merge if they are adjacent.
Continue making moves to merge tiles and increase your score.
The game ends when there are no valid moves left on the board (no adjacent tiles with the same value, and no empty cells).
At the end of the game, your final score will be displayed, and the game will be over.

# Code Overview

The code is organized as follows:
TwentyFortyEight class: Represents the game logic, including board initialization, tile addition, movement, merging, and checking for game over.
main method: The entry point of the program. It initializes the game, takes user input for moves, and continues until the game is over.
Feel free to explore and modify the code to add new features or enhance the gameplay. Have fun playing and experimenting with the game!

# Future Work and Enhancements

While the current implementation of the 2048 game is functional as a text-based command-line game, there are several opportunities for future improvements and enhancements. Here are some ideas for taking this project further:

1. Graphical User Interface (GUI)
Implementing a graphical user interface (GUI) can greatly enhance the user experience of the game. Consider using a Java GUI library such as JavaFX or Swing to create a visually appealing interface for the game board, tiles, and user interactions.

2. Visual Effects and Animations
Add animations and visual effects to make the game more engaging. Animations for tile merging and movement can provide feedback to the player and make the game feel smoother.

3. High Scores
Implement a high score system that keeps track of the top scores achieved by players. Store the scores in a file or a database and display them on the GUI.
