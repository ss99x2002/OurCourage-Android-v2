package com.example.ourcourage.android.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class PointResultResponseDto(
    val content: List<PointContentResponseDto>,
    val pageable: PointPageableResponseDto,
    val first: Boolean,
    val last: Boolean,
    val size: Long,
    val number: Long,
    val sort: PointSort2ResponseDto,
    val numberOfElements: Long,
    val empty: Boolean,
)