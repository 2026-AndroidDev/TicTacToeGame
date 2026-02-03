package com.kata.tictactoe.presentation.components

import androidx.compose.foundation.layout.aspectRatio
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
    val isEnabled = player == null

    OutlinedButton(
        onClick = onClick,
        enabled = isEnabled,
        modifier = modifier.aspectRatio(1f)
    ) {
        Text(text = player?.name.orEmpty())
    }
}