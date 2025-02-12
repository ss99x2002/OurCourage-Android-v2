package com.example.ourcourage.android.data.repository

import com.example.ourcourage.android.data.datasource.remote.MultiUseRemoteDataSource
import com.example.ourcourage.android.data.mapper.todomain.toDomain
import com.example.ourcourage.android.data.model.request.MultiUseLocationRequestDto
import com.example.ourcourage.android.data.model.request.MultiUseRentalRequestDto
import com.example.ourcourage.android.domain.model.RentalDetail
import com.example.ourcourage.android.domain.model.RentalLocationInfo
import com.example.ourcourage.android.domain.model.ReturnDetail
import com.example.ourcourage.android.domain.model.ReturnMultiUse
import com.example.ourcourage.android.domain.repository.MultiUseRepository
import javax.inject.Inject

class MultiUseRepositoryImpl @Inject constructor(
    private val multiUseRemoteDataSource: MultiUseRemoteDataSource
) : MultiUseRepository {
    override suspend fun fetchLocationByQrCode(multiUseLocationRequestDto: MultiUseLocationRequestDto): Result<RentalLocationInfo> {
        return runCatching {
            multiUseRemoteDataSource.fetchLocationByQRCode(multiUseLocationRequestDto).result.toDomain()
        }
    }

    override suspend fun postMultiUseRental(multiUseRentalRequestDto: MultiUseRentalRequestDto): Result<RentalDetail> {
        return runCatching {
            multiUseRemoteDataSource.postMultiUseRental(multiUseRentalRequestDto).result.toDomain()
        }
    }

    override suspend fun fetchMultiUseDetail(useAt: String): Result<ReturnDetail> {
        return runCatching {
            multiUseRemoteDataSource.fetchMultiUseDetail(useAt).result.toDomain()
        }
    }

    override suspend fun patchMultiUseReturn(useAt: String, returnLocationId : Int): Result<ReturnMultiUse> {
        return runCatching {
            multiUseRemoteDataSource.patchMultiUseReturn(useAt,returnLocationId).result.toDomain()
        }
    }
}