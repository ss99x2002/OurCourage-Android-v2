package com.example.ourcourage.android.presentation.ui.multiuse.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.presentation.ui.multiuse.returns.MultiUseReturnScreen
import com.example.ourcourage.android.presentation.ui.navigation.type.ScreenType

fun NavGraphBuilder.returnGraph(
    navigateScan: () -> Unit,
    navigateHome: () -> Unit,
) {
    composable(
        route = ScreenType.MultiUseReturn.route,
    ) {
        MultiUseReturnScreen(
            multiUse =
                MultiUse(
                    multiUseContainerId = 1,
                    locationName = "블루포트 공덕역점",
                    useAt = "2024-10-10 10:45:21",
                    status = "대여중",
                    userId = 1,
                    locationImageUrl = R.drawable.img_tumbler,
                ),
            onClickReturn = navigateScan,
            // 스캔 activity 이동 navigate
            onHomeButtonClick = navigateHome,
        )
    }
}

fun NavHostController.navigateReturn() {
    navigate(
        route = ScreenType.MultiUseReturn.route,
    ) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
    }
}
