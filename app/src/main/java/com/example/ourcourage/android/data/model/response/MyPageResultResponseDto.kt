package com.example.ourcourage.android.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class MyPageResultResponseDto(
    val nickname: String,
    val gender: Boolean,
    val currentPoint: Int,
    val totalUseCount: Int,
    val totalReturnCount: Int,
    val dailyStatisticsResList: List<DailyStatisticsResponseDto>,
    val monthlyStatisticsResList: List<MonthlyStatisticsResponseDto>,
)
