package com.example.ourcourage.android.data.datasource.local

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.google.zxing.client.android.BuildConfig

object UserTokenDataSource {
    private lateinit var preferences: SharedPreferences
    private const val FILE_NAME = "OurCourageLocalDataSource"

    fun init(context: Context) {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        preferences =
            if (BuildConfig.DEBUG) {
                context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
            } else {
                EncryptedSharedPreferences.create(
                    FILE_NAME,
                    masterKeyAlias,
                    context,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
                )
            }
    }

    fun setKakaoString(
        key: String,
        value: String?,
    ) {
        preferences.edit { putString(key, value) }
    }

    fun getKakaoString(key: String): String? {
        return preferences.getString(key, null)
    }

    fun setString(
        key: String,
        value: String?,
    ) {
        preferences.edit { putString(key, value) }
    }

    fun getString(key: String): String? {
        return preferences.getString(key, null)
    }

    private fun clear() {
        preferences.edit { clear() }
    }
}
