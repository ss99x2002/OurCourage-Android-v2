package com.example.ourcourage.android.data.mapper.todomain

import com.example.ourcourage.android.data.model.response.MultiUseReturnResultResponseDto
import com.example.ourcourage.android.domain.model.ReturnMultiUse


fun MultiUseReturnResultResponseDto.toDomain(): ReturnMultiUse {
    return ReturnMultiUse(
        returnLocationName = this.returnLocationAddress,
        returnLocationAddress = this.returnLocationAddress,
        returnTime = this.returnTime,
        currentPoint = this.currentPoint,
        acquiredPoint = this.acquiredPoint,
        userId = this.userId,
        status = this.status,
        returnLocationId = this.returnLocationId
    )
}