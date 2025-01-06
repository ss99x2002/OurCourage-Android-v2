package com.example.ourcourage.android.data.mapper.todomain

import com.example.ourcourage.android.data.model.response.MultiUseLocationResultResponseDto
import com.example.ourcourage.android.domain.model.RentalLocationInfo

fun MultiUseLocationResultResponseDto.toDomain(): RentalLocationInfo {
    return RentalLocationInfo(
        locationName = this.locationName,
        locationId = this.locationId,
        locationAddress = this.locationAddress,
        locationImageUrl = this.locationImageUrl,
        longitude = this.longitude,
        latitude = this.latitude,
        multiUseContainerIds = this.multiUseContainerIdList,
        point = this.point
    )
}