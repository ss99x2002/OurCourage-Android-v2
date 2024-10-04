package com.example.ourcourage.android.presentation.ui.component.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ourcourage.android.model.ChipState
import com.example.ourcourage.android.presentation.ui.component.OurCourageChipComponent

@Composable
fun OurCourageChips(
    elements: List<ChipState>,
    onChipClick: (String, Boolean, Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        elements.forEachIndexed { idx, chipState ->
            OurCourageChipComponent(
                selected = elements[idx].isSelected.value,
                onClick = { onChipClick },
                text = elements[idx].text,
                modifier =
                    Modifier
                        .weight(1f)
                        .height(48.dp),
            )
        }
    }
}
