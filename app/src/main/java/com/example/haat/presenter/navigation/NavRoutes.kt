package com.example.haat.presenter.navigation

sealed class NavRoutes(val route: String) {
    object Home : NavRoutes("home")
    object Details : NavRoutes("details")
}