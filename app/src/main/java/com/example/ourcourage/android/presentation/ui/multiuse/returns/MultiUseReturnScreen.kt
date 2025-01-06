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
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.presentation.ui.component.OurCourageCircularProgress
import com.example.ourcourage.android.presentation.ui.component.OurCourageDefaultButtonComponent
import com.example.ourcourage.android.presentation.ui.component.OurCourageErrorBox
import com.example.ourcourage.android.presentation.ui.multiuse.returns.detail.MultiUseDetailLayout
import com.example.ourcourage.android.presentation.ui.multiuse.returns.location.MultiUseReturnLocationMapLayout
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme
import com.example.ourcourage.android.ui.theme.PrimaryBlue
import com.example.ourcourage.android.util.base.UiState

@Composable
fun MultiUseReturnScreen(
    modifier: Modifier = Modifier,
    useAt: String = "",
    onClickReturn: (String,String) -> Unit,
    returnViewModel: ReturnViewModel = hiltViewModel()
) {

    LaunchedEffect(Unit) {
        returnViewModel.fetchLocationInfo(useAt)
    }

    val uiState by returnViewModel.locationInfoUiState.collectAsState()

    when (uiState) {
        is UiState.Loading -> {
            OurCourageCircularProgress(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
                progressColor = Color(PrimaryBlue.value)
            )
        }

        is UiState.Success -> {
            val multiUse = (uiState as UiState.Success).data

            Box(modifier = modifier.verticalScroll(rememberScrollState())) {
                // 배경 이미지 (가장 뒤쪽 재활용 이미지)
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
                // 주요 콘텐츠 (상단 레이어)
                Column(modifier = Modifier.padding(bottom = 24.dp)) {
                    // 상단 이미지
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

                    // 다회용기 이용 조회
                    MultiUseDetailLayout(
                        modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 42.dp),
                        title = "다회용기 이용 조회",
                        multiUse = multiUse,
                    )

                    // 반납 장소 정보
                    MultiUseReturnLocationMapLayout(
                        modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 24.dp),
                        title = "반납 가능 장소",
                        titleIconRes = R.drawable.ic_location_pin,
                    )

                    // 반납 버튼
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
                            onClick = { onClickReturn("RETURN",multiUse.useAt) },
                        )
                    }
                }

                // 배경 이미지 (상단 지구본 이미지)
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

        is UiState.Failure -> {
            OurCourageErrorBox(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
                errorMessage = (uiState as UiState.Failure).message.toString()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MultiUseReturnScreenPreview() {
    OurCourageAndroidv2Theme {
        MultiUseReturnScreen(
            modifier = Modifier.fillMaxSize(),
            onClickReturn = {_,_ -> },
        )
    }
}
