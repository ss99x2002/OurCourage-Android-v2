package com.example.ourcourage.android.domain.model

import com.example.ourcourage.android.data.model.response.PointContentResponseDto
import com.example.ourcourage.android.data.model.response.PointPageableResponseDto
import com.example.ourcourage.android.data.model.response.PointSort2ResponseDto

data class PointHistory (
    val content: List<PointContent>,
    val pageable: PointPageable,
    val first: Boolean,
    val last: Boolean,
    val size: Long,
    val number: Long,
    val sort: PointSort2ResponseDto,
    val numberOfElements: Long,
    val empty: Boolean,
)