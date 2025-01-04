package com.example.ourcourage.android.presentation.ui.point

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ourcourage.android.R
import com.example.ourcourage.android.data.datasource.local.MultiUseList
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.domain.model.PointContent
import com.example.ourcourage.android.presentation.ui.component.OurCourageTopBarText
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme
import com.example.ourcourage.android.util.base.UiState

@Composable
fun PointHistoryScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    multiUseList: List<MultiUse>,
    pointViewModel: PointViewModel = hiltViewModel(),
) {
    LaunchedEffect(Unit) {
        pointViewModel.fetchPointHistory()
    }
    PointHistoryBackgroundImage(modifier)
    Column(modifier = modifier) {
        OurCourageTopBarText(
            "포인트 내역",
        )
        val uiState by pointViewModel.pointHistoryUiState.collectAsState()

        when (uiState) {
            is UiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is UiState.Success -> {
                val pointHistory = (uiState as UiState.Success).data
                PointHistoryList(
                    pointHistoryList = pointHistory.content,
                    modifier =
                        Modifier
                            .padding(horizontal = 20.dp)
                            .fillMaxWidth()
                            .height(640.dp),
                )

                // 페이지네이션 처리 (Load More 버튼 추가)
                if (!pointHistory.last) {
                    Button(
                        onClick = { pointViewModel.fetchPointHistory(loadMore = true) },
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                    ) {
                        Text("더 보기")
                    }
                }
            }

            is UiState.Failure -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Log.e("hyeon", "Error: ${(uiState as UiState.Failure).message}")
                    Text(text = "Error: ${(uiState as UiState.Failure).message}", color = Color.Red)
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun PointHistoryList(
    modifier: Modifier = Modifier,
    pointHistoryList: List<PointContent>,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(pointHistoryList) { content ->
            PointHistoryItem(
                pointContent = content,
                modifier =
                    Modifier
                        .fillMaxSize(),
            )
        }
    }
}

@Composable
fun PointHistoryBackgroundImage(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        // 상단 동전 배경 이미지
        Image(
            painter = painterResource(R.drawable.img_return_complete_top_coin_background),
            contentDescription = "ReturnTopCoinBackgroundImage",
            modifier =
                Modifier
                    .wrapContentWidth()
                    .background(Color.Transparent)
                    .height(450.dp),
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopStart,
        )

        // 하단 동전 배경 이미지
        Image(
            painter = painterResource(R.drawable.img_return_complete_bottom_coin_background),
            contentDescription = "ReturnTopCoinBackgroundImage",
            modifier =
                Modifier
                    .wrapContentWidth()
                    .background(Color.Transparent)
                    .height(490.dp)
                    .align(Alignment.BottomEnd),
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun PointHistoryScreenPreview() {
    OurCourageAndroidv2Theme {
        PointHistoryScreen(
            modifier = Modifier.fillMaxSize(),
            multiUseList = MultiUseList.multiUseList,
        )
    }
}
