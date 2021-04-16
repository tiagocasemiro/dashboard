package com.dashboard.view.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.dashboard.R

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

val dashboardPadding = 15.dp

@Composable
fun DashboardSpace() {
    Spacer(modifier = Modifier.size(15.dp))
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



