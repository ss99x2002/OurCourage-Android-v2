package com.example.ourcourage.android

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.ourcourage.android.data.MultiUseList
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.domain.User
import com.example.ourcourage.android.presentation.ui.home.HomeScreen
import com.example.ourcourage.android.presentation.ui.join.JoinScreen
import com.example.ourcourage.android.presentation.ui.login.LoginScreen
import com.example.ourcourage.android.presentation.ui.multiuse.rental.MultiUseRentalScreen
import com.example.ourcourage.android.presentation.ui.multiuse.returns.MultiUseReturnScreen
import com.example.ourcourage.android.presentation.ui.mypage.MyPageScreen
import com.example.ourcourage.android.presentation.ui.navigation.MainBottomNavigationType
import com.example.ourcourage.android.presentation.ui.navigation.ScreenType
import com.example.ourcourage.android.presentation.ui.point.PointHistoryScreen
import com.example.ourcourage.android.presentation.ui.scan.ScanActivity
import com.example.ourcourage.android.presentation.ui.scan.ScanConfirmDialog
import com.example.ourcourage.android.presentation.ui.scan.compelete.ScanCompleteScreen
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme
import com.example.ourcourage.android.ui.theme.PrimaryBlue
import com.example.ourcourage.android.ui.theme.StrokeGrey

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OurCourageAndroidv2Theme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigation(
                            backgroundColor = Color.White,
                        ) {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentRoute = navBackStackEntry?.destination?.route

                            items.forEach { screen ->
                                NavigationBarItem(
                                    label = {
                                        Text(text = stringResource(id = screen.resourceId))
                                    },
                                    selected = currentRoute == screen.route,
                                    colors =
                                        NavigationBarItemDefaults.colors(
                                            selectedTextColor = PrimaryBlue,
                                            unselectedTextColor = StrokeGrey,
                                            selectedIconColor = PrimaryBlue,
                                            unselectedIconColor = StrokeGrey,
                                            indicatorColor = Color.White,
                                        ),
                                    onClick = {
                                        navController.navigate(screen.route) {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = ImageVector.vectorResource(screen.icon),
                                            contentDescription = screen.route,
                                        )
                                    },
                                )
                            }
                        }
                    },
                ) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = MainBottomNavigationType.Home.route,
                        modifier = Modifier.padding(innerPadding),
                    ) {
                        composable(route = MainBottomNavigationType.Home.route) {
                            HomeScreen(
                                modifier = Modifier.fillMaxSize(),
                                userName = "수밍밍이",
                                onClickMultiUseItem = { navController.navigate(ScreenType.MultiUseReturn.route) },
                            )
                        }

                        composable(route = MainBottomNavigationType.Point.route) {
                            PointHistoryScreen(
                                modifier = Modifier.fillMaxSize(),
                                multiUseList = MultiUseList.multiUseList,
                            )
                        }

                        composable(route = MainBottomNavigationType.Scan.route) {
                            var shouldLaunchScanner by remember { mutableStateOf(true) }
                            val context = LocalContext.current
                            val launcher =
                                rememberLauncherForActivityResult(
                                    contract = ActivityResultContracts.StartActivityForResult(),
                                ) { result ->
                                    if (result.resultCode == RESULT_OK) {
                                        shouldLaunchScanner = false
                                        if (!result.data!!.equals("1")) {
                                            setContent {
                                                ScanConfirmDialog(
                                                    isError = true,
                                                    modifier =
                                                        Modifier
                                                            .padding(horizontal = 24.dp),
                                                    contentText = "잘못된 QR코드가 스캔되었습니다.",
                                                    buttonText = "홈으로",
                                                    onHomeButtonClick = {
                                                        navController.navigate(MainBottomNavigationType.Home.route)
                                                    },
                                                )
                                            }
                                        } else {
                                            navController.navigate(ScreenType.MultiUseRental.route)
                                        }
                                    } else {
                                        shouldLaunchScanner = false
                                        navController.navigate(MainBottomNavigationType.Home.route)
                                    }
                                }

                            LaunchedEffect(shouldLaunchScanner) {
                                if (shouldLaunchScanner) {
                                    launcher.launch(Intent(context, ScanActivity::class.java))
                                    shouldLaunchScanner = false
                                }
                            }
                        }
                        composable(route = MainBottomNavigationType.MyPage.route) { MyPageScreen(modifier = Modifier.fillMaxSize(), user = User("수밍밍이", true)) }

                        // bottom x
                        composable(route = ScreenType.Join.route) { JoinScreen() }
                        composable(route = ScreenType.Login.route) { LoginScreen() }
                        composable(route = ScreenType.MultiUseRental.route) { MultiUseRentalScreen() }
                        composable(route = ScreenType.MultiUseReturn.route) {
                            MultiUseReturnScreen(
                                modifier = Modifier,
                                multiUse = MultiUse(multiUseContainerId = 1, locationName = "블루포트 인하대점", useAt = "2024-10-10 10:45:21", status = "대여중", userId = 1, locationImageUrl = R.drawable.img_tumbler),
                                onClickReturn = { navController.navigate(MainBottomNavigationType.Home.route) },
                            )
                        }
                        composable(route = ScreenType.ScanComplete.route) {
                            ScanCompleteScreen(
                                multiUse = MultiUse(multiUseContainerId = 1, locationName = "블루포트 인하대점", useAt = "2024-10-10 10:45:21", status = "대여중", userId = 1, locationImageUrl = R.drawable.img_tumbler),
                                onClickHomeButton = { navController.navigate(MainBottomNavigationType.Home.route) },
                            )
                        }
                    }
                }
            }
        }
    }

    companion object {
        val items: List<MainBottomNavigationType> =
            listOf(
                MainBottomNavigationType.Home,
                MainBottomNavigationType.Point,
                MainBottomNavigationType.Scan,
                MainBottomNavigationType.MyPage,
            )
    }
}
