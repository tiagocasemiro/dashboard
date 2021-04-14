package com.dashboard.view.screen

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.dashboard.R

@Composable
fun SearchScreen(navController: NavController) {

        Scaffold(
            topBar = {
                TopBar(R.string.search_screen_title)
            }
        ) {
            Button(onClick = {
                navController.navigate("cover-screen") {
                    popUpTo = navController.graph.startDestination
                    launchSingleTop = true
                }
            }) {
                Text(text = "Voltar")
            }
        }

}