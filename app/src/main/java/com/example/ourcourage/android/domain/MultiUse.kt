package com.example.ourcourage.android.domain

import com.example.ourcourage.android.R

data class MultiUse(
    val rentalLocationId: Int,
    val locationName: String,
    val useAt: String,
    val status: String,
    val multiUseContainerId: Int,
    val multiUseImage: Int = R.drawable.img_tumbler,
)
