package com.dashboard.view.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.dashboard.R
import com.dashboard.view.components.TopBar
import com.dashboard.view.firaSansFamily

@Composable
fun CoverScreen(navController: NavController) {

        Scaffold(
            topBar = {
                TopBar(R.string.app_name)
            }
        ) {
           Column {
                RowListText(listOf("Política", "Esporte","Cinema", "Lazer"))
                Button(onClick = {
                    navController.navigate("search-screen")
                }) {
                    Text(text = "ir")
                }
            }
        }

}

@Composable
fun RowListText(messages: List<String>) {
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
}

