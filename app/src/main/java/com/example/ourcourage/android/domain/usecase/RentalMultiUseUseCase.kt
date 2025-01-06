package com.example.ourcourage.android.domain.usecase

import com.example.ourcourage.android.data.model.request.MultiUseRentalRequestDto
import com.example.ourcourage.android.domain.model.RentalDetail
import com.example.ourcourage.android.domain.repository.MultiUseRepository
import javax.inject.Inject

class RentalMultiUseUseCase @Inject constructor(
    private val multiUseRepository: MultiUseRepository
) {
    suspend fun invoke(multiUseRentalRequestDto: MultiUseRentalRequestDto): Result<RentalDetail> {
        return multiUseRepository.postMultiUseRental(multiUseRentalRequestDto)
    }
}