package com.example.ourcourage.android.presentation.ui.scan.navigation

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ourcourage.android.R
import com.example.ourcourage.android.data.model.request.MultiUseLocationRequestDto
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.domain.mapper.toDto
import com.example.ourcourage.android.domain.mapper.toJson
import com.example.ourcourage.android.domain.mapper.toScanComplete
import com.example.ourcourage.android.domain.model.RentalDetail
import com.example.ourcourage.android.domain.model.RentalLocationInfo
import com.example.ourcourage.android.domain.model.RentalMultiUse
import com.example.ourcourage.android.domain.model.ReturnDetail
import com.example.ourcourage.android.presentation.ui.navigation.type.BottomNavType
import com.example.ourcourage.android.presentation.ui.navigation.type.ScreenType
import com.example.ourcourage.android.presentation.ui.scan.QrCodeScanScreen
import com.example.ourcourage.android.presentation.ui.scan.ScanViewModel
import com.example.ourcourage.android.presentation.ui.scan.compelete.ScanCompleteScreen
import com.example.ourcourage.android.presentation.ui.scan.type.ScanPurpose
import com.example.ourcourage.android.util.base.UiState
import com.google.zxing.client.android.Intents.Scan
import java.net.URLEncoder

fun NavGraphBuilder.scanGraph(
    navigateRental: (RentalLocationInfo) -> Unit,
    navigateScanCompleted: (String,Any) -> Unit,
) {
    composable(
        route = BottomNavType.Scan.route,
        arguments =
        listOf(
            navArgument("scanPurpose") {
                type = NavType.StringType
            }
        ),
    ) { backStackEntry ->

        val viewModel: ScanViewModel = hiltViewModel()
        val scanPurpose = getScanPurposeArg(backStackEntry)
        val scanUiState by viewModel.scanUiState.collectAsState()

        QrCodeScanScreen(
            modifier = Modifier.fillMaxSize(),
            onSuccessQrScan = { qrCodeResult ->
                viewModel.scanQrCodeResult(qrCodeResult, scanPurpose)
            },
        )

        navigateScanPurposeRental(
            scanUiState = scanUiState,
            scanPurpose = scanPurpose,
            navigateRental = navigateRental,
        )
    }
}

fun getScanPurposeArg(backStackEntry: NavBackStackEntry): ScanPurpose {
    val scanPurposeArg = backStackEntry.arguments?.getString("scanPurpose")
    return when (scanPurposeArg) {
        "RETURN" -> ScanPurpose.RETURN
        else -> ScanPurpose.RENTAL
    }
}


@Composable
private fun navigateScanPurposeRental(
    scanUiState: UiState<RentalLocationInfo>,
    scanPurpose: ScanPurpose,
    navigateRental: (RentalLocationInfo) -> Unit,
) {
    when (scanUiState) {
        is UiState.Success -> {
            if (scanPurpose == ScanPurpose.RENTAL) {
                scanUiState.data?.let {
                    navigateRental(it)
                }
            }
        }

        is UiState.Failure -> {
            val errorMessage = scanUiState.message
            Toast.makeText(LocalContext.current, errorMessage, Toast.LENGTH_SHORT).show()
        }

        else -> Unit
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
        route = ScreenType.ScanComplete.route + "/{type}/{response}",
        arguments = listOf(
            navArgument("type") { type = NavType.StringType },
            navArgument("response") { type = NavType.StringType }
        )
    ) { backStackEntry ->
        val response = backStackEntry.arguments?.getString("response")
        val type = backStackEntry.arguments?.getString("type")

        val responseToPass = if (type ==  "RENTAL") {
            response?.toDto<RentalDetail>()?.toScanComplete()
        } else {
            response?.toDto<ReturnDetail>()?.toScanComplete()
        }
        ScanCompleteScreen(
            content = responseToPass!!,
            onClickHomeButton = navigateHome,
            isReturn = type == "RETURN",
            topTitleText = if(type == "RETURN") "인증 완료" else "대여 완료"
        )
    }
}

fun NavHostController.navigateScanComplete(
    type: String,
    response : Any,
) {
    val encodedJson = URLEncoder.encode(response.toJson(), "UTF-8")
    navigate(
        route = ScreenType.ScanComplete.route + "/$type/${encodedJson}",
    ) {
        popUpTo(graph.findStartDestination().id) {
            inclusive = false
            // 시작 목적지 스택에 남겨두고, 그 위에 있는 모든 목적지는 제거.
            // 즉 특 정화면 -> 다른 화면 이동 시, 이전 화면들을 제거하고 시작 화면만 남기고 싶을 때 사용.
        }
    }
}
