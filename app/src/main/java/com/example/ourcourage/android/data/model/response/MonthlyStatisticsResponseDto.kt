package com.example.ourcourage.android.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class MonthlyStatisticsResponseDto(
    val month: Int,
    val useCount: Int,
    val returnCount: Int
)