package com.example.ourcourage.android.data.repository

import com.example.ourcourage.android.data.datasource.remote.PointRemoteDataSource
import com.example.ourcourage.android.data.mapper.todomain.toDomain
import com.example.ourcourage.android.domain.model.PointHistory
import com.example.ourcourage.android.domain.repository.PointRepository
import javax.inject.Inject

class PointRepositoryImpl
    @Inject
    constructor(
        private val pointRemoteDataSource: PointRemoteDataSource,
    ) : PointRepository {
        override suspend fun fetchPointHistory(
            page: Int,
            size: Int,
        ): Result<PointHistory> {
            return runCatching {
                pointRemoteDataSource.fetchPointHistory(page, size).result.toDomain()
            }
        }
    }
