package com.example.ourcourage.android.data.model.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.Serializer

@Serializable
data class MyPageResponseDto(
    val isSuccess: Boolean,
    val code: String,
    val message: String,
    val result: MyPageResultResponseDto
)