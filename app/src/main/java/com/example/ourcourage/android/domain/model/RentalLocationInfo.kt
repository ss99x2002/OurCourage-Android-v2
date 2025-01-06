package com.example.ourcourage.android.domain.model

import android.os.Parcelable
import com.example.ourcourage.android.presentation.type.MultiUseType
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.parcelize.Parcelize

@Parcelize
data class RentalLocationInfo(
    val locationId: Long,
    val locationName: String,
    val locationAddress: String,
    val locationImageUrl: String,
    val latitude: Double,
    val longitude: Double,
    val point: Long,
    val multiUseContainerIds: List<Long>,
) : Parcelable {
    val availableMultiUseType : List<MultiUseType>
        get() = MultiUseType.fromIdList(multiUseContainerIds)
}

fun RentalLocationInfo.toJson(): String {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val jsonAdapter = moshi.adapter(RentalLocationInfo::class.java)
    return jsonAdapter.toJson(this)
}