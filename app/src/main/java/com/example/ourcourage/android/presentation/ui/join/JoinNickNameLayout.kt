package com.example.ourcourage.android.presentation.ui.join

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.presentation.ui.component.OurCourageTextField

@Composable
fun JoinNickNameLayout(modifier: Modifier = Modifier) {
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
