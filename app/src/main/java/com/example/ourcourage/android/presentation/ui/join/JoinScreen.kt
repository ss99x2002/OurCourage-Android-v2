package com.example.ourcourage.android.presentation.ui.join

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
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
import com.example.ourcourage.android.model.ChipState
import com.example.ourcourage.android.presentation.ui.component.OurCourageChips
import com.example.ourcourage.android.presentation.ui.component.OurCourageDefaultButtonComponent
import com.example.ourcourage.android.presentation.ui.component.OurCourageTextField
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
            NickNameLayout(
                modifier =
                    Modifier
                        .padding(vertical = 32.dp)
                        .fillMaxWidth(),
            )
            GenderLayout(
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

@Composable
fun NickNameLayout(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "닉네임",
            modifier = Modifier,
            color = Color.Black,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
        )

        OurCourageTextField(
            hint = "사용 할 닉네임을 입력해주세요.",
            errorDescription = "해당 닉네임은 사용 할 수 없습니다.",
            isError = true,
            onClick = {},
            onValueChange = {},
            value = "닉네임을 입력하세요.",
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
            height = 100,
        )
    }
}

@Composable
fun GenderLayout(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "성별",
            modifier = Modifier,
            color = Color.Black,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
        )

        OurCourageChips(
            elements = chipElements,
            onChipClick = { _, _, chipIndex -> },
            modifier =
                Modifier
                    .padding(top = 24.dp, bottom = 0.dp, start = 8.dp, end = 8.dp)
                    .fillMaxWidth(),
            chipModifier =
                Modifier
                    .weight(1f)
                    .height(48.dp),
        )
    }
}

val chipElements =
    mutableStateListOf(
        ChipState("남자", mutableStateOf(true)),
        ChipState("여자", mutableStateOf(false)),
    )

@Composable
fun JoinButton(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        OurCourageDefaultButtonComponent(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(54.dp),
            isEnabled = false,
            text = "등록하기",
            onClick = { },
            fontSize = 18,
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
