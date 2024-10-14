package com.example.ourcourage.android.presentation.ui.multiuse.returns.location

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.R

@Composable
fun MultiUseReturnLocationMapLayout(
    modifier: Modifier = Modifier,
    title: String = "",
    @DrawableRes
    titleIconRes: Int,
) {
    Column(modifier = modifier) {
        Row {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )

            Image(
                painter = painterResource(titleIconRes),
                contentDescription = "titleIconImage",
                modifier =
                    Modifier
                        .size(35.dp)
                        .padding(start = 4.dp),
            )
        }
        Image(
            painter = painterResource(R.drawable.img_dummy_map),
            contentDescription = "dummyMapImage",
            modifier =
                Modifier
                    .padding(top = 12.dp)
                    .fillMaxWidth()
                    .height(300.dp),
        )
    }
}
