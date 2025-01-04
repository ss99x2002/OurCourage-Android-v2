package com.example.ourcourage.android.data.datasource.remote

import com.example.ourcourage.android.data.model.response.PointResponseDto

interface PointRemoteDataSource {
    suspend fun fetchPointHistory(page: Int, size: Int): PointResponseDto
}