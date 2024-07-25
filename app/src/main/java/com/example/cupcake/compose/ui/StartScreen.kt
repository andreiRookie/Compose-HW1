package com.example.cupcake.compose.ui

import android.annotation.SuppressLint
import androidx.appcompat.widget.AppCompatButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.movableContentOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cupcake.R
import com.example.cupcake.compose.elements.OrderButton
import com.example.cupcake.model.OrderViewModel

@Composable
fun StartScreen(
    onOrderButtonClick: (count: Int) -> Unit
) {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
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

        Button(
            onClick = { onOrderButtonClick(1) },
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.pink_600)),
            modifier = Modifier
                .padding(top = 8.dp)
                .defaultMinSize(
                    dimensionResource(id = R.dimen.order_cupcake_button_width)

                )
        ) {
            Text(
                text = stringResource(id = R.string.one_cupcake),
                color = colorResource(id = R.color.white)
                )
        }

        Button(
            onClick = { onOrderButtonClick(6) },
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.pink_600)),
            modifier = Modifier
                .padding(top = 8.dp)
                .defaultMinSize(
                    dimensionResource(id = R.dimen.order_cupcake_button_width)

                )
        ) {
            Text(
                text = stringResource(id = R.string.six_cupcakes),
                color = colorResource(id = R.color.white)
            )
        }

        Button(
            onClick = { onOrderButtonClick(12) },
            shape = RoundedCornerShape(4.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(R.color.pink_600)),
            modifier = Modifier
                .padding(top = 8.dp)
                .defaultMinSize(
                    dimensionResource(id = R.dimen.order_cupcake_button_width)

                )
        ) {
            Text(
                text = stringResource(id = R.string.twelve_cupcakes),
                color = colorResource(id = R.color.white)
            )
        }
    }
}

