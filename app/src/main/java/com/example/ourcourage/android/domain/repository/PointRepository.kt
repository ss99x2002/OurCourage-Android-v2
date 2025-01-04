package com.example.ourcourage.android.domain.repository

import com.example.ourcourage.android.domain.model.PointHistory

interface PointRepository {
    suspend fun fetchPointHistory(
        page: Int,
        size: Int,
    ): Result<PointHistory>
}
