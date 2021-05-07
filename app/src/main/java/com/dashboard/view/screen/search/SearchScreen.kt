package com.dashboard.view.screen.search

import androidx.compose.foundation.layout.Column
import com.dashboard.view.components.TopBarWithBack
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.dashboard.R

@Composable
fun SearchScreen(navController: NavController, viewModel: SearchViewModel) {
    Scaffold(
        topBar = {
            TopBarWithBack(R.string.search_screen_title,
                onBack = {
                    navController.navigate("cover-screen") {
                        popUpTo = navController.graph.startDestination
                        launchSingleTop = true
                    }
                }
            )
        }
    ) {
        Column {

        }
    }
}