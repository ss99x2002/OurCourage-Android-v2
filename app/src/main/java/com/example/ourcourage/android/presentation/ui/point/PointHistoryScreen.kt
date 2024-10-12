package com.example.ourcourage.android.presentation.ui.point

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
import com.example.ourcourage.android.presentation.ui.component.OurCourageTextTopBar
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme

@Composable
fun PointHistoryScreen(
    modifier: Modifier = Modifier,
    multiUseList: List<MultiUse>,
) {
    PointHistoryBackgroundImage(modifier)
    Column(modifier = modifier) {
        
        OurCourageTextTopBar(
            "포인트 내역"
        )

        PointHistoryList(
            multiUseList = multiUseList,
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .height(640.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun PointHistoryList(
    modifier: Modifier = Modifier,
    multiUseList: List<MultiUse>,
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(multiUseList) { multiUse ->
            PointHistoryItem(
                multiUse = multiUse,
                modifier = Modifier
                    .fillMaxSize()
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
