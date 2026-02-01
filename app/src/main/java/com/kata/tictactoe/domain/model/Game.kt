package com.kata.tictactoe.domain.model

data class Game(
    val board: Board = Board(),
    val currentPlayer: Player = Player.X
)