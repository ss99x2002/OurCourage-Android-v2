package com.example.ourcourage.android.domain.usecase

import com.example.ourcourage.android.data.model.response.MyPageEditResultResponseDto
import com.example.ourcourage.android.domain.repository.MyPageRepository
import javax.inject.Inject

class MyPageEditInfoUseCase
    @Inject
    constructor(
        private val myPageRepository: MyPageRepository,
    ) {
        suspend fun invoke(editNickname: String): Result<MyPageEditResultResponseDto> {
            return myPageRepository.patchUserInfoInMyPage(editNickname)
        }
    }
