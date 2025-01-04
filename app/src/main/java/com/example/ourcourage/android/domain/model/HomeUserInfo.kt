package com.example.ourcourage.android.domain.model

data class HomeUserInfo(
    val userId: Int,
    val nickname: String?,
    val useCount: Int,
    val currentPoint: Int,
    val rentalContainers: List<RentalMultiUse> = emptyList(),
)
