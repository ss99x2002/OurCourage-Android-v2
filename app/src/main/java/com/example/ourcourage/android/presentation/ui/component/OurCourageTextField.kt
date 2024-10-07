package com.example.ourcourage.android.presentation.ui.component

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun OurCourageTextField(
    modifier: Modifier = Modifier,
    title: String? = null,
    value: String = "",
    onClick: () -> Unit = {},
    onValueChange: (String) -> Unit = { _ -> },
    isError: Boolean = false,
    errorDescription: String = "",
    singleLine: Boolean = true,
    placeholder: String = "",
    hint: String = "",
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        textStyle = LocalTextStyle.current.copy(fontSize = 16.sp),
        decorationBox = { innerTextField ->
        },
    )
}
