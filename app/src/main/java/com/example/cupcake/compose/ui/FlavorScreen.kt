package com.example.cupcake.compose.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cupcake.R
import com.example.cupcake.compose.elements.Divider

@Composable
fun FlavorScreen(
    flavors: List<String>,
    chosenFlavor: String,
    subTotal: String,
    onNavigateBackClick: () -> Unit,
    onRadioButtonClick: (flavor: String) -> Unit,
    onCancelButtonCLick: () -> Unit,
    onNextButtonClick: () -> Unit
) {

    MainScreenFrame(
        title = stringResource(id = R.string.choose_flavor),
        onNavigateBackClick = onNavigateBackClick
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
        ) {
            flavors.forEach { flavor ->
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    RadioButton(selected = (flavor == chosenFlavor),
                        onClick = { onRadioButtonClick(flavor) })

                    Text(
                        text = flavor,
                        modifier = Modifier.clickable { onRadioButtonClick(flavor) }
                    )
                }

            }

            Divider()
        }
    }
}