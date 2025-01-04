package com.example.ourcourage.android.data.mapper.todomain

import com.example.ourcourage.android.data.model.response.MyPageResultResponseDto
import com.example.ourcourage.android.domain.model.MyPageUserInfo

fun MyPageResultResponseDto.toDomain(): MyPageUserInfo {
    return MyPageUserInfo(
        nickname = this.nickname,
        gender = this.gender,
        currentPoint = this.currentPoint,
        totalUseCount = this.totalUseCount,
        totalReturnCount = this.totalReturnCount,
        dailyStatisticsResList = this.dailyStatisticsResList.map { it.toDomain() },
        monthlyStatisticsResList = this.monthlyStatisticsResList.map { it.toDomain() },
    )
}
