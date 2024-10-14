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
import com.example.ourcourage.android.presentation.ui.multiuse.rental.choice.MultiUseRentalChoiceCardViewChip
import com.example.ourcourage.android.presentation.ui.multiuse.rental.type.MultiUseType

@Composable
fun MultiUseRentalChoiceChips(modifier: Modifier = Modifier) {
    val options = listOf(MultiUseType.CUP, MultiUseType.BOWL, MultiUseType.LUNCHBOX, MultiUseType.UTENSILS)
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
                onSelectionChanged = { selectedOption = options[0] },
            )
            MultiUseRentalChoiceCardViewChip(
                MultiUseType.BOWL,
                modifier =
                    Modifier
                        .weight(1f),
                isSelected = options[1] == selectedOption,
                onSelectionChanged = { selectedOption = options[1] },
            )
        }
        Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
            MultiUseRentalChoiceCardViewChip(
                MultiUseType.UTENSILS,
                modifier =
                    Modifier
                        .weight(1f),
                isSelected = options[2] == selectedOption,
                onSelectionChanged = { selectedOption = options[2] },
            )

            MultiUseRentalChoiceCardViewChip(
                MultiUseType.LUNCHBOX,
                modifier =
                    Modifier
                        .weight(1f),
                isSelected = options[3] == selectedOption,
                onSelectionChanged = { selectedOption = options[3] },
            )
        }
    }
}
