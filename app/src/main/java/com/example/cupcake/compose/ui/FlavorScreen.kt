package com.example.cupcake.compose.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.cupcake.R
import com.example.cupcake.compose.elements.CommonOptionsGroup

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

        CommonOptionsGroup(
            options = flavors,
            chosenOption = chosenFlavor,
            subTotal = subTotal,
            onOptionClick = onOptionClick,
            onCancelButtonCLick = onCancelButtonCLick,
            onNextButtonClick = onNextButtonClick
        )
    }
}