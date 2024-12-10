package com.example.ourcourage.android.presentation.ui.mypage.counter

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.domain.User
import com.example.ourcourage.android.ui.theme.BackgroundTransparentWhite
import com.example.ourcourage.android.ui.theme.PrimaryBlue
import com.example.ourcourage.android.ui.theme.StrokeBlue
import com.example.ourcourage.android.ui.theme.StrokeGrey

@Composable
fun MyPageMultiUseCounterLayout(
    modifier: Modifier = Modifier,
    title: String,
    user: User,
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            modifier =
                Modifier.padding(
                    bottom = 12.dp,
                ),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )

        MyPageMultiUseCounterCardView(
            user = user,
            modifier =
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
        )
    }
}

@Composable
fun MyPageMultiUseCounterCardView(
    modifier: Modifier = Modifier,
    user: User,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(BackgroundTransparentWhite),
        border =
            BorderStroke(1.dp, Color(StrokeBlue.value)),
    ) {
        Row(
            modifier =
                Modifier
                    .padding(horizontal = 12.dp, vertical = 24.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
        ) {
            MyPageMultiUseCounterText(
                title = "현재 포인트",
                content = "1000p",
                textModifier = Modifier.padding(top = 4.dp),
                modifier = Modifier.weight(1f),
            )

            Spacer(
                modifier =
                    Modifier
                        .width(1.dp)
                        .height(80.dp)
                        .background(Color(StrokeGrey.value)),
            )

            MyPageMultiUseCounterText(
                title = "대여 횟수",
                content = "8회",
                modifier = Modifier.weight(1f),
            )

            Spacer(
                modifier =
                    Modifier
                        .width(1.dp)
                        .height(80.dp)
                        .background(Color(StrokeGrey.value)),
            )

            MyPageMultiUseCounterText(
                title = "반납 횟수",
                content = "5회",
                modifier = Modifier.weight(1f),
            )
        }
    }
}

@Composable
fun MyPageMultiUseCounterText(
    modifier: Modifier = Modifier,
    title: String,
    content: String,
    textModifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .padding(vertical = 8.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
        )

        Text(
            text = content,
            fontSize = 20.sp,
            color = Color(PrimaryBlue.value),
            fontWeight = FontWeight.Bold,
            modifier =
                textModifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 12.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyPageMultiUseCounterLayoutPreview() {
    MyPageMultiUseCounterLayout(
        title = "나의 다회용기 이용",
        modifier = Modifier.wrapContentSize(),
        user = User("수밍밍이", true),
    )
}
