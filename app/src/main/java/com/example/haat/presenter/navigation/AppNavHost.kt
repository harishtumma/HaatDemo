package com.example.haat.presenter.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.haat.presenter.DetailScreen
import com.example.haat.presenter.HomeScreen

// ui/navigation/AppNavHost.kt
@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Home.route
    ) {
        // Home screen
        composable(NavRoutes.Home.route) {
            HomeScreen(){
                navController.navigate(NavRoutes.Details.route)
            }
        }

        // Details screen
        composable(NavRoutes.Details.route) {
            DetailScreen()
        }
    }
}
