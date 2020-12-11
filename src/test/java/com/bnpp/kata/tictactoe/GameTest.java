package com.bnpp.kata.tictactoe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    @DisplayName("Should initialize game variables with default values")
    void initializeGame() {
        Game game = new Game();
        String[][] boardBefore = game.getTicTacToe();

        game.initializeGame();
        String[][] boardAfter = game.getTicTacToe();

        assertNull(boardBefore);
        assertTrue(boardAfter != null);
        assertEquals("_", boardAfter[0][0]);
    }

    @Test
    @DisplayName("Should have player1 X as the current player or default player and reset the moves")
    void player1ShouldStartTheGame() {
        Game game = new Game();
        String currentPlayerBefore = game.getCurrentPlayer();
        ArrayList<String> movesBefore = game.getMoves();

        game.initializeGame();

        String currentPlayerAfter = game.getCurrentPlayer();
        ArrayList<String> movesAfter = game.getMoves();

        assertNull(currentPlayerBefore);
        assertNull(movesBefore);
        assertEquals("X", currentPlayerAfter);
        assertEquals(0, movesAfter.size());
    }

    @Test
    @DisplayName("Should validate the input")
    void isValidInput() {
        Game game = new Game();

        assertFalse(game.isValidInput("66"));
        assertFalse(game.isValidInput("ab"));
        assertFalse(game.isValidInput("#@"));

        assertTrue(game.isValidInput("1"));
        assertTrue(game.isValidInput("9"));
    }
}