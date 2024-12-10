package com.example.ourcourage.android.presentation.ui.component.chip

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.ui.theme.ChipBlue
import com.example.ourcourage.android.ui.theme.ChipWhite
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme

@Composable
fun OurCourageChipComponent(
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    selectedColor: Color = Color(ChipBlue.value),
    unselectedColor: Color = Color(ChipWhite.value),
    text: String = "",
    fontSize: Int = 14,
    onClick: () -> Unit,
) {
    Surface(
        color = if (isSelected) selectedColor else unselectedColor,
        shape = RoundedCornerShape(100.dp),
        modifier =
            modifier
                .border(
                    width = 1.dp,
                    shape = RoundedCornerShape(100.dp),
                    color = Color(ChipBlue.value),
                )
                .clickable(onClick = onClick),
    ) {
        Text(
            modifier = modifier.wrapContentSize(),
            textAlign = TextAlign.Center,
            text = text,
            fontSize = fontSize.sp,
        )
    }
}

@Composable
@Preview
fun OurCourageChipPreview() {
    OurCourageAndroidv2Theme {
        OurCourageChipComponent(
            selectedColor = Color(ChipBlue.value),
            unselectedColor = Color(ChipWhite.value),
            isSelected = true,
            text = "여자",
            modifier =
                Modifier
                    .wrapContentSize()
                    .padding(20.dp),
            onClick = { },
            fontSize = 14,
        )
    }
}
