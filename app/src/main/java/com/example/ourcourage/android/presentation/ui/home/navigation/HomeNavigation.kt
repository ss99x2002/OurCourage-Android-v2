package com.example.ourcourage.android.presentation.ui.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.ourcourage.android.presentation.ui.home.HomeScreen
import com.example.ourcourage.android.presentation.ui.navigation.type.BottomNavType

fun NavGraphBuilder.homeGraph(
    navigateReturn: (String) -> Unit,
) {
    composable(
        route = BottomNavType.Home.route,
    ) { navBackStackEntry ->
        HomeScreen(
            onClickMultiUseItem = { useAt ->
                navigateReturn(useAt)
            },
        )
    }
}

fun NavHostController.navigateHome() {
    navigate(
        route = BottomNavType.Home.route,
    )
}
