package com.example.ourcourage.android.domain.model

import com.example.ourcourage.android.data.model.response.MultiUseReturnResListResponseDto
import kotlinx.serialization.SerialName

data class ReturnDetail(
    val rentalLocationId: Int,
    val locationImageUrl: String,
    val locationName: String,
    val locationAddress: String,
    val useAt: String,
    val point: Int,
    val multiUseContainerId: Int,
    val getReturnResList: List<ReturnLocationInfo>,
)