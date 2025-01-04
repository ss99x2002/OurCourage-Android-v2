package com.example.ourcourage.android.presentation.ui.mypage

import android.util.Log
import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ourcourage.android.R
import com.example.ourcourage.android.presentation.ui.component.OurCourageTopBarText
import com.example.ourcourage.android.presentation.ui.mypage.counter.MyPageMultiUseCounterLayout
import com.example.ourcourage.android.presentation.ui.mypage.profile.MyPageProfile
import com.example.ourcourage.android.presentation.ui.mypage.stat.MyPageMultiUseStatLayout
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme
import com.example.ourcourage.android.util.base.UiState

@Composable
fun MyPageScreen(
    modifier: Modifier = Modifier,
    myPageViewModel: MyPageViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        myPageViewModel.fetchUserInfo()
    }

    val myPageUserInfoUiState by myPageViewModel.myPageUserInfoUiState.collectAsState()

    when (myPageUserInfoUiState) {
        is UiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is UiState.Success -> {
            val userInfo = (myPageUserInfoUiState as UiState.Success).data

            Box(modifier = modifier) {
                Image(
                    painter = painterResource(R.drawable.img_stat_background),
                    contentDescription = "StatBackground",
                    modifier =
                        Modifier
                            .padding(top = 56.dp)
                            .fillMaxSize(),
                )
                Column(modifier = modifier) {
                    OurCourageTopBarText(
                        title = "마이페이지",
                    )

                    MyPageProfile(
                        myPageUserInfo = userInfo,
                        onClickEditButton = { },
                        modifier =
                            Modifier
                                .padding(24.dp)
                                .fillMaxWidth()
                                .wrapContentHeight(),
                    )

                    MyPageMultiUseCounterLayout(
                        title = "나의 다회용기 이용",
                        myPageUserInfo = userInfo,
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(24.dp),
                    )

                    MyPageMultiUseStatLayout(
                        title = "나의 다회용기 통계",
                        dailyStatistics = userInfo.dailyStatisticsResList,
                        monthlyStatistics = userInfo.monthlyStatisticsResList,
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 24.dp, vertical = 18.dp),
                    )
                }
            }
        }
        is UiState.Failure -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Log.e("hyeon", "Error: ${(myPageUserInfoUiState as UiState.Failure).message}")
                Text(text = "Error: ${(myPageUserInfoUiState as UiState.Failure).message}", color = Color.Red)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPageScreenPreview() {
    OurCourageAndroidv2Theme {
        MyPageScreen(
            modifier = Modifier.fillMaxSize(),
        )
    }
}
