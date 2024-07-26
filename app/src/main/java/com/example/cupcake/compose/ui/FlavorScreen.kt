package com.example.cupcake.compose.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.cupcake.R
import com.example.cupcake.compose.elements.CommonButton
import com.example.cupcake.compose.elements.CommonRadioGroup
import com.example.cupcake.compose.elements.Divider

@Composable
fun FlavorScreen(
    flavors: List<String>,
    chosenFlavor: String,
    subTotal: String,
    onNavigateBackClick: () -> Unit,
    onOptionClick: (option: String) -> Unit,
    onCancelButtonCLick: () -> Unit,
    onNextButtonClick: () -> Unit
) {

    MainScreenFrame(
        title = stringResource(id = R.string.choose_flavor),
        onNavigateBackClick = onNavigateBackClick
    ) {

        Column(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.side_margin))
                .fillMaxSize()
        ) {

            CommonRadioGroup(
                options = flavors,
                chosenOption = chosenFlavor
            ) { flavor ->
                onOptionClick(flavor)
            }

            Divider()

            Text(
                text = stringResource(id = R.string.subtotal_price, subTotal),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.side_margin)),
                fontSize = with(
                    LocalDensity.current
                ) {
                    dimensionResource(id = R.dimen.subtotal_font_size).toSp()
                },
                textAlign = TextAlign.End
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.side_margin)),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.side_margin))
            ) {

                Button(
                    modifier = Modifier.weight(1f),
                    onClick = { onCancelButtonCLick() },
                    shape = RoundedCornerShape(4.dp),
                    border = BorderStroke(width = 0.5.dp, color = Color.LightGray),
                    elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.white))

                ) {
                    Text(
                        text = stringResource(id = R.string.cancel).uppercase(),
                        color = colorResource(id = R.color.pink_600),
                        fontSize = with(
                            LocalDensity.current
                        ) {
                            dimensionResource(id = R.dimen.common_button_font_size).toSp()
                        }
                    )
                }

                CommonButton(modifier = Modifier.weight(1f),
                    onButtonClick = { onNextButtonClick() },
                    text = stringResource(id = R.string.next)
                )
            }
        }
    }
}