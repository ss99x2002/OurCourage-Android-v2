package com.example.ourcourage.android.domain.usecase

import com.example.ourcourage.android.data.model.request.MultiUseLocationRequestDto
import com.example.ourcourage.android.domain.model.RentalLocationInfo
import com.example.ourcourage.android.domain.repository.MultiUseRepository
import javax.inject.Inject

class RentalLocationInfoUseCase @Inject constructor(
    private val multiUseRepository: MultiUseRepository
) {
    suspend fun invoke(locationRequestDto: MultiUseLocationRequestDto): Result<RentalLocationInfo> {
        return multiUseRepository.fetchLocationByQrCode(locationRequestDto)
    }
}