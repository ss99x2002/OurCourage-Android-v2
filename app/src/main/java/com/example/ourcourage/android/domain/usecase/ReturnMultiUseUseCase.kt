package com.example.ourcourage.android.domain.usecase

import com.example.ourcourage.android.domain.model.ReturnMultiUse
import com.example.ourcourage.android.domain.repository.MultiUseRepository
import javax.inject.Inject

class ReturnMultiUseUseCase @Inject constructor(
    private val multiUseRepository: MultiUseRepository
) {
    suspend fun invoke(useAt: String, returnLocationId : Int) : Result<ReturnMultiUse> {
       return  multiUseRepository.patchMultiUseReturn(useAt,returnLocationId)
    }
}