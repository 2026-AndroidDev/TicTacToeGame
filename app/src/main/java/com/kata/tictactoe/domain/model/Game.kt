package com.kata.tictactoe.domain.model

data class Game(
    val board: Board = Board(),
    val currentPlayer: Player = Player.X
) {
    fun play(cellIndex: Int): Game {
        val updatedCells = board.cells.toMutableList()
        updatedCells[cellIndex] = currentPlayer

        return copy(
            board = board.copy(cells = updatedCells),
            currentPlayer = currentPlayer.next()
        )
    }
}