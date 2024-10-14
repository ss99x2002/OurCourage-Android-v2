package com.example.ourcourage.android.presentation.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ourcourage.android.R
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        LoginTitleTextLayout(
            appTitle = "우리의 용기",
            appTitleColorRange = 4..5,
            subTitle = "다회용기로\n실천하는 탄소중립",
            subTitleBoldRange = 0..4,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 48.dp),
        )
        Box {
            Image(
                painter =
                    painterResource(
                        R.drawable.img_login_background,
                    ),
                contentDescription = "LoginBackgroundImage",
                alignment = Alignment.BottomEnd,
                modifier =
                    Modifier
                        .fillMaxSize()
                        .align(Alignment.BottomEnd),
            )

            LoginButton(
                loginButton = R.drawable.img_kakao_login_button,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(85.dp)
                        .padding(start = 24.dp, end = 24.dp, bottom = 32.dp)
                        .align(Alignment.BottomCenter),
            )
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    OurCourageAndroidv2Theme {
        LoginScreen(
            modifier = Modifier.fillMaxSize(),
        )
    }
}
