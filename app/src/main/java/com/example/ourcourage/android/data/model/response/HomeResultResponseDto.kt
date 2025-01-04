package com.example.ourcourage.android.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HomeResultResponseDto(
    @SerialName("userId")
    val userId: Int,
    @SerialName("nickname")
    val nickname: String?, // nullable 처리
    @SerialName("getUseResList")
    val getUseResList: List<UseResResponseDto> = emptyList(), // 기본값 추가
    @SerialName("useCount")
    val useCount: Int,
    @SerialName("currentPoint")
    val currentPoint: Int
)