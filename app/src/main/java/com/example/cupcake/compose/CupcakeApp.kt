package com.example.cupcake.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cupcake.R
import com.example.cupcake.compose.ui.FlavorScreen
import com.example.cupcake.compose.ui.StartScreen
import com.example.cupcake.model.OrderViewModel

@Composable
fun CupcakeApp(sharedViewModel: OrderViewModel) {

    val navHostController = rememberNavController()
    val context = LocalContext.current

    NavHost(navController = navHostController, startDestination = Routes.StartScreenRoute.name) {
        composable(route = Routes.StartScreenRoute.name) {
            StartScreen { quantity ->
                sharedViewModel.setQuantity(quantity)

                if (sharedViewModel.hasNoFlavorSet()) {
                    sharedViewModel.setFlavor(context.getString(R.string.vanilla))
                }

                navHostController.navigate(Routes.FlavorScreenRoute.name)
            }
        }
        composable(route = Routes.FlavorScreenRoute.name) {
            FlavorScreen(
                flavors = listOf(
                    context.getString(R.string.vanilla),
                    context.getString(R.string.chocolate),
                    context.getString(R.string.red_velvet),
                    context.getString(R.string.salted_caramel),
                    context.getString(R.string.coffee)
                ),
                chosenFlavor = sharedViewModel.flavor
                    .observeAsState(initial = context.getString(R.string.vanilla)).value,

                subTotal = sharedViewModel.price.observeAsState().value.orEmpty(),

                onNavigateBackClick = {
                    navHostController.popBackStack()
                },
                onOptionClick = { flavor ->
                    sharedViewModel.setFlavor(flavor)
                },

                onCancelButtonCLick = {
                    sharedViewModel.resetOrder()
                    navHostController.popBackStack()
                },

                onNextButtonClick = {
                    navHostController.navigate(Routes.PickupScreenRoute.name)
                }
            )
        }
    }
}

enum class Routes(name: String) {
    StartScreenRoute("startScreen"),
    FlavorScreenRoute("flavorScreen"),
    PickupScreenRoute("pickupScreen"),
}
