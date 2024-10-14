package com.example.ourcourage.android.presentation.ui.join

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.model.ChipState
import com.example.ourcourage.android.presentation.ui.component.chip.OurCourageChips

val chipElements =
    mutableStateListOf(
        ChipState("남자", mutableStateOf(true)),
        ChipState("여자", mutableStateOf(false)),
    )

@Composable
fun JoinGenderLayout(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "성별",
            modifier = Modifier,
            color = Color.Black,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
        )

        OurCourageChips(
            elements = chipElements,
            onChipClick = { _, _, chipIndex -> },
            modifier =
                Modifier
                    .padding(top = 24.dp, bottom = 0.dp, start = 8.dp, end = 8.dp)
                    .fillMaxWidth(),
            chipModifier =
                Modifier
                    .weight(1f)
                    .height(48.dp),
        )
    }
}
