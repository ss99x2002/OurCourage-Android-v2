package com.example.ourcourage.android.data.service

import com.example.ourcourage.android.data.util.Constants.ADDITIONAL_INFO
import com.example.ourcourage.android.data.util.Constants.API
import com.example.ourcourage.android.data.util.Constants.AUTH
import com.example.ourcourage.android.data.util.Constants.LOGIN
import com.example.ourcourage.android.data.util.Constants.USERS
import com.example.ourcourage.android.data.util.Constants.VERSION
import retrofit2.http.PATCH
import retrofit2.http.POST

// 사용자 인증과 관련된 API 모아둔 서비스 클래스
interface AuthService {
    @POST("$API/$VERSION/$AUTH/{socialType}/$LOGIN")
    suspend fun postSocialLoginAuth()

    @PATCH("$API/$VERSION/$USERS/$ADDITIONAL_INFO")
    suspend fun patchUserAdditionalInfo()
}
