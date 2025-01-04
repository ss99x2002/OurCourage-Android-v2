package com.example.ourcourage.android.data.mapper.todomain

import com.example.ourcourage.android.data.model.response.PointPageableResponseDto
import com.example.ourcourage.android.domain.model.PointPageable

fun PointPageableResponseDto.toDomain(): PointPageable {
    return PointPageable(
        pageNumber = this.pageNumber,
        pageSize = this.pageSize,
        sort = this.sort,
        offset = this.offset,
        paged = this.paged,
        unpaged = this.unpaged,
    )
}
