package com.example.ourcourage.android.domain.repository

import com.example.ourcourage.android.data.model.response.MyPageEditResultResponseDto
import com.example.ourcourage.android.domain.model.MyPageUserInfo

interface MyPageRepository {
    suspend fun fetchUserInfoInMyPage(): Result<MyPageUserInfo>

    suspend fun patchUserInfoInMyPage(editNickname: String): Result<MyPageEditResultResponseDto>
}
