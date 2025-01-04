package com.example.ourcourage.android.util

import android.util.Log
import retrofit2.HttpException

fun Throwable.handleApiError(tag: String = "Error") {
    if (this is HttpException) {
        val errorBody = this.response()?.errorBody()?.string()
        Log.e(tag, "HTTP 연결 실패: $errorBody")
    }
    Log.e(tag, "실패: ${this.message}")
}
