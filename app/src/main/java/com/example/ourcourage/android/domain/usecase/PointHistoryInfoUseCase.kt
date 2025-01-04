package com.example.ourcourage.android.domain.usecase

import com.example.ourcourage.android.domain.model.PointHistory
import com.example.ourcourage.android.domain.repository.PointRepository
import javax.inject.Inject

class PointHistoryInfoUseCase
    @Inject
    constructor(
        private val pointRepository: PointRepository,
    ) {
        suspend fun invoke(
            page: Int,
            size: Int,
        ): Result<PointHistory> {
            return pointRepository.fetchPointHistory(page, size)
        }
    }
