package com.example.ourcourage.android.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MultiUseRentalResultResponseDto(
    @SerialName("useAt")
    val useAt: String,
    @SerialName("point")
    val point: Int,
    @SerialName("userId")
    val userId: Int,
    @SerialName("locationId")
    val locationId: Int,
    @SerialName("locationName")
    val locationName: String,
    @SerialName("locationAddress")
    val locationAddress: String,
    @SerialName("locationImageUrl")
    val locationImageUrl: String,
    @SerialName("latitude")
    val latitude: Double,
    @SerialName("longitude")
    val longitude: Double,
    @SerialName("multiUseContainerId")
    val multiUseContainerId: Int,
    @SerialName("status")
    val status: String
)