package com.example.cupcake.compose.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.cupcake.R
import com.example.cupcake.compose.elements.CommonOptionsGroup

@Composable
fun PickupScreen(
    dates: List<String>,
    chosenDate: String,
    subTotal: String,
    onNavigateBackClick: () -> Unit,
    onOptionClick: (option: String) -> Unit,
    onCancelButtonCLick: () -> Unit,
    onNextButtonClick: () -> Unit
) {

    MainScreenFrame(
        title = stringResource(id = R.string.pickup_date),
        onNavigateBackClick = onNavigateBackClick
        ) {

        CommonOptionsGroup(
            options = dates,
            chosenOption = chosenDate,
            subTotal = subTotal,
            onOptionClick = onOptionClick,
            onCancelButtonCLick = onCancelButtonCLick,
            onNextButtonClick = onNextButtonClick
        )
    }
}