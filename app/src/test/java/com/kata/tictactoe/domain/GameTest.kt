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
}