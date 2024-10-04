package com.example.ourcourage.android.model

import androidx.compose.runtime.MutableState

data class ChipState(
    var text: String,
    val isSelected: MutableState<Boolean>,
)
