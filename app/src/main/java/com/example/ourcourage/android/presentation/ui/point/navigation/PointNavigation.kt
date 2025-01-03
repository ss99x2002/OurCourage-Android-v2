package com.example.ourcourage.android.presentation.ui.point.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.ourcourage.android.data.datasource.local.MultiUseList
import com.example.ourcourage.android.presentation.ui.navigation.type.BottomNavType
import com.example.ourcourage.android.presentation.ui.point.PointHistoryScreen

fun NavGraphBuilder.pointGraph() {
    composable(
        route = BottomNavType.Point.route,
    ) {
        PointHistoryScreen(
            multiUseList = MultiUseList.multiUseList,
        )
    }
}

fun NavHostController.navigatePoint() {
    navigate(
        route = BottomNavType.Point.route,
    )
}
