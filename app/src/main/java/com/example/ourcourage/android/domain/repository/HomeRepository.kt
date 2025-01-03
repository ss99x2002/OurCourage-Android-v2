package com.example.ourcourage.android.domain.repository

import com.example.ourcourage.android.domain.model.RentalMultiUse
import com.example.ourcourage.android.domain.model.UserInfo

interface HomeRepository {
    suspend fun fetchUserInfoInHome() : Result<UserInfo>
}