package com.example.ourcourage.android.data.service

import com.example.ourcourage.android.data.util.Constants.API
import com.example.ourcourage.android.data.util.Constants.POINT
import com.example.ourcourage.android.data.util.Constants.VERSION
import retrofit2.http.GET

interface PointService {
    @GET("$API/$VERSION/$POINT")
    suspend fun fetchUserPointHistory()
}