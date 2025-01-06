package com.example.ourcourage.android.domain.model

import com.example.ourcourage.android.presentation.type.MultiUseType

data class ScanCompletedContent(
    val point: Int,
    val locationName: String,
    val locationAddress: String,
    val useAt: String,
    val totalPoint: Int,
    val multiUseContainerId : Int?,
){
    val multiUseContainerType: MultiUseType
        get() = MultiUseType.fromId(multiUseContainerId!!)
}