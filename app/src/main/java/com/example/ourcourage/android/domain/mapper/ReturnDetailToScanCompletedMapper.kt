package com.example.ourcourage.android.domain.mapper

import com.example.ourcourage.android.domain.model.ReturnDetail
import com.example.ourcourage.android.domain.model.ReturnMultiUse
import com.example.ourcourage.android.domain.model.ScanCompletedContent

fun ReturnMultiUse.toScanComplete() : ScanCompletedContent {
    return ScanCompletedContent(
        point =  this.acquiredPoint.toInt(),
        locationName = this.returnLocationName,
        locationAddress = this.returnLocationAddress,
        useAt = this.returnTime,
        totalPoint = this.currentPoint.toInt(),
        multiUseContainerId = null
    )
}