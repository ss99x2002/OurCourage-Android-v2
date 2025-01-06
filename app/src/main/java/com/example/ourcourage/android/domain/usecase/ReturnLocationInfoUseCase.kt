package com.example.ourcourage.android.domain.usecase

import com.example.ourcourage.android.domain.model.ReturnDetail
import com.example.ourcourage.android.domain.model.ReturnLocationInfo
import com.example.ourcourage.android.domain.repository.MultiUseRepository
import javax.inject.Inject

class ReturnLocationInfoUseCase @Inject constructor(
    private val multiUseRepository: MultiUseRepository){

    suspend fun invoke(useAt : String) : Result<ReturnDetail> {
        return multiUseRepository.fetchMultiUseDetail(useAt)
    }
}