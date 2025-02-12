package com.example.ourcourage.android.presentation.ui.component.chip

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ourcourage.android.presentation.model.ChipState

@Composable
fun OurCourageChips(
    elements: List<ChipState>,
    onChipClick: (String, Boolean, Int) -> Unit,
    modifier: Modifier = Modifier,
    chipModifier: Modifier = Modifier,
    chipFontSize: Int = 14,
) {
    Row(
        modifier = modifier,
    ) {
        elements.forEachIndexed { idx, chipState ->
            OurCourageChipComponent(
                isSelected = chipState.isSelected.value,
                onClick = { onChipClick(chipState.text, chipState.isSelected.value, idx) },
                text = chipState.text,
                modifier = chipModifier,
                fontSize = chipFontSize,
            )
        }
    }
}
