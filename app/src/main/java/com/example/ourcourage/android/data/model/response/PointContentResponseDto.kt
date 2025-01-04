package com.example.ourcourage.android.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class PointContentResponseDto(
    val useAtParsed: String,
    val useAt: String,
    val point: Long,
    val pointTypeImageUrl: String,
    val rentalLocationName: String,
    val rentalLocationAddress: String,
    val returnLocationName: String,
    val returnLocationAddress: String,
)
