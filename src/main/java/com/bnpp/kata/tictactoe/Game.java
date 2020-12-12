package com.bnpp.kata.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;

import static com.bnpp.kata.tictactoe.Constants.*;

public class Game {
    private String[][] ticTacToe;
    private String currentPlayer;
    private String winner;
    private ArrayList<String> moves;

    void initializeGame() {
        // Initializing the board with empty or default value.
        ticTacToe = new String[TOTALROWS][TOTALCOLS];
        for (int row = 0; row < TOTALROWS; row++) {
            for (int col = 0; col < TOTALCOLS; col++) {
                ticTacToe[row][col] = BLANKPOS;
            }
        }

        // default player is 'X' as per the rule.
        currentPlayer = PLAYER1;

        winner = null;

        // moves for a fresh start
        moves = new ArrayList();
    }

    void run() {
        // show default empty board.
        showBoard();
    }

    boolean isValidInput(String input) {
        return Arrays.stream(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"}).anyMatch(x -> x.equals(input));
    }

    void switchPlayer() {
        setCurrentPlayer("X".equals(currentPlayer) ? "O" : "X");
    }

    void placeAtBoard(String inputPosition) {
        moves.add(inputPosition);
        switch (inputPosition) {
            case "1":
                ticTacToe[0][0] = currentPlayer;
                break;
            case "2":
                ticTacToe[0][1] = currentPlayer;
                break;
            case "3":
                ticTacToe[0][2] = currentPlayer;
                break;
            case "4":
                ticTacToe[1][0] = currentPlayer;
                break;
            case "5":
                ticTacToe[1][1] = currentPlayer;
                break;
            case "6":
                ticTacToe[1][2] = currentPlayer;
                break;
            case "7":
                ticTacToe[2][0] = currentPlayer;
                break;
            case "8":
                ticTacToe[2][1] = currentPlayer;
                break;
            case "9":
                ticTacToe[2][2] = currentPlayer;
                break;
            default: moves.remove(inputPosition);
        }
    }

    void checkWinner() {
        if (ticTacToe[0][0].equals(ticTacToe[0][1]) && ticTacToe[0][0].equals(ticTacToe[0][2])) {
            winner = ticTacToe[0][0];
        } else if (ticTacToe[0][2].equals(ticTacToe[1][2]) && ticTacToe[0][2].equals(ticTacToe[2][2])) {
            winner = ticTacToe[0][2];
        } else if (ticTacToe[2][0].equals(ticTacToe[2][1]) && ticTacToe[2][0].equals(ticTacToe[2][2])) {
            winner = ticTacToe[2][0];
        } else if (ticTacToe[2][0].equals(ticTacToe[1][0]) && ticTacToe[2][0].equals(ticTacToe[0][0])) {
            winner = ticTacToe[2][0];
        } else if (ticTacToe[2][0].equals(ticTacToe[1][1]) && ticTacToe[2][0].equals(ticTacToe[0][2])) {
            winner = ticTacToe[2][0];
        } else if (ticTacToe[0][0].equals(ticTacToe[1][1]) && ticTacToe[0][0].equals(ticTacToe[2][2])) {
            winner = ticTacToe[0][0];
        } else if (ticTacToe[0][1].equals(ticTacToe[1][1]) && ticTacToe[0][1].equals(ticTacToe[2][1])) {
            winner = ticTacToe[0][1];
        } else if (ticTacToe[1][0].equals(ticTacToe[1][1]) && ticTacToe[1][0].equals(ticTacToe[1][2])) {
            winner = ticTacToe[1][0];
        }
        if (winner == "_")
            winner = null;
    }

    void showBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(ticTacToe[row][col] + (col != 2 ? " | " : ""));
            }
            System.out.println();
        }
    }



    public String[][] getTicTacToe() {
        return ticTacToe;
    }

    public void setTicTacToe(String[][] ticTacToe) {
        this.ticTacToe = ticTacToe;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public ArrayList<String> getMoves() {
        return moves;
    }

    public void setMoves(ArrayList<String> moves) {
        this.moves = moves;
    }
}
