package com.example.ourcourage.android.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MultiUseReturnDetailResultResponseDto(
    @SerialName("rentalLocationId")
    val rentalLocationId: Int,
    @SerialName("locationImageUrl")
    val locationImageUrl: String,
    @SerialName("locationName")
    val locationName: String,
    @SerialName("locationAddress")
    val locationAddress: String,
    @SerialName("useAt")
    val useAt: String,
    @SerialName("point")
    val point: Int,
    @SerialName("multiUseContainerId")
    val multiUseContainerId: Int,
    @SerialName("getReturnResList")
    val getReturnResList: List<MultiUseReturnResListResponseDto>,
)