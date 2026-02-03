package com.kata.tictactoe.presentation

sealed class UiEvent {
    data class OnCellClicked(val cellIndex: Int) : UiEvent()
    data object Restart : UiEvent()
}