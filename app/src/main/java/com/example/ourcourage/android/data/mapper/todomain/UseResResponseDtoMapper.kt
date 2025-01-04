package com.example.ourcourage.android.data.mapper.todomain

import com.example.ourcourage.android.data.model.response.UseResResponseDto
import com.example.ourcourage.android.domain.model.RentalMultiUse

fun UseResResponseDto.toDomain(): RentalMultiUse {
    return RentalMultiUse(
        rentalLocationId = this.rentalLocationId,
        locationName = this.locationName,
        locationImageUrl = this.locationImageUrl,
        useAt = this.useAt,
        status = this.status,
        multiUseContainerId = this.multiUseContainerId,
    )
}
