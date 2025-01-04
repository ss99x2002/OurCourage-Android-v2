package com.example.ourcourage.android.data.mapper.todomain

import com.example.ourcourage.android.data.model.response.DailyStatisticsResponseDto
import com.example.ourcourage.android.domain.model.DailyStatistics

fun DailyStatisticsResponseDto.toDomain(): DailyStatistics {
    return DailyStatistics(
        dayOfWeek = this.dayOfWeek,
        useCount = this.useCount,
        returnCount = this.returnCount
    )
}