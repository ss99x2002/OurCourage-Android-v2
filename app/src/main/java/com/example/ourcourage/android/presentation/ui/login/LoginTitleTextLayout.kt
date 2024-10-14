package com.example.ourcourage.android.presentation.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.ui.theme.PrimaryBlue

@Composable
fun LoginTitleTextLayout(
    appTitle: String,
    appTitleColorRange: IntRange,
    subTitle: String,
    subTitleBoldRange: IntRange,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            text =
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(subTitle.substring(subTitleBoldRange))
                    }
                    append(subTitle.substring(subTitleBoldRange.last + 1))
                },
            fontSize = 28.sp,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            lineHeight = 28.sp,
        )

        Text(
            text =
                buildAnnotatedString {
                    append(appTitle.substring(0, appTitleColorRange.start))
                    withStyle(
                        style =
                            SpanStyle(
                                color = PrimaryBlue,
                            ),
                    ) {
                        append(appTitle.substring(appTitleColorRange.start, appTitleColorRange.last + 1))
                    }
                },
            fontWeight = FontWeight.Bold,
            fontSize = 42.sp,
            color = Color.Black,
            modifier =
                Modifier
                    .padding(top = 12.dp)
                    .wrapContentSize(),
        )
    }
}
