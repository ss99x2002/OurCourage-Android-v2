package com.example.ourcourage.android.data.datasource.remote.impl

import com.example.ourcourage.android.data.datasource.remote.MyPageRemoteDataSource
import com.example.ourcourage.android.data.model.response.MyPageResponseDto
import com.example.ourcourage.android.data.service.MyPageService
import javax.inject.Inject

class MyPageRemoteDataSourceImpl @Inject constructor(
    private val myPageService: MyPageService
) : MyPageRemoteDataSource {
    override suspend fun fetchMyPageResult(): MyPageResponseDto {
        return myPageService.fetchUserInfoInMyPage()
    }
}