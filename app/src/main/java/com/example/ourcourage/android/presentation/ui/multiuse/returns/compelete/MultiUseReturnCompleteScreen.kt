package com.example.ourcourage.android.presentation.ui.multiuse.returns.compelete

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.presentation.ui.component.OurCourageDefaultButtonComponent
import com.example.ourcourage.android.ui.theme.BackgroundBlue
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme
import com.example.ourcourage.android.ui.theme.StrokeBlue

@Composable
fun MultiUseReturnCompleteScreen(
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
            Text(
                text = "인증 완료",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
            )

            MultiUseReturnPointLayout(
                modifier = Modifier.padding(top = 40.dp),
                multiUse = multiUse,
            )
        }
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

@Composable
fun MultiUseReturnPointLayout(
    modifier: Modifier,
    multiUse: MultiUse,
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .fillMaxHeight(0.74f)
                .background(Color.White)
                .border(
                    width = 1.dp,
                    color = Color(StrokeBlue.value),
                    shape = RoundedCornerShape(10.dp),
                )
                .clip(RoundedCornerShape(10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "적립",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 56.dp),
        )
        Text(
            text = "100" + "p",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = "장소 : ${multiUse.locationName + multiUse.locationAddress}",
            fontSize = 18.sp,
            modifier =
                Modifier
                    .align(Alignment.Start)
                    .padding(start = 24.dp, end = 24.dp, top = 52.dp),
        )
        Text(
            text = "인증 일시 : ${multiUse.useAt}",
            fontSize = 18.sp,
            modifier =
                Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 24.dp),
        )
        Text(
            text = "누적 포인트 : ${multiUse.point}p",
            fontSize = 18.sp,
            modifier =
                Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 24.dp),
        )

        Spacer(modifier = Modifier.weight(1f))

        OurCourageDefaultButtonComponent(
            text = "홈으로",
            onClick = { },
            modifier =
                Modifier
                    .wrapContentHeight()
                    .width(120.dp)
                    .padding(bottom = 48.dp),
            isEnabled = true,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MultiUseReturnCompleteScreenPreview() {
    OurCourageAndroidv2Theme {
        MultiUseReturnCompleteScreen(
            modifier = Modifier.fillMaxSize(),
            multiUse = MultiUse(multiUseContainerId = 1, locationName = "블루포트 공덕역점", useAt = "2024-10-10 10:45:21", status = "대여중", userId = 1, locationImageUrl = R.drawable.img_tumbler),
            onClickHomeButton = { },
        )
    }
}
