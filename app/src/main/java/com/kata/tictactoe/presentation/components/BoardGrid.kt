package com.kata.tictactoe.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kata.tictactoe.domain.model.Board

@Composable
fun BoardGrid(
    board: Board,
    onCellClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val boardSize = board.size

    Column(modifier = modifier.fillMaxWidth()) {
        for (rowIndex in 0 until boardSize) {
            Row(modifier = Modifier.fillMaxWidth()) {
                for (columnIndex in 0 until boardSize) {
                    val cellIndex = rowIndex * boardSize + columnIndex
                    val player = board.cells[cellIndex]

                    BoardCell(
                        player = player,
                        onClick = { onCellClicked(cellIndex) },
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .padding(4.dp)
                    )
                }
            }
        }
    }
}