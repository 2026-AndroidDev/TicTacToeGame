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

    @Test
    fun `when user clicks already played cell state does not change`() = runTest {
        val viewModel = GameViewModel()

        viewModel.onEvent(UiEvent.OnCellClicked(cellIndex = 4))
        val stateAfterFirstMove = viewModel.state.value

        viewModel.onEvent(UiEvent.OnCellClicked(cellIndex = 4))
        val stateAfterInvalidMove = viewModel.state.value

        assertEquals(stateAfterFirstMove, stateAfterInvalidMove)
    }

    @Test
    fun `when game is won next moves are not allowed or ignored`() = runTest {
        val viewModel = GameViewModel()

        viewModel.onEvent(UiEvent.OnCellClicked(0)) // X
        viewModel.onEvent(UiEvent.OnCellClicked(3)) // O
        viewModel.onEvent(UiEvent.OnCellClicked(1)) // X
        viewModel.onEvent(UiEvent.OnCellClicked(4)) // O
        viewModel.onEvent(UiEvent.OnCellClicked(2)) // X

        val stateAfterWin = viewModel.state.value

        viewModel.onEvent(UiEvent.OnCellClicked(5))

        val stateAfterExtraMove = viewModel.state.value
        assertEquals(stateAfterWin, stateAfterExtraMove)
    }

    @Test
    fun `when game is draw further moves are ignored`() = runTest {
        val viewModel = GameViewModel()

        // Fill board with no winner (draw pattern)
        viewModel.onEvent(UiEvent.OnCellClicked(0)) // X
        viewModel.onEvent(UiEvent.OnCellClicked(1)) // O
        viewModel.onEvent(UiEvent.OnCellClicked(2)) // X
        viewModel.onEvent(UiEvent.OnCellClicked(4)) // O
        viewModel.onEvent(UiEvent.OnCellClicked(3)) // X
        viewModel.onEvent(UiEvent.OnCellClicked(5)) // O
        viewModel.onEvent(UiEvent.OnCellClicked(7)) // X
        viewModel.onEvent(UiEvent.OnCellClicked(6)) // O
        viewModel.onEvent(UiEvent.OnCellClicked(8)) // X

        val stateAfterDraw = viewModel.state.value

        // try to play after draw (any index)
        viewModel.onEvent(UiEvent.OnCellClicked(0))

        val stateAfterExtraMove = viewModel.state.value
        assertEquals(stateAfterDraw, stateAfterExtraMove)
    }
}
