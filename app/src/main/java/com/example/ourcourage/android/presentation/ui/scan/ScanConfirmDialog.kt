package com.example.ourcourage.android.presentation.ui.scan

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.ourcourage.android.presentation.ui.component.dialog.OurCourageOneButtonDialog
import com.example.ourcourage.android.presentation.ui.component.dialog.OurCourageTwoButtonsDialog
import com.example.ourcourage.android.presentation.ui.component.onButtonClick

@Composable
fun ScanConfirmDialog(
    isError: Boolean,
    contentText: String,
    modifier: Modifier,
    buttonText: String = "",
    onHomeButtonClick: () -> Unit = { },
    onDismissButtonClick: () -> Unit = { },
    onAcceptButtonClick: () -> Unit = { },
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        if (isError) {
            OurCourageOneButtonDialog(
                modifier = modifier,
                contentText = contentText,
                onButtonClick = onHomeButtonClick,
                buttonText = buttonText,
            )
        } else {
            OurCourageTwoButtonsDialog(
                modifier = modifier,
                contentText = contentText,
                onDismissButtonClick = onDismissButtonClick,
                onAcceptButtonClick = onAcceptButtonClick,
            )
        }
    }
}
