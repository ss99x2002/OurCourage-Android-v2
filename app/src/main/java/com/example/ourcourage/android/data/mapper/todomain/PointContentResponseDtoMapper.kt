package com.example.ourcourage.android.data.mapper.todomain

import com.example.ourcourage.android.data.model.response.PointContentResponseDto
import com.example.ourcourage.android.domain.model.PointContent

fun PointContentResponseDto.toDomain(): PointContent {
    return PointContent(
        useAtParsed = this.useAtParsed,
        useAt = this.useAt,
        point = this.point,
        pointTypeImageUrl = this.pointTypeImageUrl,
        returnLocationName = this.returnLocationName,
        returnLocationAddress = this.returnLocationAddress,
        rentalLocationAddress = this.rentalLocationAddress,
        rentalLocationName = this.rentalLocationName,
    )
}
