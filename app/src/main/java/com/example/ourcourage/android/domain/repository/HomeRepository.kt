package com.example.ourcourage.android.domain.repository

import com.example.ourcourage.android.domain.model.HomeUserInfo

interface HomeRepository {
    suspend fun fetchUserInfoInHome() : Result<HomeUserInfo>
}