package com.example.ourcourage.android.presentation.ui.multiuse.rental.choice

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ourcourage.android.R
import com.example.ourcourage.android.presentation.type.MultiUseType
import com.example.ourcourage.android.ui.theme.PrimaryBlue
import com.example.ourcourage.android.ui.theme.StrokeBlue

@Composable
fun MultiUseRentalChoiceCardViewChip(
    multiUseType: MultiUseType,
    modifier: Modifier = Modifier,
    isEnabled: Boolean,
    isSelected: Boolean,
    onSelectionChanged: () -> Unit,
) {
    Card(
        modifier = modifier
            .clickable(enabled = isEnabled) {
                onSelectionChanged()
            },
        colors = if (isEnabled) CardDefaults.cardColors(Color.White) else CardDefaults.cardColors(Color.Gray),
        border = BorderStroke(width = 2.dp, color = if (isSelected) PrimaryBlue else StrokeBlue),
    ) {
        Image(
            painter = painterResource(returnMultiUseTypeImage(multiUseType)),
            contentDescription = "MultiUseRentalChoiceImage",
            modifier =
            Modifier
                .size(100.dp)
                .padding(start = 8.dp, end = 8.dp, top = 20.dp)
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .wrapContentHeight(),
        )
        Text(
            text = multiUseType.multiUseName,
            modifier =
            Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 20.dp),
            textAlign = TextAlign.Center,
        )
    }
}

fun returnMultiUseTypeImage(multiUseType: MultiUseType): Int {
    return when (multiUseType) {
        MultiUseType.CUP -> { R.drawable.ic_cup }
        MultiUseType.BOWL -> R.drawable.ic_bowl
        MultiUseType.LUNCHBOX -> R.drawable.ic_lunch_box
        MultiUseType.CUTLERY -> R.drawable.ic_untensils
        MultiUseType.UNKNOWN -> R.drawable.ic_launcher_background
    }
}

@Preview
@Composable
fun MultiUseRentalChoiceCardViewPreview() {
}
