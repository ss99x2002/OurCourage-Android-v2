package com.example.ourcourage.android.presentation.ui.scan.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.presentation.ui.navigation.type.ScreenType
import com.example.ourcourage.android.presentation.ui.scan.compelete.ScanCompleteScreen

fun NavGraphBuilder.scanCompleteGraph(
    navigateHome: () -> Unit,
) {
    composable(
        route = ScreenType.ScanComplete.route,
    ) {
        ScanCompleteScreen(
            multiUse =
                MultiUse(
                    multiUseContainerId = 1,
                    locationName = "블루포트 공덕역점",
                    useAt = "2024-10-10 10:45:21",
                    status = "대여중",
                    userId = 1,
                    locationImageUrl = R.drawable.img_tumbler,
                ),
            onClickHomeButton = navigateHome,
        )
    }
}

fun NavHostController.navigateScanComplete() {
    navigate(
        route = ScreenType.ScanComplete.route,
    )
}
