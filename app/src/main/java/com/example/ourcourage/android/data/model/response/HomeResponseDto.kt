package com.example.ourcourage.android.data.model.response

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class HomeResponseDto(
    @SerialName("isSuccess")
    val isSuccess: Boolean,
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: HomeResultResponseDto
)
