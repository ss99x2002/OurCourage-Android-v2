package com.example.ourcourage.android.presentation.ui.multiuse.returns

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.presentation.ui.component.OurCourageDefaultButtonComponent
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme

@Composable
fun MultiUseReturnScreen(
    modifier: Modifier,
) {
    Box(modifier = modifier.verticalScroll(rememberScrollState())) {
        Image(
            painter = painterResource(R.drawable.ic_multiuse_rental_recycler_background),
            contentDescription = "multiUseRentalBackgroundBottomIcon",
            modifier =
                Modifier
                    .align(Alignment.CenterStart)
                    .width(width = 200.dp)
                    .padding(top = 250.dp),
            contentScale = ContentScale.Crop,
        )
        Column(modifier = Modifier.padding(bottom = 24.dp)) {
            Image(
                contentDescription = "multiUseRentalTopBackgroundImage",
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(260.dp),
                contentScale = ContentScale.Crop,
                painter =
                    painterResource(
                        R.drawable.img_multiuse_rental_top_background,
                    ),
            )

            MultiUseDetailLayout(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 42.dp),
                title = "다회용기 이용 조회",
                multiUse = MultiUse(multiUseContainerId = 1, locationName = "블루포트 인하대점", useAt = "2024-10-10 10:45:21", status = "대여중", userId = 1, locationImageUrl = R.drawable.img_tumbler),
            )

            MultiUseReturnLocationMapLayout(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 24.dp),
                title = "반납 가능 장소",
                titleIconRes = R.drawable.ic_location_pin,
            )

            Box(
                modifier =
                    Modifier
                        .wrapContentSize()
                        .padding(bottom = 24.dp),
            ) {
                OurCourageDefaultButtonComponent(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(horizontal = 24.dp),
                    isEnabled = true,
                    text = "다회용기 반납하기",
                    onClick = { onClickReturnButton() },
                )
            }
        }

        Image(
            painter = painterResource(R.drawable.ic_multiuse_rental_hands_earth_background),
            contentDescription = "multiUseRentalBackgroundTopIcon",
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .align(Alignment.TopEnd)
                    .padding(top = 28.dp, start = 72.dp),
        )
    }
}

fun onClickReturnButton() {
}

@Preview(showBackground = true)
@Composable
fun MultiUseReturnScreenPreview() {
    OurCourageAndroidv2Theme {
        MultiUseReturnScreen(
            modifier = Modifier.fillMaxSize(),
        )
    }
}
