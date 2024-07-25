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
//            TopAppBar(
//                backgroundColor = colorResource(R.color.pink_600),
//                title = {
//                    Text(
//                        modifier = if (onNavigateBackClick == null) {
//                            Modifier
//                                .offset(x = dimensionResource(id = R.dimen.screen_title_start_offset_56))
//                        } else {
//                            Modifier
//                                .offset(x = dimensionResource(id = R.dimen.screen_title_start_offset_16))
//                        },
//                        text = title,
//                        fontSize = with(
//                            LocalDensity.current) {
//                            dimensionResource(id = R.dimen.screen_title_font_size).toSp()
//                        },
//                        color = MaterialTheme.colors.onPrimary
//                    )
//                },
//                navigationIcon = {
//                    onNavigateBackClick?.let { onNavigateBackClick ->
//                        IconButton(onClick = onNavigateBackClick) {
//                            Icon(
//                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                                contentDescription = null,
//                                tint = MaterialTheme.colors.onPrimary
//                            )
//                        }
//                    }
//                },
//            )
        }
    ) { paddings ->
        Box(modifier = Modifier.fillMaxSize().padding(paddings)) {
            content()
        }
    }
}