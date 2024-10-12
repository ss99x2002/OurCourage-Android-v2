package com.example.ourcourage.android.presentation.ui.mypage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ourcourage.android.domain.User
import com.example.ourcourage.android.presentation.ui.component.OurCourageTextTopBar
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme

@Composable
fun MyPageScreen(
    modifier: Modifier = Modifier,
    user: User,
) {
    Column(modifier = modifier) {
        OurCourageTextTopBar(
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
        )

        MyPageMultiUseStatLayout(
            title = "나의 다회용기 통계",
        )
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
