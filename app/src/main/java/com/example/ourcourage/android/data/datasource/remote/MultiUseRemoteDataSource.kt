package com.example.ourcourage.android.data.datasource.remote

import com.example.ourcourage.android.data.model.request.MultiUseLocationRequestDto
import com.example.ourcourage.android.data.model.request.MultiUseRentalRequestDto
import com.example.ourcourage.android.data.model.response.MultiUseLocationResponseDto
import com.example.ourcourage.android.data.model.response.MultiUseRentalResponseDto
import com.example.ourcourage.android.data.model.response.MultiUseReturnDetailResponseDto
import com.example.ourcourage.android.data.model.response.MultiUseReturnResponseDto

interface MultiUseRemoteDataSource {
    suspend fun fetchLocationByQRCode(multiUseLocationRequestDto: MultiUseLocationRequestDto): MultiUseLocationResponseDto
    suspend fun postMultiUseRental(multiUseRentalRequestDto: MultiUseRentalRequestDto): MultiUseRentalResponseDto
    suspend fun fetchMultiUseDetail(useAt: String): MultiUseReturnDetailResponseDto
    suspend fun patchMultiUseReturn(useAt: String, returnLocationId : Int): MultiUseReturnResponseDto
}
