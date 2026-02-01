package com.kata.tictactoe.domain.model

data class Board(
    val size: Int = DEFAULT_SIZE,
    val cells: List<Player?> = List(size * size) { null }
) {
    companion object {
        const val DEFAULT_SIZE = 3
    }

    fun isEmpty(): Boolean = cells.all { it == null }
}