package com.example.ourcourage.android.presentation.ui.point

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.MultiUseList
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme

@Composable
fun PointHistoryScreen(
    modifier: Modifier = Modifier,
    multiUseList: List<MultiUse>,
) {
    PointHistoryBackgroundImage(modifier)
    Column(modifier = modifier) {
        Text(
            text = "포인트 내역",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(24.dp),
        )
    }
}

@Composable
fun PointHistoryList(
    modifier: Modifier = Modifier,
    multiUseList: List<MultiUse>,
) {
    LazyColumn {
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
                    .height(460.dp),
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
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 24.dp),
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
