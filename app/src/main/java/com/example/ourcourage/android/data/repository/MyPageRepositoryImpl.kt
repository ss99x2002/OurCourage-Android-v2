package com.example.ourcourage.android.data.repository

import com.example.ourcourage.android.data.datasource.remote.MyPageRemoteDataSource
import com.example.ourcourage.android.data.mapper.todomain.toDomain
import com.example.ourcourage.android.data.model.response.MyPageEditResultResponseDto
import com.example.ourcourage.android.domain.model.MyPageUserInfo
import com.example.ourcourage.android.domain.repository.MyPageRepository
import javax.inject.Inject

class MyPageRepositoryImpl @Inject constructor(
    private val myPageRemoteDataSource: MyPageRemoteDataSource
) : MyPageRepository {
    override suspend fun fetchUserInfoInMyPage(): Result<MyPageUserInfo> {
        return runCatching {
            myPageRemoteDataSource.fetchMyPageResult().result.toDomain()
        }
    }

    override suspend fun patchUserInfoInMyPage(editNickname: String): Result<MyPageEditResultResponseDto> {
        return runCatching {
            myPageRemoteDataSource.patchUserInfoInMyPage(editNickname).result
        }
    }
}