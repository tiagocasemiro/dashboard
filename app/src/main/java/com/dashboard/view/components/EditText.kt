package com.dashboard.view.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation


@Composable
fun DashboardTextField() {
    val text = remember { mutableStateOf("Text") }

    TextField(
        value = text.value,
        onValueChange = {
            text.value = it
        },
        modifier = Modifier,
        enabled = true,
        readOnly = false,
        textStyle = LocalTextStyle.current,
        label = null,
        placeholder = null,
        leadingIcon = null,
        trailingIcon = null,
        isError = false,
        visualTransformation = VisualTransformation.None,
        keyboardOptions = KeyboardOptions.Default,
        keyboardActions = KeyboardActions(),
        singleLine = false,
        maxLines = Int.MAX_VALUE,
        interactionSource = remember { MutableInteractionSource() },
        shape = MaterialTheme.shapes.small.copy(bottomEnd = ZeroCornerSize, bottomStart = ZeroCornerSize),
        colors = TextFieldDefaults.textFieldColors()
    )
}
