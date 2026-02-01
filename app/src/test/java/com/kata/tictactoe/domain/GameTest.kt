package com.kata.tictactoe.domain

import com.kata.tictactoe.domain.model.Board
import com.kata.tictactoe.domain.model.Game
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
}