package com.example.ourcourage.android.domain.mapper

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

inline fun <reified T> T.toJson(): String? {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory()) // Kotlin 지원 어댑터 추가
        .build()
    val adapter = moshi.adapter(T::class.java) // T 타입의 어댑터 생성
    return try {
        adapter.toJson(this) // 객체를 JSON 문자열로 변환
    } catch (e: Exception) {
        e.printStackTrace() // 예외 처리
        null // 변환 실패 시 null 반환
    }
}

inline fun <reified T> String.toDto(): T? {
    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
    val adapter = moshi.adapter(T::class.java)
    return try {
        adapter.fromJson(this)
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}