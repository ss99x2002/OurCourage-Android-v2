package com.example.ourcourage.android.presentation.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.ourcourage.android.R
import com.example.ourcourage.android.presentation.ui.navigation.Screen.Home.icon

sealed class Screen(
    val route: String,
    @StringRes
    val resourceId: Int,
    @DrawableRes
    val icon: Int,
) {
    data object Home : Screen(
        route = "home",
        resourceId = R.string.home,
        icon = R.drawable.ic_bottom_home
    )

    data object Point : Screen(
        route = "point",
        resourceId = R.string.point,
        icon = R.drawable.ic_bottom_point
    )


    data object Camera : Screen(
        route = "camera",
        resourceId = R.string.camera,
        icon = R.drawable.ic_bottom_camera
    )

    data object Profile : Screen(
        route = "profile",
        resourceId = R.string.profile,
        icon = R.drawable.ic_bottom_my_profile
    )
}