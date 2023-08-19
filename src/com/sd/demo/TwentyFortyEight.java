package com.sd.demo;
import java.util.Scanner;

public class TwentyFortyEight {
    private static final int SIZE = 4;
    private int[][] board;
    public TwentyFortyEight() {
        board = new int[SIZE][SIZE];
        addTile();
        addTile();
    }
    private void addTile() {
        // Count empty cells to determine if a new tile can be added
        int emptyCells = 0;
        for (int[] row : board) {
            for (int cell : row) {
                if (cell == 0) {
                    emptyCells++;
                }
            }
        }
        if (emptyCells == 0) {
            return;
        }
        // Determine tile value (90% chance for 2, 10% chance for 4)
        int tileValue = Math.random() < 0.9 ? 2 : 4;
        int emptyCellIndex = (int) (Math.random() * emptyCells) + 1;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    emptyCellIndex--;
                    if (emptyCellIndex == 0) {
                        board[row][col] = tileValue;
                        return;
                    }
                }
            }
        }
    }
    private void printBoard() {
        System.out.println("\nScore: " + getScore());
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
    private int getScore() {
        int score = 0;
        for (int[] row : board) {
            for (int cell : row) {
                score += cell;
            }
        }
        return score;
    }
    private void mergeRow(int[] row) {
        // Merge adjacent tiles in a row
        for (int i = 0; i < SIZE - 1; i++) {
            if (row[i] == row[i + 1] && row[i] != 0) {
                row[i] *= 2;
                row[i + 1] = 0;
            }
        }
    }
    private void moveLeft() {
        for (int[] row : board) {
            // Merge tiles
            mergeRow(row);
            // Shift non-empty tiles to the left
            int index = 0;
            for (int i = 0; i < SIZE; i++) {
                if (row[i] != 0) {
                    row[index++] = row[i];
                }
            }
            while (index < SIZE) {
                row[index++] = 0;
            }
        }
    }
    private void moveRight() {
        for (int[] row : board) {
            // Merge tiles
            mergeRow(row);
            // Shift non-empty tiles to the right
            int index = SIZE - 1;
            for (int i = SIZE - 1; i >= 0; i--) {
                if (row[i] != 0) {
                    row[index--] = row[i];
                }
            }
            while (index >= 0) {
                row[index--] = 0;
            }
        }
    }
    private void transposeBoard() {
        // Transpose the board (rows become columns, and vice versa)
        int[][] newBoard = new int[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                newBoard[row][col] = board[col][row];
            }
        }
        board = newBoard;
    }

    private void moveUp() {
        // Move up by transposing, moving left, and transposing back
        transposeBoard();
        moveLeft();
        transposeBoard();
    }
    private void moveDown() {
        // Move down by transposing, moving right, and transposing back
        transposeBoard();
        moveRight();
        transposeBoard();
    }
    public boolean isGameOver() {
        // Check if there are no valid moves left on the board
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0 ||
                    (row < SIZE - 1 && board[row][col] == board[row + 1][col]) ||
                    (col < SIZE - 1 && board[row][col] == board[row][col + 1])) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TwentyFortyEight game = new TwentyFortyEight();
        while (!game.isGameOver()) {
            game.printBoard();
            System.out.print("Enter move (w/a/s/d): ");
            String move = scanner.nextLine().trim().toLowerCase();
            switch (move) {
                case "w":
                    game.moveUp();
                    break;
                case "a":
                    game.moveLeft();
                    break;
                case "s":
                    game.moveDown();
                    break;
                case "d":
                    game.moveRight();
                    break;
                default:
                    System.out.println("Invalid move!");
            }
            game.addTile();
        }
        game.printBoard();
        System.out.println("Game Over. Your score: " + game.getScore());
        scanner.close();
    }
}