package com.example.ourcourage.android.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UseResResponseDto(
    @SerialName("rentalLocationId")
    val rentalLocationId: Int,
    @SerialName("locationImageUrl")
    val locationImageUrl: String,
    @SerialName("locationName")
    val locationName: String,
    @SerialName("useAt")
    val useAt: String,
    @SerialName("status")
    val status: String,
    @SerialName("multiUseContainerId")
    val multiUseContainerId: Int,
)
