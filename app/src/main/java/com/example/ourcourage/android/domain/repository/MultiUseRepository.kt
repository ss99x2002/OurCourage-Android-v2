package com.example.ourcourage.android.domain.repository

import com.example.ourcourage.android.data.model.request.MultiUseLocationRequestDto
import com.example.ourcourage.android.data.model.request.MultiUseRentalRequestDto
import com.example.ourcourage.android.domain.model.RentalDetail
import com.example.ourcourage.android.domain.model.RentalLocationInfo

interface MultiUseRepository {
    suspend fun fetchLocationByQrCode(multiUseLocationRequestDto: MultiUseLocationRequestDto): Result<RentalLocationInfo>
    suspend fun postMultiUseRental(multiUseRentalRequestDto: MultiUseRentalRequestDto) : Result<RentalDetail>
}