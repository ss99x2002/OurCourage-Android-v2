package com.example.ourcourage.android.data.service

import com.example.ourcourage.android.data.model.response.PointResponseDto
import com.example.ourcourage.android.data.util.Constants.API
import com.example.ourcourage.android.data.util.Constants.POINT
import com.example.ourcourage.android.data.util.Constants.VERSION
import retrofit2.http.GET
import retrofit2.http.Query

interface PointService {
    @GET("$API/$VERSION/$POINT")
    suspend fun fetchPointHistory(
        @Query("page") page: Int,
        @Query("size") size: Int
    ): PointResponseDto
}