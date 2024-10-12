package com.example.ourcourage.android.presentation.ui.mypage

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ourcourage.android.presentation.ui.component.OurCourageTextField

@Composable
fun MyPageProfileNickNameEditText(modifier: Modifier = Modifier) {
    OurCourageTextField(
        modifier = modifier,
        hint = "변경 할 닉네임을 입력해주세요.",
        height = 45,
        isError = false,
    )
}
