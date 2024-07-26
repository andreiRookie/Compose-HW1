package com.example.cupcake.compose.elements

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.cupcake.R

@Composable
fun CommonButton(
    modifier: Modifier = Modifier,
    onButtonClick: () -> Unit,
    text: String
) {
    Button(
        onClick = { onButtonClick() },
        shape = RoundedCornerShape(4.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.pink_600)),
        modifier = modifier.defaultMinSize(
            dimensionResource(id = R.dimen.order_cupcake_button_width)
        )
    ) {
        Text(
            text = text.uppercase(),
            color = colorResource(id = R.color.white),
            fontSize = with(
                LocalDensity.current
            ) {
                dimensionResource(id = R.dimen.common_button_font_size).toSp()
            }
        )
    }
}