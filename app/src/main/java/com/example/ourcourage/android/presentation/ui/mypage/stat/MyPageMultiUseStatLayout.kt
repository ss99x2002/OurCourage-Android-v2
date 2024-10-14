package com.example.ourcourage.android.presentation.ui.mypage.stat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.User
import com.example.ourcourage.android.model.ChipState
import com.example.ourcourage.android.presentation.ui.component.chip.OurCourageChips
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme
import com.example.ourcourage.android.ui.theme.PrimaryBlue
import com.example.ourcourage.android.ui.theme.StatReturnTypePink

@Composable
fun MyPageMultiUseStatLayout(
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

        Row(modifier = Modifier) {
            OurCourageChips(
                elements = chipElements,
                modifier =
                    Modifier
                        .width(200.dp)
                        .height(48.dp)
                        .align(Alignment.CenterVertically),
                onChipClick = { _, _, chipIndex -> },
                chipModifier =
                    Modifier
                        .padding(
                            horizontal = 12.dp,
                        )
                        .height(30.dp)
                        .width(80.dp)
                        .align(Alignment.CenterVertically),
                chipFontSize = 12,
            )

            Column(
                modifier =
                    Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 32.dp),
            ) {
                MyPageMultiUseStatType(
                    typeColor = Color(PrimaryBlue.value),
                    type = "대여",
                )

                MyPageMultiUseStatType(
                    typeColor = Color(StatReturnTypePink.value),
                    type = "반납",
                )
            }
        }

        MyPageMultiUseStatGraph(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 12.dp),
        )
    }
}

val chipElements =
    mutableStateListOf(
        ChipState("주별", mutableStateOf(true)),
        ChipState("월별", mutableStateOf(false)),
    )

@Composable
fun MyPageMultiUseStatType(
    typeColor: Color,
    type: String,
) {
    Row {
        Box(
            modifier =
                Modifier
                    .background(
                        color = typeColor,
                        shape = CircleShape,
                    )
                    .size(8.dp)
                    .align(Alignment.CenterVertically),
        )

        Text(
            text = type,
            fontSize = 12.sp,
            modifier =
                Modifier
                    .padding(start = 4.dp)
                    .align(Alignment.CenterVertically),
            color = Color.White,
        )
    }
}

@Composable
fun MyPageMultiUseStatGraph(modifier: Modifier) {
    Image(
        painter = painterResource(R.drawable.img_dummy_stat),
        contentDescription = "StatGraphDummyImage",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun MyPageMultiUseStatLayoutPreview() {
    OurCourageAndroidv2Theme {
        MyPageMultiUseStatLayout(
            title = "나의 다회용기 통계",
            user = User("수밍밍이", true),
            modifier =
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
        )
    }
}
