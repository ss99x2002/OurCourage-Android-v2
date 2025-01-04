package com.example.ourcourage.android.data.datasource.remote

import com.example.ourcourage.android.data.model.response.HomeResponseDto

interface HomeRemoteDataSource {
    suspend fun fetchHomeResult(): HomeResponseDto
}
