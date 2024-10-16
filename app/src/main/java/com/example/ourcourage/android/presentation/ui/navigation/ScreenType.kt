package com.example.ourcourage.android.presentation.ui.navigation

sealed class ScreenType(val route: String) {
    object Login : ScreenType("login")
    object Join : ScreenType("join")
    object MultiUseRental : ScreenType("multiUseRental")
    object MultiUseReturn : ScreenType("multiUseReturn")
    object QrCodeScan : ScreenType("qrCodeScan")
    object ScanComplete : ScreenType("scanComplete")
}