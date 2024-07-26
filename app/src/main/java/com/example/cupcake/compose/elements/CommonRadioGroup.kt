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
fun CommonRadioGroup(
    options: List<String>,
    chosenOption: String,
    onOptionClick: (option: String) -> Unit
) {
    Column {
        options.forEach { option ->
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                RadioButton(
                    selected = (option == chosenOption),
                    onClick = { onOptionClick(option) },
                    colors = RadioButtonDefaults.colors(colorResource(R.color.purple_400))
                )

                Text(
                    text = option,
                    fontSize = with(
                        LocalDensity.current
                    ) { dimensionResource(id = R.dimen.radio_button_font_size).toSp() },
                    modifier = Modifier.clickable { onOptionClick(option) }
                )
            }
        }
    }
}