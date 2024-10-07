package com.example.ourcourage.android.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.ui.theme.PrimaryBlue

@Composable
fun OurCourageTextField(
    modifier: Modifier = Modifier,
    title: String? = null,
    value: String = "",
    onClick: () -> Unit = {},
    onValueChange: (String) -> Unit = { _ -> },
    isError: Boolean = false,
    errorDescription: String = "",
    singleLine: Boolean = true,
    placeholder: String = "",
    hint: String = "",
    height: Int,
) {
    BasicTextField(
        modifier =
            modifier
                .clip(RoundedCornerShape(5.dp))
                .background(Color.White)
                .wrapContentHeight(),
        value = value,
        onValueChange = onValueChange,
        textStyle = LocalTextStyle.current.copy(fontSize = 24.sp),
        decorationBox = { innerTextField ->
            Box(
                modifier =
                    Modifier
                        .border(
                            2.dp,
                            Color(PrimaryBlue.value),
                            shape = RoundedCornerShape(5.dp),
                        )
                        .padding(24.dp),
            ) {
                innerTextField()
            }
        },
        singleLine = singleLine,
    )
}

@Preview
@Composable
fun OurCourageTextFieldPreview() {
    OurCourageTextField(
        value = "입력하세요.",
        height = 100,
    )
}
