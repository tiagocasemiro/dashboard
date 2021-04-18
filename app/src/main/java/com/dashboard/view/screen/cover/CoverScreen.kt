package com.dashboard.view.screen.cover

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.dashboard.R
import com.dashboard.model.domain.Article
import com.dashboard.model.domain.Source
import com.dashboard.view.components.MainCardNews
import com.dashboard.view.components.RowListText
import com.dashboard.view.components.SourcesCard
import com.dashboard.view.components.TopBarWithSearch

@Composable
fun CoverScreen(navController: NavController, viewModel: CoverViewModel) {
    Scaffold(
        topBar = {
            TopBarWithSearch(R.string.app_name, onSearch = {
                navController.navigate("search-screen")
            })
        }
    ) {
       Column {
            RowListText(listOf("Política", "Esporte", "Cinema", "Lazer", "Política", "Esporte","Cinema", "Lazer"))
            CoverNews(listOf(), listOf())
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



@Preview
@Composable
fun preview() {
    RowListText(listOf("Política", "Esporte","Cinema", "Lazer", "Política", "Esporte","Cinema", "Lazer"))
}

