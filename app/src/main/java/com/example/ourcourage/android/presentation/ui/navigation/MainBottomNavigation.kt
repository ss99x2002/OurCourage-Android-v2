package com.example.ourcourage.android.presentation.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ourcourage.android.MainActivity.Companion.items
import com.example.ourcourage.android.ui.theme.PrimaryBlue
import com.example.ourcourage.android.ui.theme.StrokeGrey

@Composable
fun MainBottomNavigation(navController: NavController) {
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
                            // 시작 목적지로 팝업
                        }
                        launchSingleTop = true
                        // 백스택에 동일한 목적지 여러 복사본 쌓이는 것 방지
                        restoreState = true
                        // 해당 목적지로 다시 이동할 때 상태 복원.
                        // popUp블럭의 saveState 플래그와 함께 작용.
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
}
