package com.example.ourcourage.android.presentation.ui.navigation.type

sealed class ScreenType(val route: String) {
    data object Login : ScreenType("login")

    data object Join : ScreenType("join")

    data object MultiUseRental : ScreenType("multiUseRental")

    data object MultiUseReturn : ScreenType("multiUseReturn")

    data object ScanComplete : ScreenType("scanComplete")
}
