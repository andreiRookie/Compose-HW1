package com.example.cupcake.compose.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.cupcake.compose.elements.TopBar

@Composable
fun MainScreenFrame(
    title: String,
    onNavigateBackClick: (() -> Unit)? = null,
    content: @Composable (() -> Unit)
) {
    Scaffold(
        topBar = {
            TopBar(title = title, onNavigateBackClick)
        }
    ) { paddings ->
        Box(modifier = Modifier.fillMaxSize().padding(paddings)) {
            content()
        }
    }
}