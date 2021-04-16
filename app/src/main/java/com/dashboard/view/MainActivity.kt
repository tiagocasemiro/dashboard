package com.dashboard.view

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.Coil
import coil.util.CoilUtils
import com.dashboard.view.screen.CoverScreen
import com.dashboard.view.screen.SearchScreen

//https://www.behance.net/gallery/85077173/Sector-News
//https://github.com/android/compose-samples/tree/master/JetNews
//https://github.com/google/accompanist
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                NavigationInCompose()
            }
        }
    }

    @Composable
    fun NavigationInCompose() {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = "cover-screen") {
            composable("cover-screen") {
                CoverScreen(navController = navController)
            }
            composable("search-screen") {
                SearchScreen(navController = navController)
            }
        }
    }

    @Preview
    @Composable
    fun preview() {
        NavigationInCompose()
    }
}