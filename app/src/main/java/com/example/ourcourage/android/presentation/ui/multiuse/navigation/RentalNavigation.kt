package com.example.ourcourage.android.presentation.ui.multiuse.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.ourcourage.android.presentation.ui.multiuse.rental.MultiUseRentalScreen
import com.example.ourcourage.android.presentation.ui.navigation.type.ScreenType

fun NavGraphBuilder.rentalGraph(
    navigateHome: () -> Unit,
) {
    composable(
        route = ScreenType.MultiUseRental.route,
    ) {
        MultiUseRentalScreen()
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
