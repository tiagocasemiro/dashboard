package com.dashboard.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.dashboard.R
import com.dashboard.view.components.DashboardDivider
import com.dashboard.view.components.MainCardNews
import com.dashboard.view.components.TopBarWithSearch
import com.dashboard.view.firaSansFamily

@Composable
fun CoverScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopBarWithSearch(R.string.app_name, onSearch = {
                navController.navigate("search-screen")
            })
        }
    ) {
       Column {
            RowListText(listOf("Política", "Esporte", "Cinema", "Lazer", "Política", "Esporte","Cinema", "Lazer"))
            MainCardNews(null)
        }
    }
}

@Composable
fun RowListText(messages: List<String>) {
    Column {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),) {
            items(messages) { message ->
                Text(
                    text = message,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = firaSansFamily,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
        }
        DashboardDivider()
    }
}

@Preview
@Composable
fun preview() {
    RowListText(listOf("Política", "Esporte","Cinema", "Lazer", "Política", "Esporte","Cinema", "Lazer"))
}

