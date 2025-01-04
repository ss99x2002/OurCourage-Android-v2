package com.example.ourcourage.android.domain.usecase

import com.example.ourcourage.android.domain.model.MyPageUserInfo
import com.example.ourcourage.android.domain.repository.MyPageRepository
import javax.inject.Inject

class MyPageUserInfoUseCase
    @Inject
    constructor(
        private val myPageRepository: MyPageRepository,
    ) {
        suspend fun invoke(): Result<MyPageUserInfo> {
            return myPageRepository.fetchUserInfoInMyPage()
        }
    }
