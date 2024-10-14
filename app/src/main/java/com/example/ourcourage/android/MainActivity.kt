package com.example.ourcourage.android

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.imageLoader
import com.example.ourcourage.android.domain.User
import com.example.ourcourage.android.presentation.ui.home.HomeScreen
import com.example.ourcourage.android.presentation.ui.mypage.MyPageScreen
import com.example.ourcourage.android.presentation.ui.navigation.Screen
import com.example.ourcourage.android.presentation.ui.point.PointHistoryScreen
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme
import com.example.ourcourage.android.ui.theme.PrimaryBlue
import com.example.ourcourage.android.ui.theme.StrokeGrey

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OurCourageAndroidv2Theme {
                val items: List<Screen> = listOf(
                    Screen.Home,
                    Screen.Point,
                    Screen.Camera,
                    Screen.Profile
                )

                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize(),
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
                                    colors = NavigationBarItemDefaults.colors(
                                        selectedTextColor = PrimaryBlue,
                                        unselectedTextColor = StrokeGrey,
                                        selectedIconColor = PrimaryBlue,
                                        unselectedIconColor = StrokeGrey,
                                        indicatorColor = Color.White
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
                                            contentDescription = screen.route
                                        )
                                    }
                                )
                            }

                        }
                    }) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {

                        composable(route = Screen.Home.route) { HomeScreen(modifier = Modifier.fillMaxSize(), userName = "수밍밍이") }
                        composable(route = Screen.Point.route) { PointHistoryScreen(modifier = Modifier.fillMaxSize(), multiUseList = MultiUseList.multiUseList) }
                        composable(route = Screen.Camera.route) { }
                        composable(route = Screen.Profile.route) { MyPageScreen(modifier = Modifier.fillMaxSize(), user = User("수밍밍이", true)) }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OurCourageAndroidv2Theme {
        Greeting("Android")
    }
}
