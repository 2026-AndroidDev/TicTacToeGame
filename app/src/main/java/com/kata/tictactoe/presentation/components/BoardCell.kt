package com.kata.tictactoe.presentation.components

import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kata.tictactoe.domain.model.Player

@Composable
fun BoardCell(
    player: Player?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = player?.name ?: "")
    }
}
