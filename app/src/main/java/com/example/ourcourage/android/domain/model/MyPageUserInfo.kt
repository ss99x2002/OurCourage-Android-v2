package com.example.ourcourage.android.domain.model

import com.example.ourcourage.android.data.model.response.DailyStatisticsResponseDto
import com.example.ourcourage.android.data.model.response.MonthlyStatisticsResponseDto

data class MyPageUserInfo(
    val nickname: String,
    val gender: Boolean,
    val currentPoint: Int,
    val totalUseCount: Int,
    val totalReturnCount: Int,
    val dailyStatisticsResList: List<DailyStatisticsResponseDto>,
    val monthlyStatisticsResList: List<MonthlyStatisticsResponseDto>
)