package com.example.ourcourage.android.presentation.ui.scan.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.presentation.ui.navigation.type.BottomNavType
import com.example.ourcourage.android.presentation.ui.navigation.type.ScreenType
import com.example.ourcourage.android.presentation.ui.scan.QrCodeScanScreen
import com.example.ourcourage.android.presentation.ui.scan.compelete.ScanCompleteScreen
import com.example.ourcourage.android.presentation.ui.scan.type.ScanPurpose

fun NavGraphBuilder.scanGraph(
    navigateRental: () -> Unit,
    navigateScanCompleted: () -> Unit,
) {
    composable(
        route = BottomNavType.Scan.route,
        arguments =
            listOf(
                navArgument("scanPurpose") {
                    type =
                        NavType.StringType
                },
            ),
    ) { backStackEntry ->
        val scanPurposeArg = backStackEntry.arguments?.getString("scanPurpose")
        val scanPurpose =
            when (scanPurposeArg) {
                "RETURN" -> ScanPurpose.RETURN
                else -> ScanPurpose.RENTAL
            }
        QrCodeScanScreen(
            modifier = Modifier.fillMaxSize(),
            onSuccessQrScan =
                when (scanPurpose) {
                    ScanPurpose.RENTAL -> navigateRental
                    ScanPurpose.RETURN -> navigateScanCompleted
                },
        )
    }
}

fun NavHostController.navigateScan(scanPurpose: ScanPurpose) {
    navigate(
        route = BottomNavType.Scan.route.replace("{scanPurpose}", scanPurpose.name),
    )
}

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
    ) {
        popUpTo(graph.findStartDestination().id) {
            inclusive = false // 시작 목적지 스택에 남겨두고, 그 위에 있는 모든 목적지는 제거.
            // 즉 특 정화면 -> 다른 화면 이동 시, 이전 화면들을 제거하고 시작 화면만 남기고 싶을 때 사용.
        }
    }
}
