package com.kata.tictactoe.presentation

import com.kata.tictactoe.domain.model.Game
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class GameViewModelTest {

    @Test
    fun `when user clicks a cell game updates board`() = runTest {
        val viewModel = GameViewModel()

        viewModel.onEvent(UiEvent.OnCellClicked(cellIndex = 4))

        val game = viewModel.state.value.game
        assertEquals(Game().play(4), game)
    }

    @Test
    fun `when user clicks restart game resets to initial state`() = runTest {
        val viewModel = GameViewModel()

        viewModel.onEvent(UiEvent.OnCellClicked(cellIndex = 4))
        viewModel.onEvent(UiEvent.Restart)

        val game = viewModel.state.value.game
        assertEquals(Game(), game)
    }
}
