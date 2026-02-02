package com.kata.tictactoe.domain.model

data class Game(
    val board: Board = Board(),
    val currentPlayer: Player = Player.X,
    val state: GameState = GameState.InProgress
) {
    fun play(cellIndex: Int): Game {

        if (state != GameState.InProgress) return this

        if (board.cells[cellIndex] != null) return this

        val updatedCells = board.cells.toMutableList()
        updatedCells[cellIndex] = currentPlayer

        val updatedBoard = board.copy(cells = updatedCells)

        val winner = findRowWinner(updatedBoard) ?: findColumnWinner(updatedBoard)
        val updatedStatus = if (winner != null) GameState.Won(winner) else GameState.InProgress

        return copy(
            board = board.copy(cells = updatedCells),
            currentPlayer = if (updatedStatus is GameState.InProgress) currentPlayer.next() else currentPlayer,
            state = updatedStatus
        )
    }

    private fun findRowWinner(board: Board): Player? {
        val size = board.size

        for (row in 0 until size) {
            val startIndex = row * size
            val first = board.cells[startIndex] ?: continue

            val second = board.cells[startIndex + 1]
            val third = board.cells[startIndex + 2]

            if (first == second && second == third) {
                return first
            }
        }

        return null
    }

    private fun findColumnWinner(board: Board): Player? {
        val size = board.size

        for (column in 0 until size) {
            val first = board.cells[column] ?: continue

            val second = board.cells[column + size]
            val third = board.cells[column + 2 * size]

            if (first == second && second == third) {
                return first
            }
        }

        return null
    }
}