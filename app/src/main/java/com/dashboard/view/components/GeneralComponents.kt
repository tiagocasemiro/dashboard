package com.dashboard.view.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dashboard.R

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.dashboard.view.firaSansFamily
import com.dashboard.view.Shapes


@Composable
fun DashboardDivider() {
    Divider(color = colorResource(id = R.color.divider), thickness = 1.dp)
}

@Composable
fun DashboardDot(){
    Canvas(modifier = Modifier.size(5.dp), onDraw = {
        drawCircle(color = Color.Gray)
    })
}

@Composable
fun DashboardShortDot(){
    Canvas(modifier = Modifier.size(3.dp), onDraw = {
        drawCircle(color = Color.Gray)
    })
}


@Composable
fun DashboardThreeVerticalDot() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Canvas(modifier = Modifier.size(5.dp), onDraw = {
            drawCircle(color = Color.Gray)
        })
        Spacer(modifier = Modifier.size(3.dp))
        Canvas(modifier = Modifier.size(5.dp), onDraw = {
            drawCircle(color = Color.Gray)
        })
        Spacer(modifier = Modifier.size(3.dp))
        Canvas(modifier = Modifier.size(5.dp), onDraw = {
            drawCircle(color = Color.Gray)
        })
    }
}

@Composable
fun DashboardThreeVerticalShortDot() {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Canvas(modifier = Modifier.size(3.dp), onDraw = {
            drawCircle(color = Color.Gray)
        })
        Spacer(modifier = Modifier.size(2.dp))
        Canvas(modifier = Modifier.size(3.dp), onDraw = {
            drawCircle(color = Color.Gray)
        })
        Spacer(modifier = Modifier.size(2.dp))
        Canvas(modifier = Modifier.size(3.dp), onDraw = {
            drawCircle(color = Color.Gray)
        })
    }
}

@Composable
fun DashboardSpace() {
    Spacer(modifier = Modifier.size(15.dp))
}

@Composable
fun DashboardShortSpace() {
    Spacer(modifier = Modifier.size(5.dp))
}

@Composable
fun DashboardCustomSpace(value: Dp) {
    Spacer(modifier = Modifier.size(value))
}


@Composable
fun DashboardSpaceFullHorizontal(content: @Composable RowScope.() -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        content()
    }
}

@Composable
fun DashboardChip(text: String, onExecuteSearch: (String) -> Unit){
    Surface(
        modifier = Modifier.padding(end = 8.dp),
        elevation = 8.dp,
        shape = Shapes.medium,
        color = Color.Transparent,
        contentColor = Color.White
    ) {
        Row(modifier = Modifier
            .clickable(
                onClick = {
                    onExecuteSearch(text)
                }
            )
        ) {
            Text(
                text = text,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = firaSansFamily,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Black, shape = Shapes.medium)
                    .padding(horizontal = 20.dp, vertical = 5.dp),
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}





