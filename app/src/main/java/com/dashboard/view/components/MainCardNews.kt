package com.dashboard.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.dashboard.R
import com.dashboard.model.domain.Article
import com.dashboard.view.firaSansFamily
import com.google.accompanist.coil.CoilImage
import com.google.accompanist.glide.GlideImage

@Composable
fun MainCardNews(article: Article?) {
    Column(
        Modifier.padding(dashboardPadding)
    ) {
        CoilImage(
            data = "https://cloudfront-eu-central-1.images.arcpublishing.com/prisa/S5PYKVUYINH75JL745EPPSXF3E.jpg",
            contentDescription = "description of the image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop,
            requestBuilder = {
                transformations(RoundedCornersTransformation(20f))
            },
            loading = {
                Box(Modifier.matchParentSize()) {
                    Image(
                        ColorPainter(Color.Gray),
                        contentDescription = "description of the image",
                        modifier = Modifier.clip(shape = RoundedCornerShape(20f)),
                    )
                }
            },
            error = {
                Box(Modifier.matchParentSize()) {
                    Image(
                        ColorPainter(Color.Gray),
                        contentDescription = "description of the image",
                        modifier = Modifier.clip(shape = RoundedCornerShape(20f)),
                    )
                }
            },
            fadeIn = true
        )
        DashboardSpace()
        Text(
            text = "Bloomberg",
            fontSize = 18.sp,
            fontWeight = FontWeight.Light,
            fontFamily = firaSansFamily,
            color = Color.Gray
        )
        DashboardSpace()
        Text(
            "A confirmação da anulação das condenações de Lula na Lava Jato",
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
                text = "1m ago",
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

@Preview
@Composable
fun Preview() {
    Column(
        Modifier.background(Color.White)
    ) {
        MainCardNews(null)

    }
}