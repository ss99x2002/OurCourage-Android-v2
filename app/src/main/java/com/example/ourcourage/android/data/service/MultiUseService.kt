package com.example.ourcourage.android.data.service

import com.example.ourcourage.android.data.model.request.MultiUseRentalRequestDto
import com.example.ourcourage.android.data.model.response.MultiUseLocationResponseDto
import com.example.ourcourage.android.data.model.response.MultiUseRentalResponseDto
import com.example.ourcourage.android.data.util.Constants.API
import com.example.ourcourage.android.data.util.Constants.LOCATION
import com.example.ourcourage.android.data.util.Constants.USES
import com.example.ourcourage.android.data.util.Constants.VERSION
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MultiUseService {

    @GET("$API/$VERSION/$USES/$LOCATION")
    suspend fun fetchLocationByQRCode(
        @Query("locationId") locationId: Int,
        @Query("point") point: Int
    ): MultiUseLocationResponseDto

    @POST("$API/$VERSION/$USES")
    suspend fun postMultiUseRental(
        @Body multiUseRentalRequestDto: MultiUseRentalRequestDto
    ): MultiUseRentalResponseDto

    @GET("$API/$VERSION/$USES/{useAt}")
    suspend fun fetchMultiUseDetail(
        @Path("useAt") useAt: String,
    )

    @PATCH("$API/$VERSION/$USES/{useAt}")
    suspend fun patchMultiUseReturn(
        @Path("useAt") useAt: String,
    )
}

// 다회용기 조회 / 대여 / 반납 서비스
// 응집성을 위해 다회용기 관련 API를 한 서비스에 모아둠.