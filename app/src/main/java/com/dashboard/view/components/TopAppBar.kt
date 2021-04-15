package com.dashboard.view.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dashboard.R
import com.dashboard.view.firaSansFamily

@Composable
fun TopBar(@StringRes title: Int) {
    TopAppBar(
        title = {
            Text(
                stringResource(id = title),
                fontFamily = firaSansFamily,
                fontSize = 30.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(),
                fontWeight = FontWeight.Bold
            )
        },
        backgroundColor = colorResource(id = R.color.white),
        contentColor = colorResource(id = R.color.black),
        elevation = 0.dp
    )
}

@Composable
fun TopBarBackAndFindButtons(@StringRes title: Int, onBack: () -> Unit, onSearch: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                stringResource(id = title),
                fontFamily = firaSansFamily,
                fontSize = 30.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(),
                fontWeight = FontWeight.Bold
            )
        },
        backgroundColor = colorResource(id = R.color.white),
        contentColor = colorResource(id = R.color.black),
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = R.string.content_description_back_button),
                    tint = colorResource(id = R.color.black)
                )
            }
        },
        actions = {
            IconButton(onClick = onSearch) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = stringResource(id = R.string.content_description_search_button),
                    tint = colorResource(id = R.color.black)
                )
            }
        },
        elevation = 0.dp
    )
}

