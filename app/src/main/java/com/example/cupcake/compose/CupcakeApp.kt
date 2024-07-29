package com.example.cupcake.compose

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cupcake.R
import com.example.cupcake.compose.ui.FlavorScreen
import com.example.cupcake.compose.ui.PickupScreen
import com.example.cupcake.compose.ui.StartScreen
import com.example.cupcake.compose.ui.SummaryScreen
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
        composable(route = Routes.PickupScreenRoute.name) {
            PickupScreen(
                dates = sharedViewModel.dateOptions,
                chosenDate = sharedViewModel.date
                    .observeAsState(initial = sharedViewModel.dateOptions[0]).value,

                subTotal = sharedViewModel.price.observeAsState().value.orEmpty(),

                onNavigateBackClick = {
                    navHostController.popBackStack()
                },
                onOptionClick = { date ->
                    sharedViewModel.setDate(date)
                },
                onCancelButtonCLick = {
                    sharedViewModel.resetOrder()
                    navHostController.popBackStack(
                        route = Routes.StartScreenRoute.name,
                        inclusive = false
                    )
                },
                onNextButtonClick = {
                    navHostController.navigate(Routes.SummaryScreenRoute.name)
                }
            )
        }
        composable(route = Routes.SummaryScreenRoute.name) {

            val quantity = sharedViewModel.quantity.observeAsState(initial = 0).value
            val flavor = sharedViewModel.flavor.observeAsState().value.orEmpty()
            val date = sharedViewModel.date.observeAsState().value.orEmpty()
            val totalPrice = sharedViewModel.price.observeAsState().value.orEmpty()

            SummaryScreen(
                quantity = quantity.toString(),
                flavor = flavor,
                date = date,
                totalPrice = totalPrice,

                onNavigateBackClick = {
                    navHostController.popBackStack()
                },

                onSendOrderClick = {
                    val orderSummary = context.getString(
                        R.string.order_details,
                        context.resources.getQuantityString(R.plurals.cupcakes, quantity, quantity),
                        flavor,
                        date,
                        totalPrice
                    )

                    val intent = Intent(Intent.ACTION_SEND)
                        .setType("text/plain")
                        .putExtra(
                            Intent.EXTRA_SUBJECT,
                            context.getString(R.string.new_cupcake_order)
                        )
                        .putExtra(Intent.EXTRA_TEXT, orderSummary)

                    if (context.packageManager?.resolveActivity(intent, 0) != null) {
                        context.startActivity(intent)
                    }
                },

                onCancelButtonCLick = {
                    sharedViewModel.resetOrder()
                    navHostController.popBackStack(
                        route = Routes.StartScreenRoute.name,
                        inclusive = false
                    )
                }
            )
        }
    }
}

enum class Routes(name: String) {
    StartScreenRoute("startScreen"),
    FlavorScreenRoute("flavorScreen"),
    PickupScreenRoute("pickupScreen"),
    SummaryScreenRoute("summaryScreen")
}
