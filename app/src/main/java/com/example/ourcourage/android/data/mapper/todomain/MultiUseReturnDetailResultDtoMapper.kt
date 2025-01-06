package com.example.ourcourage.android.data.mapper.todomain

import com.example.ourcourage.android.data.model.response.MultiUseReturnDetailResultResponseDto
import com.example.ourcourage.android.domain.model.ReturnDetail

fun MultiUseReturnDetailResultResponseDto.toDomain(): ReturnDetail {
    return ReturnDetail(
        rentalLocationId = this.rentalLocationId,
        locationAddress = this.locationAddress,
        locationName = this.locationName,
        locationImageUrl = this.locationImageUrl,
        multiUseContainerId = this.multiUseContainerId,
        useAt = this.useAt,
        point = this.point,
        getReturnResList = this.getReturnResList.map { it.toDomain() },
    )
}