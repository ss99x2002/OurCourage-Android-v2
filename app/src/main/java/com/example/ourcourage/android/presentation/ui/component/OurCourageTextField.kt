package com.example.ourcourage.android.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
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
    textStyle: TextStyle = LocalTextStyle.current.copy(color = Color.Black, fontSize = 24.sp),
    innerTextFieldStyle: TextStyle = textStyle.copy(fontSize = 24.sp),
) {
    Column(modifier = modifier) {
        if (isError) {
            Text(
                text = errorDescription,
                color = Color.Red,
                modifier =
                    Modifier
                        .padding(start = 12.dp, bottom = 8.dp),
            )
        }
        BasicTextField(
            modifier =
                Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .height(height.dp),
            value = value,
            onValueChange = onValueChange,
            textStyle = innerTextFieldStyle,
            decorationBox = { innerTextField ->
                Box(
                    modifier =
                        Modifier
                            .border(
                                2.dp,
                                if (isError) Color.Red else Color(PrimaryBlue.value),
                                shape = RoundedCornerShape(10.dp),
                            )
                            .padding(24.dp),
                ) {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = textStyle.copy(color = Color.Gray),
                        )
                    }
                    innerTextField()
                }
            },
            singleLine = singleLine,
        )
    }
}

@Preview
@Composable
fun OurCourageTextFieldPreview() {
    OurCourageTextField(
        value = "입력하세요.",
        height = 100,
        isError = true,
    )
}
