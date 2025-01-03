package com.example.ourcourage.android.data.service

import com.example.ourcourage.android.data.util.Constants.API
import com.example.ourcourage.android.data.util.Constants.EDIT
import com.example.ourcourage.android.data.util.Constants.MY_PAGE
import com.example.ourcourage.android.data.util.Constants.USERS
import com.example.ourcourage.android.data.util.Constants.VERSION
import retrofit2.http.GET
import retrofit2.http.PATCH

interface MyPageService {

    @GET("$API/$VERSION/$USERS$MY_PAGE")
    suspend fun fetchUserInfoInMyPage()

    @PATCH("$API/$VERSION/$USERS/$MY_PAGE/$EDIT")
    suspend fun patchUserInfoInMyPage() // 회원 정보 수정
}