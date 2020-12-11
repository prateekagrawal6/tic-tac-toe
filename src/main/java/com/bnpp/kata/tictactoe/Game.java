package com.bnpp.kata.tictactoe;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static com.bnpp.kata.tictactoe.Constants.*;

@Component
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
