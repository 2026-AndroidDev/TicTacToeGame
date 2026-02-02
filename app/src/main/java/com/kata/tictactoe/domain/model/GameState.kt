package com.kata.tictactoe.domain.model

sealed class GameState {
    data object InProgress : GameState()
    data class Won(val player: Player) : GameState()
    data object Draw : GameState()
}
