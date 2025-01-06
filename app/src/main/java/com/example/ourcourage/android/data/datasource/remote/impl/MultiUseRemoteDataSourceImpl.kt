package com.example.ourcourage.android.data.datasource.remote.impl

import com.example.ourcourage.android.data.datasource.remote.MultiUseRemoteDataSource
import com.example.ourcourage.android.data.model.request.MultiUseLocationRequestDto
import com.example.ourcourage.android.data.model.request.MultiUseRentalRequestDto
import com.example.ourcourage.android.data.model.response.MultiUseLocationResponseDto
import com.example.ourcourage.android.data.model.response.MultiUseRentalResponseDto
import com.example.ourcourage.android.data.model.response.MultiUseReturnDetailResponseDto
import com.example.ourcourage.android.data.model.response.MultiUseReturnResponseDto
import com.example.ourcourage.android.data.service.MultiUseService
import javax.inject.Inject

class MultiUseRemoteDataSourceImpl @Inject constructor(
    private val multiUseService: MultiUseService
) : MultiUseRemoteDataSource {
    override suspend fun fetchLocationByQRCode(multiUseLocationRequestDto: MultiUseLocationRequestDto): MultiUseLocationResponseDto {
        return multiUseService.fetchLocationByQRCode(
            multiUseLocationRequestDto.locationId,
            multiUseLocationRequestDto.point
        )
    }

    override suspend fun postMultiUseRental(multiUseRentalRequestDto: MultiUseRentalRequestDto): MultiUseRentalResponseDto {
        return multiUseService.postMultiUseRental(
            multiUseRentalRequestDto
        )
    }

    override suspend fun fetchMultiUseDetail(useAt: String): MultiUseReturnDetailResponseDto {
        return multiUseService.fetchMultiUseDetail(useAt)
    }

    override suspend fun patchMultiUseReturn(useAt: String, returnLocationId : Int): MultiUseReturnResponseDto {
        return multiUseService.patchMultiUseReturn(useAt,returnLocationId)
    }
}