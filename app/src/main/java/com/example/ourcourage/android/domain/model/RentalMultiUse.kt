package com.example.ourcourage.android.domain.model

import com.example.ourcourage.android.presentation.type.MultiUseStatusType
import com.example.ourcourage.android.presentation.type.MultiUseType

data class RentalMultiUse(
    val rentalLocationId: Int,
    val locationName: String,
    val locationImageUrl: String,
    val useAt: String,
    val status: String,
    val multiUseContainerId: Int
) {
    val multiUseContainerType : MultiUseType
        get() = MultiUseType.fromId(multiUseContainerId)
    val multiUseContainerStatus : MultiUseStatusType
        get() = MultiUseStatusType.fromType(status)
}