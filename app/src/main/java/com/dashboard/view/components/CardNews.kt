package com.dashboard.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.SubcomposeAsyncImage
import coil.request.ImageRequest
import coil.transform.RoundedCornersTransformation
import com.dashboard.model.domain.Article
import com.dashboard.model.domain.Source
import com.dashboard.view.dashboardPadding
import com.dashboard.view.defaultPaddingCard
import com.dashboard.view.firaSansFamily

@Composable
fun MainCardNews(article: Article) {
    Column(
        Modifier.padding(dashboardPadding)
    ) {
        SubcomposeAsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(article.urlToImage?:"")
                .crossfade(true)
                .transformations(RoundedCornersTransformation(20f))
                .build(),
            contentDescription = "Image from article",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop,
            loading = {
                Box(Modifier.matchParentSize()) {
                    Image(
                        ColorPainter(Color.Gray),
                        contentDescription = "Load image",
                        modifier = Modifier.clip(shape = RoundedCornerShape(20f)),
                    )
                }
            },
            error = {
                Box(Modifier.matchParentSize()) {
                    Image(
                        ColorPainter(Color.Gray),
                        contentDescription = "Error image",
                        modifier = Modifier.clip(shape = RoundedCornerShape(20f)),
                    )
                }
            },
        )
        DashboardSpace()
        Text(
            text = article.source?.name?:"",
            fontSize = 18.sp,
            fontWeight = FontWeight.Light,
            fontFamily = firaSansFamily,
            color = Color.Gray
        )
        DashboardSpace()
        Text(
            article.title?:"",
            fontFamily = firaSansFamily,
            fontSize = 30.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(),
            fontWeight = FontWeight.Bold
        )
        DashboardSpace()
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "Health",
                fontSize = 18.sp,
                fontWeight = FontWeight.Light,
                fontFamily = firaSansFamily,
                color = Color.Blue
            )
            DashboardSpace()
            DashboardDot()
            DashboardSpace()
            Text(
                text = article.publishedAt?:"",
                fontSize = 18.sp,
                fontWeight = FontWeight.Light,
                fontFamily = firaSansFamily,
                color = Color.Gray
            )
            DashboardSpaceFullHorizontal {
                DashboardThreeVerticalDot()
            }
        }
        DashboardSpace()
    }
}

@Composable
fun SecondaryCardNews(article: Article) {
    val size = remember { mutableStateOf(90.dp) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        article.urlToImage?.let {
            SubcomposeAsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(it)
                    .crossfade(true)
                    .transformations(RoundedCornersTransformation(20f))
                    .build(),
                contentDescription = "Image from article",
                modifier = Modifier
                    .height(size.value)
                    .width(size.value),
                contentScale = ContentScale.Crop,
                loading = {
                    Box(
                        Modifier
                            .matchParentSize()
                            .clip(shape = RoundedCornerShape(20f))
                            .background(color = Color.Gray))
                },
                error = {
                    size.value = 0.dp
                    Box(Modifier.wrapContentSize())
                },
            )
        }
        DashboardCustomSpace(defaultPaddingCard)
        Column {
            Text(
                text = article.source?.name?:"",
                fontSize = 13.sp,
                fontWeight = FontWeight.Light,
                fontFamily = firaSansFamily,
                color = Color.Gray
            )
            DashboardShortSpace()
            Text(
                article.title?:"",
                fontFamily = firaSansFamily,
                fontSize = 15.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(),
                fontWeight = if(article.urlToImage.isNullOrEmpty() || size.value == 0.dp) FontWeight.SemiBold else FontWeight.Medium
            )
            DashboardShortSpace()
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Health",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = firaSansFamily,
                    color = Color.Blue
                )
                DashboardSpace()
                DashboardShortDot()
                DashboardSpace()
                Text(
                    text = article.publishedAt?:"",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = firaSansFamily,
                    color = Color.Gray
                )
                DashboardSpaceFullHorizontal {
                    DashboardThreeVerticalShortDot()
                }
            }
            DashboardShortSpace()
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

@Composable
fun RowListSources(messages: List<String>) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),) {
            items(messages) { message ->
                DashboardChip(message) {
                    // todo on click
                }
            }
        }
    }
}

@Composable
fun SourcesCard(sources: List<Source>) {
   Column (
       modifier = Modifier
           .wrapContentHeight()
           .fillMaxWidth()
   ) {
       RowListSources(sources.map { it.name })
   }
}

@Preview
@Composable
fun Preview() {
    Column(
        Modifier.background(Color.White)
    ) {
       // MainCardNews(null)

    }
}