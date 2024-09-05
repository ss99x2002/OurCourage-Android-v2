package com.example.ourcourage.android.presentation.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme

@Composable
fun OurCourageDefaultButtonComponent(
    modifier: Modifier = Modifier,
    isEnabled: Boolean = false,
    text: String = "",
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = isEnabled,
        colors =
            ButtonColors(
                containerColor = Color.Blue,
                contentColor = Color.White,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.White,
            ),
        elevation =
            ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp,
                disabledElevation = 0.dp,
            ),
    ) {
        Text(
            text = text,
            style =
                TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                ),
        )
    }
}

fun onButtonClick() {
}

@Preview
@Composable
fun OurCourageEnrollButtonPreView() {
    OurCourageAndroidv2Theme {
        OurCourageDefaultButtonComponent(
            modifier =
                Modifier
                    .wrapContentSize()
                    .padding(20.dp),
            isEnabled = true,
            text = "등록하기",
            onClick = { onButtonClick() },
        )

        OurCourageDefaultButtonComponent(
            modifier =
                Modifier
                    .wrapContentSize()
                    .padding(20.dp),
            isEnabled = false,
            text = "등록하기",
            onClick = { onButtonClick() },
        )
    }
}
