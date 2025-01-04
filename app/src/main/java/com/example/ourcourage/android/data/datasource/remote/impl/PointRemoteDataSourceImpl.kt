package com.example.ourcourage.android.data.datasource.remote.impl

import com.example.ourcourage.android.data.datasource.remote.PointRemoteDataSource
import com.example.ourcourage.android.data.model.response.PointResponseDto
import com.example.ourcourage.android.data.service.PointService
import javax.inject.Inject

class PointRemoteDataSourceImpl
    @Inject
    constructor(
        private val pointService: PointService,
    ) : PointRemoteDataSource {
        override suspend fun fetchPointHistory(
            page: Int,
            size: Int,
        ): PointResponseDto {
            return pointService.fetchPointHistory(page, size)
        }
    }
