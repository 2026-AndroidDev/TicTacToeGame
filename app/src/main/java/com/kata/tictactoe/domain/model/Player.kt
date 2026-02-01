package com.kata.tictactoe.domain.model

enum class Player {
    X,
    O;

    fun next(): Player = if (this == X) O else X
}