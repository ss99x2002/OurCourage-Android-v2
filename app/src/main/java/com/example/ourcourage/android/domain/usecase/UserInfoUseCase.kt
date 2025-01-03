package com.example.ourcourage.android.domain.usecase

import com.example.ourcourage.android.domain.model.UserInfo
import com.example.ourcourage.android.domain.repository.HomeRepository
import javax.inject.Inject

class UserInfoUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    suspend fun invoke(): Result<UserInfo> {
        return homeRepository.fetchUserInfoInHome()
    }
}