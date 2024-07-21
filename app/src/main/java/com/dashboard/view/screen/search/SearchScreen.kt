package com.dashboard.view.screen.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.dashboard.R
import com.dashboard.view.components.*
import com.dashboard.view.defaultPaddingCard
import com.dashboard.view.defaultSpaceBetweenCard
import com.dashboard.view.screen.cover.CoverEmpty
import com.dashboard.view.screen.cover.CoverLoad

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchScreen(navController: NavController, viewModel: SearchViewModel) {
    val stateArticles: State<SearchState> = viewModel.stateArticles.observeAsState(SearchState.Empty)

    Scaffold(
        topBar = {
            TopBarWithBack(R.string.search_screen_title,
                onBack = {
                    navController.navigate("cover-screen") {
                        popUpTo = navController.graph.startDestinationId
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
                    val articles = (stateArticles.value as SearchState.Data).articles
                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = defaultPaddingCard, vertical = defaultPaddingCard),
                        verticalArrangement = Arrangement.spacedBy(defaultSpaceBetweenCard),
                    ) {
                        itemsIndexed(articles) { index, article ->
                            SecondaryCardNews(article)
                            if (index < articles.size - 1)
                                DashboardDivider()
                        }
                    }
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