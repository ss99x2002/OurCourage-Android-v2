package com.example.ourcourage.android.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class MultiUseReturnResponseDto(
    val isSuccess: Boolean,
    val code: String,
    val message: String,
    val result: MultiUseReturnResultResponseDto
)