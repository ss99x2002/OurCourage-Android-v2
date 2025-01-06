package com.example.ourcourage.android.domain.model

data class ReturnMultiUse(
    val returnLocationId: Long,
    val returnLocationName: String,
    val returnLocationAddress: String,
    val returnTime: String,
    val currentPoint: Long,
    val acquiredPoint: Long,
    val userId: Long,
    val status: String,
)