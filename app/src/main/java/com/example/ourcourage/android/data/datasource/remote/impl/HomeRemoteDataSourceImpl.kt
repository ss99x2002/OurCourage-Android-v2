package com.example.ourcourage.android.data.datasource.remote.impl

import android.util.Log
import com.example.ourcourage.android.data.datasource.remote.HomeRemoteDataSource
import com.example.ourcourage.android.data.model.response.HomeResponseDto
import com.example.ourcourage.android.data.model.response.HomeResultResponseDto
import com.example.ourcourage.android.data.service.HomeService
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(
    private val homeService: HomeService
) : HomeRemoteDataSource {
    override suspend fun fetchHomeResult() : HomeResponseDto {
        return homeService.fetchHomeResult()
    }
}