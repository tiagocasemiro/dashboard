package com.dashboard.view.screen.cover

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.dashboard.R
import com.dashboard.view.components.*
import com.dashboard.view.defaultPaddingCard
import com.dashboard.view.defaultSpaceBetweenCard

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CoverScreen(navController: NavController, stateArticles: State<CoverState>) {
    Scaffold(
        topBar = {
            TopBarWithSearch(R.string.app_name, onSearch = {
                navController.navigate("search-screen")
            })
        }
    ) {
        Column{
            when(stateArticles.value) {
                is CoverState.Data -> {
                    RowListText((stateArticles.value as CoverState.Data).categories.map { it.namePtBr } )
                    CoverNews(stateArticles.value as CoverState.Data)
                }
                is CoverState.Empty -> {
                    CoverEmpty()
                }
                is CoverState.Error -> {
                    ErrorDialog("Ops, tivemos um problema","Erro ao tentar consultar Artigos. Tente novamente mais tarde.")
                }
                is CoverState.Load -> {
                    CoverLoad()
                }
            }
        }
    }
}

@Composable
fun CoverNews(articleState: CoverState.Data) {
    val header = remember {
        articleState.articles.first()
    }
    val articles = remember {
        articleState.articles.toMutableList().filterIndexed { index, _ ->
            index != 0
        }
    }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = defaultPaddingCard, vertical = defaultPaddingCard),
        verticalArrangement = Arrangement.spacedBy(defaultSpaceBetweenCard),
    ) {
        item {
            MainCardNews(header)
            DashboardDivider()
        }
        item {
            SourcesCard(articleState.sources)
            DashboardShortSpace()
            DashboardDivider()
        }
        itemsIndexed(articles) { index, article ->
            SecondaryCardNews(article)
            if (index < articles.size - 1)
                DashboardDivider()
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

@Composable
fun CoverLoad() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            color = Color.Black
        )
    }
}

@Preview
@Composable
fun preview() {
    RowListText(listOf("Política", "Esporte","Cinema", "Lazer", "Política", "Esporte","Cinema", "Lazer"))
}

