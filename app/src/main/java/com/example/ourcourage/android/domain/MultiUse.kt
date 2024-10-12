package com.example.ourcourage.android.domain

data class MultiUse(
    val useAt: String,
    val point: Int = 100,
    val userId: Int = 1,
    val locationId: Int = 1,
    val locationName: String,
    val locationAddress: String = "",
    val locationImageUrl: Int,
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val multiUseContainerId: Int,
    val status: String,
)
