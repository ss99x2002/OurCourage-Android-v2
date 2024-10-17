package com.example.ourcourage.android.presentation.ui.scan.compelete

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
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
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.ui.theme.BackgroundBlue
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme

@Composable
fun ScanCompleteScreen(
    modifier: Modifier = Modifier,
    multiUse: MultiUse,
    onClickHomeButton: () -> Unit,
) {
    Box(
        modifier =
            modifier
                .padding(top = 60.dp)
                .background(Color(BackgroundBlue.value)),
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // 상단 제목
            Text(
                text = "인증 완료",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            )

            // 적립 포인트 레이아웃
            MultiUseReturnPointLayout(
                modifier = Modifier.padding(top = 40.dp),
                multiUse = multiUse,
                onClickHomeButton = onClickHomeButton,
            )
        }
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
}

@Preview(showBackground = true)
@Composable
fun MultiUseReturnCompleteScreenPreview() {
    OurCourageAndroidv2Theme {
        ScanCompleteScreen(
            modifier = Modifier.fillMaxSize(),
            multiUse = MultiUse(multiUseContainerId = 1, locationName = "블루포트 공덕역점", useAt = "2024-10-10 10:45:21", status = "대여중", userId = 1, locationImageUrl = R.drawable.img_tumbler),
            onClickHomeButton = { },
        )
    }
}
