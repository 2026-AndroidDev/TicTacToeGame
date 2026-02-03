package com.kata.tictactoe.domain

import com.kata.tictactoe.domain.model.Board
import com.kata.tictactoe.domain.model.Game
import com.kata.tictactoe.domain.model.GameState
import com.kata.tictactoe.domain.model.Player
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class GameTest {

    @Test
    fun `game starts with empty 3x3 board`() {
        val game = Game()
        assertEquals(Board.DEFAULT_SIZE, game.board.size)
        assertTrue(game.board.isEmpty())
    }

    @Test
    fun `for first player game starts with X`() {
        val game = Game()
        assertEquals(Player.X, game.currentPlayer)
    }

    @Test
    fun `player X can play on an empty cell`() {
        val game = Game()
        val updatedGame = game.play(cellIndex = 4)
        assertEquals(Player.X, updatedGame.board.cells[4])
    }

    @Test
    fun `player switch to O after first move from X`() {
        val game = Game()
        val updatedGame = game.play(cellIndex = 0)
        assertEquals(Player.O, updatedGame.currentPlayer)
    }

    @Test
    fun `player cannot play on already played cell`() {
        val game = Game().play(cellIndex = 0)
        val updatedGame = game.play(cellIndex = 0)
        assertEquals(Player.X, updatedGame.board.cells[0])
    }

    @Test
    fun `player does not change when move is invalid`() {
        val game = Game().play(cellIndex = 0)
        val updatedGame = game.play(cellIndex = 0)
        assertEquals(Player.O, updatedGame.currentPlayer)
    }

    @Test
    fun `player X wins with first row`() {
        val game = Game()
            .play(0) // X
            .play(3) // O
            .play(1) // X
            .play(4) // O
            .play(2) // X

        assertEquals(GameState.Won(Player.X), game.state)
    }

    @Test
    fun `player O wins with Second row`() {
        val game = Game()
            .play(0) // X
            .play(3) // O
            .play(2) // X
            .play(4) // O
            .play(8) // X
            .play(5) // O

        assertEquals(GameState.Won(Player.O), game.state)
    }

    @Test
    fun `player X wins with Third row`() {
        val game = Game()
            .play(6) // X
            .play(3) // O
            .play(7) // X
            .play(4) // O
            .play(8) // X

        assertEquals(GameState.Won(Player.X), game.state)
    }

    @Test
    fun `player O wins with first column`() {
        val game = Game()
            .play(1) // X
            .play(0) // O
            .play(2) // X
            .play(3) // O
            .play(4) // X
            .play(6) // O

        assertEquals(GameState.Won(Player.O), game.state)
    }

    @Test
    fun `player X wins with second column`() {
        val game = Game()
            .play(1) // X
            .play(0) // O
            .play(4) // X
            .play(2) // O
            .play(7) // X

        assertEquals(GameState.Won(Player.X), game.state)
    }

    @Test
    fun `player O wins with third column`() {
        val game = Game()
            .play(0) // X
            .play(2) // O
            .play(1) // X
            .play(5) // O
            .play(3) // X
            .play(8) // O

        assertEquals(GameState.Won(Player.O), game.state)
    }

    @Test
    fun `player X wins with left-to-right diagonal`() {
        val game = Game()
            .play(0) // X
            .play(1) // O
            .play(4) // X
            .play(2) // O
            .play(8) // X

        assertEquals(GameState.Won(Player.X), game.state)
    }

    @Test
    fun `player O wins with right-to-left diagonal`() {
        val game = Game()
            .play(0) // X
            .play(2) // O
            .play(1) // X
            .play(4) // O
            .play(8) // X
            .play(6) // O

        assertEquals(GameState.Won(Player.O), game.state)
    }

    @Test
    fun `game is draw when all cells are filled and there is no winner`() {
        val game = Game()
            .play(0) // X
            .play(1) // O
            .play(2) // X
            .play(4) // O
            .play(3) // X
            .play(5) // O
            .play(7) // X
            .play(6) // O
            .play(8) // X

        assertEquals(GameState.Draw, game.state)
    }
}