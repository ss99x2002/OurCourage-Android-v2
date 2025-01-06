package com.example.ourcourage.android.presentation.ui.multiuse.navigation

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ourcourage.android.domain.mapper.toDto
import com.example.ourcourage.android.domain.model.RentalDetail
import com.example.ourcourage.android.domain.model.RentalLocationInfo
import com.example.ourcourage.android.domain.model.toJson
import com.example.ourcourage.android.presentation.ui.multiuse.rental.RentalViewModel
import com.example.ourcourage.android.presentation.ui.multiuse.rental.MultiUseRentalScreen
import com.example.ourcourage.android.presentation.ui.navigation.type.ScreenType
import com.example.ourcourage.android.util.base.UiState
import java.net.URLEncoder

fun NavGraphBuilder.rentalGraph(
    navigateScanCompleted: (String, Any) -> Unit,
) {
    composable(
        route = ScreenType.MultiUseRental.route + "/{rentalLocationInfo}",
        arguments = listOf(
            navArgument("rentalLocationInfo") {
                type = NavType.StringType // Parcelable 타입 지정
            }
        )
    ) { backStackEntry ->

        val rentalLocationInfo = backStackEntry.arguments?.getString("rentalLocationInfo")?.toDto<RentalLocationInfo>()
        val viewModel: RentalViewModel = hiltViewModel()
        val rentalUiState by viewModel.rentalUiState.collectAsState()

        rentalLocationInfo?.let {
            MultiUseRentalScreen(
                modifier = Modifier.fillMaxSize(),
                onClickRental = { rentalMultiUseRequest ->
                    Log.e("hyeon",rentalMultiUseRequest.toString())
                    viewModel.rentalMultiUse(rentalMultiUseRequest)
                },
                locationInfo = it //rentalLocationInfo 사용
            )
        } ?: run {
            // rentalLocationInfo가 null일 경우 처리할 코드
            Toast.makeText(LocalContext.current, "위치 정보가 없습니다.", Toast.LENGTH_SHORT).show()
        }

        navigateCompletedPurposeRental(
            rentalUiState = rentalUiState,
            navigatePurpose = "RENTAL",
            navigateScanCompleted = navigateScanCompleted
        )
    }
}

@Composable
private fun navigateCompletedPurposeRental(
    rentalUiState: UiState<RentalDetail>,
    navigatePurpose: String,
    navigateScanCompleted: (String, Any) -> Unit
) {
    when (rentalUiState) {
        is UiState.Success -> {
            if (navigatePurpose == "RENTAL") {
                rentalUiState.data?.let {
                    navigateScanCompleted("RENTAL", it)
                }
            }
        }

        is UiState.Failure -> {
            val errorMessage = rentalUiState.message
            Toast.makeText(LocalContext.current, errorMessage, Toast.LENGTH_SHORT).show()
        }

        else -> Unit
    }
}


fun NavHostController.navigateRental(locationInfo: RentalLocationInfo) {
    val encodedJson = URLEncoder.encode(locationInfo.toJson(), "UTF-8")
    navigate(
        route = ScreenType.MultiUseRental.route + "/${encodedJson}" // 추가 인자 경로를 route에 포함
    ) {
        // 필요한 경우 popUpTo 설정
        popUpTo(graph.findStartDestination().id) {
            inclusive = false
        }
    }
}
