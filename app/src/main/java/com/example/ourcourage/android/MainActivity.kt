package com.example.ourcourage.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.ourcourage.android.presentation.ui.navigation.MainBottomNavigation
import com.example.ourcourage.android.presentation.ui.navigation.MainNavigator
import com.example.ourcourage.android.presentation.ui.navigation.type.BottomNavType
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
                        MainBottomNavigation(navController)
                    },
                ) { innerPadding ->
                    MainNavigator(navController, innerPadding)
                }
            }
        }
    }

    companion object {
        val items: List<BottomNavType> =
            listOf(
                BottomNavType.Home,
                BottomNavType.Point,
                BottomNavType.Scan,
                BottomNavType.MyPage,
            )
    }
}
