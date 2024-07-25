package com.example.cupcake.compose

import androidx.compose.runtime.Composable
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
            FlavorScreen(navHostController = navHostController)
        }
    }
}

enum class Routes(name: String) {
    StartScreenRoute("startScreen"),
    FlavorScreenRoute("flavorScreen")
}
