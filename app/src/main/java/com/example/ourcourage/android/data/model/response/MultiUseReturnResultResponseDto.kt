package com.example.ourcourage.android.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class MultiUseReturnResultResponseDto(
    val returnLocationId: Long,
    val returnLocationName: String,
    val returnLocationAddress: String,
    val returnTime: String,
    val currentPoint: Long,
    val acquiredPoint: Long,
    val userId: Long,
    val status: String,
)