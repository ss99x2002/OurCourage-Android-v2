package com.example.ourcourage.android.presentation.ui.navigation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.ourcourage.android.R

sealed class BottomNavType(
    val route: String,
    @StringRes
    val resourceId: Int,
    @DrawableRes
    val icon: Int,
) {
    data object Home : BottomNavType(
        route = "home",
        resourceId = R.string.home,
        icon = R.drawable.ic_bottom_home,
    )

    data object Point : BottomNavType(
        route = "point",
        resourceId = R.string.point,
        icon = R.drawable.ic_bottom_point,
    )

    data object Scan : BottomNavType(
        route = "scan/{scanPurpose}/{useAt}",
        resourceId = R.string.camera,
        icon = R.drawable.ic_bottom_camera,
    )

    data object MyPage : BottomNavType(
        route = "myPage",
        resourceId = R.string.profile,
        icon = R.drawable.ic_bottom_my_profile,
    )
}
