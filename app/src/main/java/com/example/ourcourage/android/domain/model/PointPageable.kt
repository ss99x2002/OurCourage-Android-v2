package com.example.ourcourage.android.domain.model

import com.example.ourcourage.android.data.model.response.PointPageableResponseDto.PointSortResponseDto

data class PointPageable(
    val pageNumber: Long,
    val pageSize: Long,
    val sort: PointSortResponseDto,
    val offset: Long,
    val paged: Boolean,
    val unpaged: Boolean,
)