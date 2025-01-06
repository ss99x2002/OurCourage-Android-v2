package com.example.ourcourage.android.presentation.ui.component

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.ourcourage.android.util.base.UiState

@Composable
fun OurCourageErrorBox(
    modifier: Modifier,
    contentAlignment: Alignment,
    errorMessage : String
) {
    Box(modifier = modifier, contentAlignment = contentAlignment) {
        Log.e("hyeon", "Error: ${errorMessage}")
        Text(text = "Error: $errorMessage", color = Color.Red)
    }
}