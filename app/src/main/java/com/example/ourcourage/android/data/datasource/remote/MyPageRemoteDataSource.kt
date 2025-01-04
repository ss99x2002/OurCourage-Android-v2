package com.example.ourcourage.android.data.datasource.remote

import com.example.ourcourage.android.data.model.response.MyPageEditResponseDto
import com.example.ourcourage.android.data.model.response.MyPageResponseDto

interface MyPageRemoteDataSource {
    suspend fun fetchMyPageResult(): MyPageResponseDto

    suspend fun patchUserInfoInMyPage(editNickname: String): MyPageEditResponseDto
}
