package com.example.ourcourage.android.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MultiUseRentalResponseDto (
    @SerialName("isSuccess")
    val isSuccess: Boolean,
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
    @SerialName("result")
    val result: MultiUseRentalResultResponseDto
)