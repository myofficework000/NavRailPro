package com.venkata.org

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavHostApp(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screens.Home.route,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        composable(Screens.Home.route) {
            DisplayText("Home Page")
        }
        composable(Screens.Movies.route) {
            DisplayText("Movies Page")
        }
        composable(Screens.Shows.route) {
            DisplayText("Shows Page")
        }
        composable(Screens.Library.route) {
            DisplayText("Library Page")
        }
    }
}