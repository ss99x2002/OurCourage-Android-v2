package com.example.ourcourage.android.presentation.ui.join

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ourcourage.android.presentation.ui.component.OurCourageDefaultButtonComponent

@Composable
fun JoinButton(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        OurCourageDefaultButtonComponent(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(54.dp),
            isEnabled = false,
            text = "등록하기",
            onClick = { },
            fontSize = 18,
        )
    }
}
