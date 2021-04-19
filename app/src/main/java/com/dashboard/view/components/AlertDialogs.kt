package com.dashboard.view.components


import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun PresentDialog() {
    val openDialog = remember { mutableStateOf(true)  }
    if(openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = "Alert Dialog")
            },
            text = {
                Text("JetPack Compose Alert Dialog!")
            },
            confirmButton = {
                Button(content = { Text("OK") }, onClick = {

                })
            }
        )
    }
}