package com.example.ourcourage.android.data.mapper.todomain

import com.example.ourcourage.android.data.model.response.HomeResultResponseDto
import com.example.ourcourage.android.domain.model.UserInfo

fun HomeResultResponseDto.toDomain() : UserInfo {
    return UserInfo(
        userId = this.userId,
        nickname = this.nickname,
        useCount = this.useCount,
        currentPoint = this.currentPoint,
        rentalContainers = this.getUseResList.map { it.toDomain() }
    )
}