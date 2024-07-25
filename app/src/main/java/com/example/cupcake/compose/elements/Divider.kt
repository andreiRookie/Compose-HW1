package com.example.cupcake.compose.elements

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun Divider(
    color: Color = Color.Black,
    thickness: Dp = 1.dp
) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawLine(
            start = Offset(x = 0f, y = thickness.toPx()),
            end = Offset(x = size.width, y = thickness.toPx()),
            color = color
        )
    }
}