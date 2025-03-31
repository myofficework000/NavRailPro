package com.venkata.org

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController


@Composable
fun NavigationRailDrawer() {

    val navController = rememberNavController()
    var selectedItem = remember { mutableStateOf<Screens>(Screens.Home) }
    var isExpanded = remember { mutableStateOf(false) }


    val items = listOf(
        Screens.Home,
        Screens.Movies,
        Screens.Shows,
        Screens.Library
    )

    Row(modifier = Modifier.fillMaxSize()) {
        NavigationRail(
            containerColor = Color.Black,
            contentColor = Color.White,
        ) {
            items.forEach { item ->
                NavigationRailItem(
                    selected = selectedItem.value == item,
                    onClick = {
                        isExpanded.value = if (selectedItem.value == item) !isExpanded.value else true
                        selectedItem.value = item
                        navController.navigate(item.route) {
                            launchSingleTop = true
                        }
                    },
                    icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                    label = {
                        if (isExpanded.value) {
                                Text(item.title)

                        }
                            },
                    alwaysShowLabel = isExpanded.value,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
        }

        Box(
            modifier = Modifier
                .background(Color.Gray)
                .fillMaxSize()
        ) {
            NavHostApp(navController = navController)
        }
    }
}



@Composable
fun DisplayText(text: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}