package com.example.ourcourage.android.data.service

import com.example.ourcourage.android.data.util.Constants.API
import com.example.ourcourage.android.data.util.Constants.LOCATION
import com.example.ourcourage.android.data.util.Constants.USES
import com.example.ourcourage.android.data.util.Constants.VERSION
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

// 다회용기 조회 / 대여 / 반납 서비스
interface MultiUseService {


    @GET("$API/$VERSION/$USES/$LOCATION")
    suspend fun fetchLocationByQRCode()

    @POST("$API/$VERSION/$USES")
    suspend fun postMultiUseRental()

    @GET("$API/$VERSION/$USES/{useAt}")
    suspend fun fetchMultiUseDetail(@Path ("useAt") useAt : String)

    @PATCH("$API/$VERSION/$USES/{useAt}")
    suspend fun patchMultiUseReturn(@Path ("useAt") useAt : String)

}