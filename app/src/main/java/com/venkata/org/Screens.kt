package com.venkata.org

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(val title: String, val icon: ImageVector, val route: String) {


    data object Home : Screens("Home", Icons.Default.Home, "home")
    data object Movies : Screens("Movies", Icons.Default.MoreVert, "movies")
    data object Shows : Screens("Shows", Icons.Default.ShoppingCart, "shows")
    data object Library : Screens("Library", Icons.Default.Email, "library")

}
