package com.example.ourcourage.android.data.datasource.remote

import com.example.ourcourage.android.data.model.response.MyPageResponseDto

interface MyPageRemoteDataSource {
    suspend fun fetchMyPageResult() : MyPageResponseDto
}