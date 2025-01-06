package com.example.ourcourage.android.presentation.ui.multiuse.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.ourcourage.android.presentation.ui.multiuse.returns.MultiUseReturnScreen
import com.example.ourcourage.android.presentation.ui.navigation.type.ScreenType

fun NavGraphBuilder.returnGraph(
    navigateScan: (String,String) -> Unit,
) {
    composable(
        route = ScreenType.MultiUseReturn.route + "/{useAt}",
        arguments = listOf(
            navArgument("useAt") {
                type = NavType.StringType
            }
        )
    ) {
        MultiUseReturnScreen(
            useAt = it.arguments?.getString("useAt") ?: "",
            onClickReturn = navigateScan,
        )
    }
}

fun NavHostController.navigateReturn(useAt: String) {
    navigate(
        route = ScreenType.MultiUseReturn.route + "/$useAt",
    ) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
    }
}
