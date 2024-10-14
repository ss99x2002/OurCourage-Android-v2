package com.example.ourcourage.android.presentation.ui.home.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.ui.theme.PrimaryBlue

@Composable
fun HomeMultiUseHistoryTitle(
    modifier: Modifier = Modifier,
    text: String,
    textSize: Float,
    textWeight: FontWeight,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy((-4).dp),
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "현재 다회용기를",
            color = Color.Black,
            fontSize = textSize.sp,
            textAlign = TextAlign.Center,
            fontWeight = textWeight,
        )
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = text,
                color = Color(PrimaryBlue.value),
                fontSize = textSize.sp,
                fontWeight = textWeight,
            )
            Text(
                text = "를 이용중입니다.",
                color = Color.Black,
                fontSize = textSize.sp,
                fontWeight = textWeight,
            )
        }
    }
}
