package com.example.ourcourage.android.presentation.ui.mypage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.User
import com.example.ourcourage.android.presentation.ui.component.OurCourageTopBarText
import com.example.ourcourage.android.presentation.ui.mypage.counter.MyPageMultiUseCounterLayout
import com.example.ourcourage.android.presentation.ui.mypage.profile.MyPageProfile
import com.example.ourcourage.android.presentation.ui.mypage.stat.MyPageMultiUseStatLayout
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme

@Composable
fun MyPageScreen(
    modifier: Modifier = Modifier,
    user: User,
) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.img_stat_background),
            contentDescription = "StatBackground",
            contentScale = ContentScale.Crop,
            modifier =
                Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 56.dp)
                    .fillMaxSize(),
        )
        Column(modifier = modifier) {
            OurCourageTopBarText(
                "마이페이지",
            )

            MyPageProfile(
                modifier =
                    Modifier
                        .padding(24.dp)
                        .fillMaxWidth()
                        .wrapContentHeight(),
                user = user,
            )

            MyPageMultiUseCounterLayout(
                title = "나의 다회용기 이용",
                user = user,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
            )

            MyPageMultiUseStatLayout(
                title = "나의 다회용기 통계",
                user = user,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 18.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPageScreenPreview() {
    OurCourageAndroidv2Theme {
        MyPageScreen(
            modifier = Modifier.fillMaxSize(),
            user = User("수밍밍", true),
        )
    }
}
