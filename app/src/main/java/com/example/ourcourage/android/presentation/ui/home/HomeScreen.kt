package com.example.ourcourage.android.presentation.ui.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ourcourage.android.R
import com.example.ourcourage.android.presentation.ui.component.OurCourageCircularProgress
import com.example.ourcourage.android.presentation.ui.component.OurCourageTopBarText
import com.example.ourcourage.android.presentation.ui.home.list.HomeMultiUseHistoryList
import com.example.ourcourage.android.ui.theme.BackgroundBlue
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme
import com.example.ourcourage.android.ui.theme.PrimaryBlue
import com.example.ourcourage.android.util.base.UiState

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onClickMultiUseItem: (String) -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        homeViewModel.fetchUserInfo()
    }

    val uiState by homeViewModel.uiState.collectAsState()

    when (uiState) {
        is UiState.Loading -> {
            OurCourageCircularProgress(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
                progressColor = Color(PrimaryBlue.value)
            )
        }

        is UiState.Success -> {
            val userInfo = (uiState as UiState.Success).data

            Column(modifier = modifier.background(Color(BackgroundBlue.value))) {
                OurCourageTopBarText(
                    title = "홈",
                    isUsedIcon = true,
                    iconDrawableRes = R.drawable.ic_notification,
                )

                HomeMultiUseTopTitle(
                    text = "${userInfo.nickname}님의",
                    modifier =
                    Modifier
                        .padding(horizontal = 24.dp, vertical = 12.dp)
                        .fillMaxWidth(),
                )

                HomeMultiUseHistoryList(
                    list = userInfo.rentalContainers,
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .wrapContentHeight(),
                    onClickMultiUseItem = { useAt ->
                        onClickMultiUseItem(useAt)
                    },
                    useCount = userInfo.useCount,
                )
            }
        }

        is UiState.Failure -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Log.e("hyeon", "Error: ${(uiState as UiState.Failure).message}")
                Text(text = "Error: ${(uiState as UiState.Failure).message}", color = Color.Red)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    OurCourageAndroidv2Theme {
        HomeScreen(
            modifier = Modifier.fillMaxSize(),
            onClickMultiUseItem = { },
        )
    }
}
