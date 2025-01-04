package com.example.ourcourage.android.data.interceptor

import android.content.SharedPreferences
import okhttp3.Interceptor
import com.example.ourcourage.android.data.datasource.local.UserTokenDataSource
import com.google.zxing.client.android.BuildConfig
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject
class AuthInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val token = if (UserTokenDataSource.getString(USER_TOKEN).isNullOrBlank()) {
            UserTokenDataSource.getKakaoString(USER_KAKAO_TOKEN)
        } else {
            "Bearer ${UserTokenDataSource.getString(USER_TOKEN)}"
        }

        val originalRequest = chain.request()

        val headerRequest = originalRequest.newAuthBuilder("$token")
        return chain.proceed(headerRequest)
    }

    private fun Request.newAuthBuilder(token: String): Request =
        if (BuildConfig.API_BASE_URL.contains(url.host)) {
            this.newBuilder()
                .addHeader("Authorization", token)
                .build()
        }
        else this

    companion object {
        const val USER_TOKEN = "userToken"
        const val USER_KAKAO_TOKEN = "userKakaoToken"
    }
}