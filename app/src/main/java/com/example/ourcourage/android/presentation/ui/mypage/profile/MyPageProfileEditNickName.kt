package com.example.ourcourage.android.presentation.ui.mypage.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ourcourage.android.presentation.ui.component.OurCourageTextField

@Composable
fun MyPageProfileNickNameEditText(
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit,
) {
    OurCourageTextField(
        value = value,
        modifier = modifier,
        onValueChange = onValueChange,
        hint = "변경 할 닉네임을 입력해주세요.",
        height = 45,
        isError = false,
    )
}
