package com.example.ourcourage.android.presentation.ui.component.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ourcourage.android.presentation.ui.component.OurCourageDefaultButtonComponent
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme

@Composable
fun OurCourageOneButtonDialog(
    modifier: Modifier = Modifier,
    contentText: String = "",
    buttonText: String,
    onButtonClick: () -> Unit,
) {
    Column(
        modifier =
            modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp, vertical = 18.dp),
            textAlign = TextAlign.Center,
            text = contentText,
        )

        Row(
            modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 4.dp, bottom = 24.dp),
        ) {
            OurCourageDefaultButtonComponent(
                modifier =
                    Modifier
                        .wrapContentHeight()
                        .weight(1f)
                        .padding(horizontal = 32.dp),
                text = buttonText,
                isEnabled = false,
                onClick = onButtonClick,
            )
        }
    }
}

@Composable
@Preview()
fun OurCourageOneButtonDialogPreview() {
    OurCourageAndroidv2Theme {
        OurCourageOneButtonDialog(
            modifier = Modifier.wrapContentSize(),
            contentText =
                "누보 모바일 오피스 \n 인증을 완료 하시겠습니까? \n" +
                    " 인증을 완료 하시겠습니까? \n" +
                    " 인증을 완료 하시겠습니까? \n" +
                    " 인증을 완료 하시겠습니까? \n" +
                    " 인증을 완료 하시겠습니까? \n" +
                    " 인증을 완료 하시겠습니까?",
            buttonText = "예",
            onButtonClick = { },
        )
    }
}
