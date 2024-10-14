package com.example.ourcourage.android.presentation.ui.join

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
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
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme

@Composable
fun JoinScreen() {
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(vertical = 24.dp)
                .background(Color.White),
    ) {
        Image(
            modifier =
                Modifier
                    .align(Alignment.BottomEnd)
                    .padding(top = 16.dp, bottom = 16.dp, end = 0.dp, start = 32.dp)
                    .fillMaxWidth()
                    .wrapContentHeight(),
            painter = painterResource(R.drawable.img_join_book_background),
            contentDescription = "bookBackgroundImage",
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
        ) {
            Text(
                text = "사용자 정보를\n입력해주세요",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier =
                    Modifier
                        .wrapContentSize()
                        .padding(top = 24.dp, bottom = 12.dp),
            )
            JoinNickNameLayout(
                modifier =
                    Modifier
                        .padding(vertical = 32.dp)
                        .fillMaxWidth(),
            )
            JoinGenderLayout(
                modifier =
                    Modifier
                        .padding(top = 12.dp, bottom = 24.dp)
                        .fillMaxWidth(),
            )
        }
        JoinButton(
            modifier =
                Modifier
                    .align(alignment = Alignment.BottomCenter)
                    .padding(bottom = 16.dp, start = 24.dp, end = 24.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun JoinScreenPreview() {
    OurCourageAndroidv2Theme {
        JoinScreen()
    }
}
