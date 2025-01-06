package com.example.ourcourage.android.domain.model

import kotlinx.serialization.SerialName

data class ReturnLocationInfo (
    val locationId: Int,
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val locationType: String,
    val imageUrl: String
)