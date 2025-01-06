package com.example.ourcourage.android.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MultiUseLocationResultResponseDto (
    @SerialName("locationId")
    val locationId: Long,
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
    @SerialName("point")
    val point: Long,
    @SerialName("multiUseContainerIdList")
    val multiUseContainerIdList: List<Long>,
)