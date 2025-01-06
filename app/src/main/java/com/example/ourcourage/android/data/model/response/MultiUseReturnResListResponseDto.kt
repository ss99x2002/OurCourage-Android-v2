package com.example.ourcourage.android.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MultiUseReturnResListResponseDto(
    @SerialName("locationId")
    val locationId: Int,
    @SerialName("name")
    val name: String,
    @SerialName("address")
    val address: String,
    @SerialName("latitude")
    val latitude: Double,
    @SerialName("longitude")
    val longitude: Double,
    @SerialName("locationType")
    val locationType: String,
    @SerialName("imageUrl")
    val imageUrl: String
)