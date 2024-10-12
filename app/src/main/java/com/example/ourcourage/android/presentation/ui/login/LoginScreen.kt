package com.example.ourcourage.android.presentation.ui.login

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.R
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme
import com.example.ourcourage.android.ui.theme.PrimaryBlue

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        LoginTitleText(
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

@Composable
fun LoginTitleText(
    appTitle: String,
    appTitleColorRange: IntRange,
    subTitle: String,
    subTitleBoldRange: IntRange,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text =
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(subTitle.substring(subTitleBoldRange))
                    }
                    append(subTitle.substring(subTitleBoldRange.last + 1))
                },
            fontSize = 28.sp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            lineHeight = 28.sp,
        )

        Text(
            text =
                buildAnnotatedString {
                    append(appTitle.substring(0, appTitleColorRange.start))
                    withStyle(
                        style =
                            SpanStyle(
                                color = PrimaryBlue,
                            ),
                    ) {
                        append(appTitle.substring(appTitleColorRange.start, appTitleColorRange.last + 1))
                    }
                },
            fontWeight = FontWeight.Bold,
            fontSize = 42.sp,
            color = Color.Black,
            modifier =
                Modifier
                    .padding(top = 12.dp)
                    .wrapContentSize(),
        )
    }
}

@Composable
fun LoginButton(
    @DrawableRes loginButton: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Image(
        painter = painterResource(loginButton),
        contentDescription = "LoginButtonImage",
        alignment = Alignment.BottomCenter,
        modifier =
            modifier.clickable {
                onClick()
            },
    )
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
