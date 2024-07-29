package com.example.cupcake.compose.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import com.example.cupcake.R

@Composable
fun SummaryElement(
    label: String,
    value: String
) {
    Column {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = label.uppercase(),
            fontSize = with(
                LocalDensity.current
            ) {
                dimensionResource(id = R.dimen.summary_element_label_font_size).toSp()
            }
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = dimensionResource(id = R.dimen.order_summary_margin)),
            text = value,
            fontSize = with(
                LocalDensity.current
            ) {
                dimensionResource(id = R.dimen.summary_element_label_font_size).toSp()
            },
            fontWeight = FontWeight.Bold
        )
    }
}