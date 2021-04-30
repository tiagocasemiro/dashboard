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
import com.dashboard.view.screen.cover.CoverState
import com.dashboard.view.screen.search.SearchScreen
import com.dashboard.view.screen.cover.CoverViewModel
import com.dashboard.view.screen.search.SearchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.State


//https://www.behance.net/gallery/85077173/Sector-News
//https://github.com/android/compose-samples/tree/master/JetNews
//https://github.com/google/accompanist
//https://sheltered-dawn-75915.herokuapp.com/swagger-ui/index.html?url=/openapi.json
class MainActivity: ComponentActivity() {
    private val coverViewModel: CoverViewModel by viewModel()
    private val searchViewModel: SearchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        coverViewModel.articles()
        setContent {
            MaterialTheme {
                NavigationInCompose()
            }
        }
    }

    @Composable
    fun NavigationInCompose() {
        val navController = rememberNavController()
        val stateArticles: State<CoverState> = coverViewModel.stateArticles.observeAsState(CoverState.Load)

        NavHost(
            navController = navController,
            startDestination = "cover-screen") {
            composable("cover-screen") {
                CoverScreen(navController = navController, stateArticles = stateArticles)
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