package com.example.ourcourage.android.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class DailyStatisticsResponseDto(
    val dayOfWeek: Int,
    val useCount: Int,
    val returnCount: Int
)