package com.dashboard.view

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dashboard.R

val dashboardPadding = 15.dp
val defaultPaddingCard = 8.dp
val defaultSpaceBetweenCard = 8.dp

val firaSansFamily = FontFamily(
    Font(R.font.firasans_light, FontWeight.Light),
    Font(R.font.firasans_regular, FontWeight.Normal),
    Font(R.font.firasans_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.firasans_medium, FontWeight.Medium),
    Font(R.font.firasans_bold, FontWeight.Bold)
)