package com.kata.tictactoe.presentation

import com.kata.tictactoe.domain.model.Game


data class GameUiState(
    val game: Game = Game()
)