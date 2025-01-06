package com.example.ourcourage.android.domain.mapper

import com.example.ourcourage.android.domain.model.RentalDetail
import com.example.ourcourage.android.domain.model.ScanCompletedContent

fun RentalDetail.toScanComplete(): ScanCompletedContent {
    return ScanCompletedContent(
        point = this.point,
        locationName = this.locationName,
        locationAddress = this.locationAddress,
        useAt = this.useAt,
        totalPoint = this.point,
        multiUseContainerId = this.multiUseContainerId
    )
}