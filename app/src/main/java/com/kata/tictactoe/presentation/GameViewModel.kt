package com.kata.tictactoe.presentation

import androidx.lifecycle.ViewModel
import com.kata.tictactoe.domain.model.Game
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GameViewModel : ViewModel() {

    private val _state = MutableStateFlow(GameUiState(game = Game()))
    val state = _state.asStateFlow()

    fun onEvent(event: UiEvent) {
        when (event) {
            is UiEvent.OnCellClicked -> {
                val currentGame = _state.value.game
                val updatedGame = currentGame.play(event.cellIndex)
                _state.value = _state.value.copy(game = updatedGame)
            }

            UiEvent.Restart -> {
                _state.value = GameUiState(game = Game())
            }
        }
    }
}