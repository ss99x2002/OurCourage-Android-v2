package com.example.ourcourage.android.data.mapper.todomain

import com.example.ourcourage.android.data.model.response.PointResultResponseDto
import com.example.ourcourage.android.domain.model.PointHistory

fun PointResultResponseDto.toDomain(): PointHistory {
    return PointHistory(
        content = this.content.map { it.toDomain() },
        pageable = this.pageable.toDomain(),
        first = this.first,
        last = this.last,
        size = this.size,
        number = this.number,
        sort = this.sort,
        numberOfElements = this.numberOfElements,
        empty = this.empty
    )
}