package com.example.ourcourage.android.data.repository

import android.util.Log
import com.example.ourcourage.android.data.datasource.remote.HomeRemoteDataSource
import com.example.ourcourage.android.data.mapper.todomain.toDomain
import com.example.ourcourage.android.domain.model.HomeUserInfo
import com.example.ourcourage.android.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl
    @Inject
    constructor(
        private val homeRemoteDataSource: HomeRemoteDataSource,
    ) : HomeRepository {
        override suspend fun fetchUserInfoInHome(): Result<HomeUserInfo> =
            runCatching {
                Log.e("hyeon", homeRemoteDataSource.fetchHomeResult().toString())
                homeRemoteDataSource.fetchHomeResult().result.toDomain()
            }.onSuccess {
                Log.e("hyeon", it.toString())
            }.onFailure {
                Log.e("hyeon", it.message.toString())
            }
    }
