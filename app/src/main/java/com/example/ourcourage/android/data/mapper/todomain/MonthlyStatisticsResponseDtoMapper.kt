package com.example.ourcourage.android.data.mapper.todomain

import com.example.ourcourage.android.data.model.response.MonthlyStatisticsResponseDto
import com.example.ourcourage.android.domain.model.MonthlyStatistics

fun MonthlyStatisticsResponseDto.toDomain(): MonthlyStatistics {
    return MonthlyStatistics(
        month = this.month,
        useCount = this.useCount,
        returnCount = this.returnCount
    )
}