package com.example.ourcourage.android.model

import androidx.compose.runtime.MutableState

data class ChipState(
    val text: String,
    val isSelected: MutableState<Boolean>,
    // unexpected changes 를 막기위해 immutable 속성 변경
)
