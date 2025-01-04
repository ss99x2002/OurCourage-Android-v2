package com.example.ourcourage.android.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class PointPageableResponseDto(
    val pageNumber: Long,
    val pageSize: Long,
    val sort: PointSortResponseDto,
    val offset: Long,
    val paged: Boolean,
    val unpaged: Boolean,
) {
    @Serializable
    data class PointSortResponseDto(
        val empty: Boolean,
        val unsorted: Boolean,
        val sorted: Boolean,
    )
}

@Serializable
data class PointSort2ResponseDto(
    val empty: Boolean,
    val unsorted: Boolean,
    val sorted: Boolean,
)
