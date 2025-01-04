package com.example.ourcourage.android.data.mapper.todomain

import com.example.ourcourage.android.data.model.response.HomeResultResponseDto
import com.example.ourcourage.android.domain.model.HomeUserInfo

fun HomeResultResponseDto.toDomain() : HomeUserInfo {
    return HomeUserInfo(
        userId = this.userId,
        nickname = this.nickname,
        useCount = this.useCount,
        currentPoint = this.currentPoint,
        rentalContainers = this.getUseResList.map { it.toDomain() }
    )
}