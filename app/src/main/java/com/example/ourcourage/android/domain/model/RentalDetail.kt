package com.example.ourcourage.android.domain.model

import com.example.ourcourage.android.presentation.type.MultiUseStatusType
import com.example.ourcourage.android.presentation.type.MultiUseType

data class RentalDetail(
    val useAt: String,
    val point: Int,
    val userId: Int,
    val locationId: Int,
    val locationName: String,
    val locationAddress: String,
    val locationImageUrl: String,
    val latitude: Double,
    val longitude: Double,
    val multiUseContainerId: Int,
    val status: String,
) {
    val multiUseContainerType: MultiUseType
        get() = MultiUseType.fromId(multiUseContainerId)
    val multiUseContainerStatus: MultiUseStatusType
        get() = MultiUseStatusType.fromType(status)
}