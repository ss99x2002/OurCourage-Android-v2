package com.example.ourcourage.android.data.mapper.todomain

import com.example.ourcourage.android.data.model.response.MultiUseReturnResListResponseDto
import com.example.ourcourage.android.data.model.response.MultiUseReturnResultResponseDto
import com.example.ourcourage.android.domain.model.ReturnLocationInfo
import com.example.ourcourage.android.domain.model.ReturnMultiUse

fun MultiUseReturnResListResponseDto.toDomain(): ReturnLocationInfo {
    return ReturnLocationInfo(
        locationId = this.locationId,
        name = this.name,
        address = this.address,
        latitude = this.latitude,
        longitude = this.longitude,
        locationType = this.locationType,
        imageUrl = this.imageUrl
    )
}