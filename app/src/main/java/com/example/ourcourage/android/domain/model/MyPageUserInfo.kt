package com.example.ourcourage.android.domain.model

data class MyPageUserInfo(
    val nickname: String,
    val gender: Boolean,
    val currentPoint: Int,
    val totalUseCount: Int,
    val totalReturnCount: Int,
    val dailyStatisticsResList: List<DailyStatistics>,
    val monthlyStatisticsResList: List<MonthlyStatistics>,
)
