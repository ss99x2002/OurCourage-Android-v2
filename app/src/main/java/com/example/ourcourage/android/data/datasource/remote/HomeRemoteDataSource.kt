package com.example.ourcourage.android.data.datasource.remote

import com.example.ourcourage.android.data.model.response.HomeResponseDto
import com.example.ourcourage.android.data.model.response.HomeResultResponseDto

interface HomeRemoteDataSource {
    suspend fun fetchHomeResult() : HomeResponseDto
}