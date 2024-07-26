package com.example.cupcake.compose.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import com.example.cupcake.R


@Composable
fun FlavorRadioGroup(
    flavors: List<String>,
    chosenFlavor: String,
    onRadioButtonClick: (flavor: String) -> Unit
) {
    Column {
        flavors.forEach { flavor ->
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                RadioButton(
                    selected = (flavor == chosenFlavor),
                    onClick = { onRadioButtonClick(flavor) },
                    colors = RadioButtonDefaults.colors(colorResource(R.color.purple_400))
                )

                Text(
                    text = flavor,
                    fontSize = with(
                        LocalDensity.current
                    ) { dimensionResource(id = R.dimen.radio_button_font_size).toSp() },
                    modifier = Modifier.clickable { onRadioButtonClick(flavor) }
                )
            }
        }
    }
}