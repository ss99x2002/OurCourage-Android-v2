package com.example.ourcourage.android.domain.repository

import com.example.ourcourage.android.data.model.request.MultiUseLocationRequestDto
import com.example.ourcourage.android.data.model.request.MultiUseRentalRequestDto
import com.example.ourcourage.android.domain.model.RentalDetail
import com.example.ourcourage.android.domain.model.RentalLocationInfo
import com.example.ourcourage.android.domain.model.ReturnDetail
import com.example.ourcourage.android.domain.model.ReturnMultiUse

interface MultiUseRepository {
    suspend fun fetchLocationByQrCode(multiUseLocationRequestDto: MultiUseLocationRequestDto): Result<RentalLocationInfo>
    suspend fun postMultiUseRental(multiUseRentalRequestDto: MultiUseRentalRequestDto): Result<RentalDetail>
    suspend fun fetchMultiUseDetail(useAt: String): Result<ReturnDetail>
    suspend fun patchMultiUseReturn(useAt: String, returnLocationId : Int): Result<ReturnMultiUse>
}