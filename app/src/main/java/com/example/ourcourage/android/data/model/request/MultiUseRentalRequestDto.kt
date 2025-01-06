package com.example.ourcourage.android.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MultiUseRentalRequestDto(
    @SerialName("locationId")
    val locationId : Int,
    @SerialName("point")
    val point:Int,
    @SerialName("multiUseContainerId")
    val multiUseContainerId : Int
)