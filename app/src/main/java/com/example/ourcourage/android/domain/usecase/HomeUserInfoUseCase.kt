package com.example.ourcourage.android.domain.usecase

import com.example.ourcourage.android.domain.model.HomeUserInfo
import com.example.ourcourage.android.domain.repository.HomeRepository
import javax.inject.Inject

class HomeUserInfoUseCase
    @Inject
    constructor(
        private val homeRepository: HomeRepository,
    ) {
        suspend fun invoke(): Result<HomeUserInfo> {
            return homeRepository.fetchUserInfoInHome()
        }
    }
