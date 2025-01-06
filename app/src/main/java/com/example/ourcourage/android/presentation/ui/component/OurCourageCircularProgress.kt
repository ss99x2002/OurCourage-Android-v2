package com.example.ourcourage.android.presentation.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun OurCourageCircularProgress(
    modifier: Modifier,
    contentAlignment: Alignment,
    progressColor: Color
) {
    Box(modifier = modifier, contentAlignment = contentAlignment) {
        CircularProgressIndicator(
            color = progressColor,
            backgroundColor = Color.Transparent
        )
    }
}