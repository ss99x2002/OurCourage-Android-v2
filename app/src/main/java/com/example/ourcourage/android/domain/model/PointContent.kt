package com.example.ourcourage.android.domain.model

data class PointContent(
    val useAtParsed: String,
    val useAt: String,
    val point: Long,
    val pointTypeImageUrl: String,
    val rentalLocationName: String,
    val rentalLocationAddress: String,
    val returnLocationName: String,
    val returnLocationAddress: String,
)
