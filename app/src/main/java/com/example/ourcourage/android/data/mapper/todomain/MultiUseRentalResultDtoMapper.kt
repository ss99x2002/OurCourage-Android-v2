package com.example.ourcourage.android.data.mapper.todomain

import com.example.ourcourage.android.data.model.response.MultiUseRentalResultResponseDto
import com.example.ourcourage.android.domain.model.RentalDetail

fun MultiUseRentalResultResponseDto.toDomain(): RentalDetail {
    return RentalDetail(
        useAt = this.useAt,
        point = this.point,
        userId = this.userId,
        locationName = this.locationName,
        locationId = this.locationId,
        locationAddress = this.locationAddress,
        latitude = this.latitude,
        longitude = this.longitude,
        multiUseContainerId = this.multiUseContainerId,
        status = this.status,
        locationImageUrl = this.locationImageUrl
    )
}