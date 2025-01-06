package com.example.ourcourage.android.presentation.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.ourcourage.android.presentation.ui.home.navigation.homeGraph
import com.example.ourcourage.android.presentation.ui.home.navigation.navigateHome
import com.example.ourcourage.android.presentation.ui.multiuse.navigation.navigateRental
import com.example.ourcourage.android.presentation.ui.multiuse.navigation.navigateReturn
import com.example.ourcourage.android.presentation.ui.multiuse.navigation.rentalGraph
import com.example.ourcourage.android.presentation.ui.multiuse.navigation.returnGraph
import com.example.ourcourage.android.presentation.ui.mypage.navigation.myPageGraph
import com.example.ourcourage.android.presentation.ui.navigation.type.BottomNavType
import com.example.ourcourage.android.presentation.ui.point.navigation.pointGraph
import com.example.ourcourage.android.presentation.ui.scan.navigation.navigateScan
import com.example.ourcourage.android.presentation.ui.scan.navigation.navigateScanComplete
import com.example.ourcourage.android.presentation.ui.scan.navigation.scanCompleteGraph
import com.example.ourcourage.android.presentation.ui.scan.navigation.scanGraph
import com.example.ourcourage.android.presentation.ui.scan.type.ScanPurpose

@Composable
fun MainNavigator(
    navController: NavHostController,
    innerPadding: PaddingValues,
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavType.Home.route,
        modifier = Modifier.padding(innerPadding),
    ) {
        homeGraph(navigateReturn = { useAt -> navController.navigateReturn(useAt) })
        pointGraph()
        myPageGraph()
        rentalGraph(navigateScanCompleted = { type, response -> navController.navigateScanComplete(type = type, response = response) })
        returnGraph(
            navigateHome = { navController.navigateHome() },
            navigateScan = { navController.navigateScan(ScanPurpose.RETURN) },
        )
        scanCompleteGraph(navigateHome = { navController.navigateHome() })
        scanGraph(
            navigateRental = { locationInfo -> navController.navigateRental(locationInfo) },
            navigateScanCompleted = { type, response ->  navController.navigateScanComplete(type = type, response = response) },
        )
    }
}
