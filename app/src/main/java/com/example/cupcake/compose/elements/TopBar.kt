package com.example.cupcake.compose.elements

import androidx.compose.foundation.layout.offset
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.example.cupcake.R


@Composable
fun TopBar(
    title: String,
    onNavigateBackClick: (() -> Unit)? = null
) {
    TopAppBar(
        backgroundColor = colorResource(R.color.pink_600),
        title = {
            Text(
                modifier = if (onNavigateBackClick == null) {
                    Modifier
                        .offset(x = dimensionResource(id = R.dimen.screen_title_start_offset_56))
                } else {
                    Modifier
                        .offset(x = dimensionResource(id = R.dimen.screen_title_start_offset_16))
                },
                text = title,
                fontSize = with(
                    LocalDensity.current
                ) {
                    dimensionResource(id = R.dimen.screen_title_font_size).toSp()
                },
                color = MaterialTheme.colors.onPrimary
            )
        },
        navigationIcon = {
            onNavigateBackClick?.let { onNavigateBackClick ->
                IconButton(onClick = onNavigateBackClick) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onPrimary
                    )
                }
            }
        },
    )
}