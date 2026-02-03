package com.kata.tictactoe.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kata.tictactoe.domain.model.GameState
import com.kata.tictactoe.presentation.GameViewModel
import com.kata.tictactoe.presentation.UiEvent
import com.kata.tictactoe.presentation.components.BoardGrid


@Composable
fun BoardScreen(
    modifier: Modifier = Modifier,
    viewModel: GameViewModel = viewModel()
) {
    val uiState = viewModel.state.collectAsStateWithLifecycle().value

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = when (val gameState = uiState.game.state) {
                is GameState.InProgress -> "Turn: ${uiState.game.currentPlayer.name}"
                is GameState.Won -> "Winner: ${gameState.player.name}"
                is GameState.Draw -> "It's a draw"
            },
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        BoardGrid(
            board = uiState.game.board,
            onCellClick = { index -> viewModel.onEvent(UiEvent.OnCellClicked(index)) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { viewModel.onEvent(UiEvent.Restart) }) {
            Text(text = "Restart")
        }
    }
}