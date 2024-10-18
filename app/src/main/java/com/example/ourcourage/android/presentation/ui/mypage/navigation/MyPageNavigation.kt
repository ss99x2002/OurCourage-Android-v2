package com.example.ourcourage.android.presentation.ui.mypage.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.ourcourage.android.domain.User
import com.example.ourcourage.android.presentation.ui.mypage.MyPageScreen
import com.example.ourcourage.android.presentation.ui.navigation.type.BottomNavType

fun NavGraphBuilder.myPageGraph() {
    composable(
        route = BottomNavType.MyPage.route,
    ) {
        MyPageScreen(
            user = User("수밍밍이", true),
        )
    }
}

fun NavHostController.navigateMyPage() {
    navigate(
        route = BottomNavType.MyPage.route,
    )
}