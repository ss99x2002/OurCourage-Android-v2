package com.example.ourcourage.android.presentation.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.ourcourage.android.R

sealed class MainBottomNavigationType(
    val route: String,
    @StringRes
    val resourceId: Int,
    @DrawableRes
    val icon: Int,
) {
    data object Home : MainBottomNavigationType(
        route = "home",
        resourceId = R.string.home,
        icon = R.drawable.ic_bottom_home,
    )

    data object Point : MainBottomNavigationType(
        route = "point",
        resourceId = R.string.point,
        icon = R.drawable.ic_bottom_point,
    )

    data object Camera : MainBottomNavigationType(
        route = "camera",
        resourceId = R.string.camera,
        icon = R.drawable.ic_bottom_camera,
    )

    data object Profile : MainBottomNavigationType(
        route = "profile",
        resourceId = R.string.profile,
        icon = R.drawable.ic_bottom_my_profile,
    )
}
