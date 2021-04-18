package com.dashboard.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dashboard.view.screen.cover.CoverScreen
import com.dashboard.view.screen.search.SearchScreen
import com.dashboard.view.screen.cover.CoverViewModel
import com.dashboard.view.screen.search.SearchViewModel
import org.koin.android.viewmodel.ext.android.viewModel

//https://www.behance.net/gallery/85077173/Sector-News
//https://github.com/android/compose-samples/tree/master/JetNews
//https://github.com/google/accompanist
class MainActivity: ComponentActivity() {
    private val coverViewModel: CoverViewModel by viewModel()
    private val searchViewModel: SearchViewModel by viewModel()

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
                CoverScreen(navController = navController, viewModel = coverViewModel)
            }
            composable("search-screen") {
                SearchScreen(navController = navController, viewModel = searchViewModel)
            }
        }
    }

    @Preview
    @Composable
    fun preview() {
        NavigationInCompose()
    }
}