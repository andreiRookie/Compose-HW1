package com.example.cupcake.compose.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.cupcake.R

@Composable
fun SummaryScreen(

) {
    MainScreenFrame(
        title = stringResource(id = R.string.order_summary)
    ) {
    }
}