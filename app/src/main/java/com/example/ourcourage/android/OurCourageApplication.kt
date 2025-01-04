package com.example.ourcourage.android

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class OurCourageApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setKakao()
        stopDarkMode()
    }

    private fun setKakao() {
        // 카카오 sdk 설정
    }

    private fun stopDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}
