package com.example.cupcake.compose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.cupcake.R
import com.example.cupcake.compose.elements.CommonButton

@Composable
fun StartScreen(
    onOrderButtonClick: (count: Int) -> Unit
) {
    MainScreenFrame(title = stringResource(id = R.string.app_name)) {

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.cupcake),
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.image_size))
                    .padding(top = 8.dp)

            )

            Text(
                text = stringResource(id = R.string.order_cupcakes),
                color = colorResource(id = R.color.material_on_background_emphasis_medium),
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            CommonButton(
                modifier = Modifier.padding(top = 8.dp),
                text = stringResource(id = R.string.one_cupcake),
                onButtonClick = { onOrderButtonClick(1) }
            )

            CommonButton(
                modifier = Modifier.padding(top = 8.dp),
                text = stringResource(id = R.string.six_cupcakes),
                onButtonClick = { onOrderButtonClick(6) }
            )

            CommonButton(
                modifier = Modifier.padding(top = 8.dp),
                text = stringResource(id = R.string.twelve_cupcakes),
                onButtonClick = { onOrderButtonClick(12) }
            )
        }
    }
}

