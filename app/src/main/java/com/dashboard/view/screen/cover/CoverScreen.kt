package com.dashboard.view.screen.cover

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.dashboard.R
import com.dashboard.model.domain.Article
import com.dashboard.model.domain.Source
import com.dashboard.view.components.*

@Composable
fun CoverScreen(navController: NavController, viewModel: CoverViewModel) {
    val stateArticles: MutableState<CoverState> = remember { mutableStateOf(CoverState.Empty) }
    viewModel.article {
        stateArticles.value = it
    }
    Scaffold(
        topBar = {
            TopBarWithSearch(R.string.app_name, onSearch = {
                navController.navigate("search-screen")
            })
        }
    ) {
        Column{
            RowListText(listOf("Política", "Esporte", "Cinema", "Lazer", "Política", "Esporte","Cinema", "Lazer"))
            when(stateArticles.value) {
                is CoverState.Data -> {
                    val state = stateArticles.value as State<CoverState.Data>
                    CoverNews(state.value.articles, listOf())
                }
                is CoverState.Empty -> {
                    CoverEmpty()
                }
                is CoverState.Error -> {
                    PresentDialog()
                }
            }
        }
    }
}

@Composable
fun CoverNews(articles: List<Article>, sources: List<Source>) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(articles) { article ->
            MainCardNews(article)
        }
        item {
            SourcesCard(sources)
        }
    }
}


@Composable
fun CoverEmpty() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "No data")
    }
}

@Preview
@Composable
fun preview() {
    RowListText(listOf("Política", "Esporte","Cinema", "Lazer", "Política", "Esporte","Cinema", "Lazer"))
}

