package com.example.ourcourage.android.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OurCourageTextTopBar(
    title: String,
    isUsedIcon: Boolean = false,
    iconDrawableRes: Int = 0,
) {
    Box(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(24.dp),
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )

        if (isUsedIcon) {
            Image(
                painter = painterResource(id = iconDrawableRes),
                contentDescription = "topBarEndIcon",
                modifier =
                    Modifier
                        .size(24.dp)
                        .align(Alignment.TopEnd),
            )
        }
    }
}
