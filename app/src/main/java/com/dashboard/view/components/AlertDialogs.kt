package com.dashboard.view.components

import androidx.compose.foundation.background
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun ErrorDialog(title: String, message: String, onClick: () -> Unit = {}) {
    val openDialog = remember { mutableStateOf(true)  }
    if(openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = title) },
            text = { Text(message) },
            confirmButton = {
                Button(content = {
                    Text("OK",
                        color = Color.White,
                    )
                },
                onClick = {
                    onClick()
                    openDialog.value = false
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Black,
                    contentColor = Color.White)
                )
            }
        )
    }
}