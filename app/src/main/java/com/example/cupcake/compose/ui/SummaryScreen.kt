package com.example.cupcake.compose.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.cupcake.R
import com.example.cupcake.compose.elements.CommonButton
import com.example.cupcake.compose.elements.Divider
import com.example.cupcake.compose.elements.SummaryElement

@Composable
fun SummaryScreen(
    quantity: String,
    flavor: String,
    date: String,
    totalPrice: String,
    onNavigateBackClick: () -> Unit,
    onSendOrderClick: () -> Unit,
    onCancelButtonCLick: () -> Unit
) {
    MainScreenFrame(
        title = stringResource(id = R.string.order_summary),
        onNavigateBackClick = onNavigateBackClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.side_margin))
                .verticalScroll(rememberScrollState())
        ) {

            SummaryElement(
                label = stringResource(id = R.string.quantity),
                value = quantity
            )

            Divider(Modifier.padding(
                top = dimensionResource(id = R.dimen.side_margin),
                bottom = dimensionResource(id = R.dimen.side_margin))
            )

            SummaryElement(
                label = stringResource(id = R.string.flavor),
                value = flavor
            )

            Divider(Modifier.padding(
                top = dimensionResource(id = R.dimen.side_margin),
                bottom = dimensionResource(id = R.dimen.side_margin))
            )

            SummaryElement(
                label = stringResource(id = R.string.pickup_date),
                value = date
            )

            Divider(Modifier.padding(
                top = dimensionResource(id = R.dimen.side_margin),
                bottom = dimensionResource(id = R.dimen.margin_between_elements))
            )

            Text(
                text = stringResource(id = R.string.total_price, totalPrice).uppercase(),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.side_margin)),
                fontSize = with(
                    LocalDensity.current
                ) {
                    dimensionResource(id = R.dimen.total_price_font_size).toSp()
                },
                textAlign = TextAlign.End
            )


            CommonButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(R.dimen.side_margin)),
                onButtonClick = { onSendOrderClick() },
                text = stringResource(id = R.string.send)
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(R.dimen.margin_between_elements)),
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
        }
    }
}