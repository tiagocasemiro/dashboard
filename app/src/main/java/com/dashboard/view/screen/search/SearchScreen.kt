package com.dashboard.view.screen.search

import androidx.compose.foundation.layout.Column
import com.dashboard.view.components.TopBarWithBack
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.dashboard.R
import com.dashboard.view.components.DashboardTextField
import com.dashboard.view.screen.cover.CoverState

@Composable
fun SearchScreen(navController: NavController, viewModel: SearchViewModel) {
    val stateArticles: State<SearchState> = viewModel.stateArticles.observeAsState(SearchState.Empty)

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
            DashboardTextField()


        }
    }
}