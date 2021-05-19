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
import com.dashboard.view.components.ErrorDialog
import com.dashboard.view.components.RowListText
import com.dashboard.view.screen.cover.CoverEmpty
import com.dashboard.view.screen.cover.CoverLoad
import com.dashboard.view.screen.cover.CoverNews
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
            when(stateArticles.value) {
                is SearchState.Data -> {
                    RowListText((stateArticles.value as CoverState.Data).categories.map { it.namePtBr } )
                    CoverNews(stateArticles.value as CoverState.Data)
                }
                is SearchState.Empty -> {
                    CoverEmpty()
                }
                is SearchState.Error -> {
                    ErrorDialog("Ops, tivemos um problema","Erro ao tentar consultar Artigos. Tente novamente mais tarde.")
                }
                is SearchState.Load -> {
                    CoverLoad()
                }
            }
        }
    }
}