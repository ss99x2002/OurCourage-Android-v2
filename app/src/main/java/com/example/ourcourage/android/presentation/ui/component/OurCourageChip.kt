package com.example.ourcourage.android.presentation.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ourcourage.android.ui.theme.ChipBlue
import com.example.ourcourage.android.ui.theme.ChipWhite
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme

@Composable
fun OurCourageChipComponent(
    modifier: Modifier = Modifier,
    selected: Boolean,
    selectedColor: Color,
    unselectedColor: Color,
    text: String = "",
    onClick: () -> Unit,
) {
    Surface(
        color =
            when {
                selected -> selectedColor
                else -> unselectedColor
            },
        shape = RoundedCornerShape(100.dp),
        modifier =
            modifier.border(
                width = 1.dp,
                shape = RoundedCornerShape(100.dp),
                color =
                    Color(
                        ChipBlue.value,
                    ),
            ),
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 6.dp),
            text = text,
        )
    }
}

fun onChipClick() {
}

@Composable
@Preview
fun OurCourageChipPreview() {
    OurCourageAndroidv2Theme {
        OurCourageChipComponent(
            selectedColor = Color(ChipBlue.value),
            unselectedColor = Color(ChipWhite.value),
            selected = true,
            text = "여자",
            modifier =
                Modifier
                    .wrapContentSize()
                    .padding(20.dp),
            onClick = { onChipClick() },
        )
    }
}
