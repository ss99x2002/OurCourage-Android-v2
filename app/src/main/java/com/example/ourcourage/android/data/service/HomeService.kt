package com.example.ourcourage.android.data.service

import com.example.ourcourage.android.data.model.response.HomeResponseDto
import com.example.ourcourage.android.data.util.Constants.API
import com.example.ourcourage.android.data.util.Constants.USES
import com.example.ourcourage.android.data.util.Constants.VERSION
import retrofit2.http.GET

interface HomeService {
    @GET("/$API/$VERSION/$USES")
    suspend fun fetchHomeResult(): HomeResponseDto
}
