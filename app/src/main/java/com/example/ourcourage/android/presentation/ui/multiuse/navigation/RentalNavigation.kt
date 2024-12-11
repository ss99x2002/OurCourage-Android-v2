package com.example.ourcourage.android.presentation.ui.multiuse.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.ourcourage.android.presentation.ui.multiuse.rental.MultiUseRentalScreen
import com.example.ourcourage.android.presentation.ui.navigation.type.ScreenType

fun NavGraphBuilder.rentalGraph(
    navigateScanCompleted: () -> Unit,
) {
    composable(
        route = ScreenType.MultiUseRental.route,
    ) {
        MultiUseRentalScreen(
            modifier = Modifier.fillMaxSize(),
            onClickRental = navigateScanCompleted,
        )
    }
}

fun NavHostController.navigateRental() {
    navigate(
        route = ScreenType.MultiUseRental.route,
    ) {
        popUpTo(graph.findStartDestination().id) {
            inclusive = false
        }
    }
}
