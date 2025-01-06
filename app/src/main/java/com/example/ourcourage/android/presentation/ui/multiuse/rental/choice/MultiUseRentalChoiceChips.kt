package com.example.ourcourage.android.presentation.ui.multiuse.rental

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ourcourage.android.presentation.type.MultiUseType
import com.example.ourcourage.android.presentation.ui.multiuse.rental.choice.MultiUseRentalChoiceCardViewChip

@Composable
fun MultiUseRentalChoiceChips(
    availableMultiUseOptions: List<MultiUseType>,
    modifier: Modifier = Modifier,
    onSelectionChanged: (MultiUseType) -> Unit,
) {
    val options = listOf(MultiUseType.CUP, MultiUseType.BOWL, MultiUseType.LUNCHBOX, MultiUseType.CUTLERY)
    var selectedOption by remember { mutableStateOf(MultiUseType.CUP) }

    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.padding(bottom = 18.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            MultiUseRentalChoiceCardViewChip(
                MultiUseType.CUP,
                modifier =
                Modifier
                    .weight(1f),
                isSelected = options[0] == selectedOption,
                isEnabled = availableMultiUseOptions.contains(options[0]),
                onSelectionChanged = {
                    selectedOption = options[0]
                    onSelectionChanged(selectedOption)
                },
            )
            MultiUseRentalChoiceCardViewChip(
                MultiUseType.BOWL,
                modifier =
                Modifier
                    .weight(1f),
                isSelected = options[1] == selectedOption,
                isEnabled = availableMultiUseOptions.contains(options[1]),
                onSelectionChanged = {
                    selectedOption = options[1]
                    onSelectionChanged(selectedOption)
                },
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            MultiUseRentalChoiceCardViewChip(
                MultiUseType.CUTLERY,
                modifier =
                Modifier
                    .weight(1f),
                isSelected = options[2] == selectedOption,
                isEnabled = availableMultiUseOptions.contains(options[2]),
                onSelectionChanged = {
                    selectedOption = options[2]
                    onSelectionChanged(selectedOption)
                },
            )

            MultiUseRentalChoiceCardViewChip(
                MultiUseType.LUNCHBOX,
                modifier =
                Modifier
                    .weight(1f),
                isSelected = options[3] == selectedOption,
                isEnabled = availableMultiUseOptions.contains(options[3]),
                onSelectionChanged = {
                    selectedOption = options[3]
                    onSelectionChanged(selectedOption)
                },
            )
        }
    }
}
