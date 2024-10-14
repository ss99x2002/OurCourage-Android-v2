package com.example.ourcourage.android.presentation.ui.login

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun LoginButton(
    @DrawableRes loginButton: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Image(
        painter = painterResource(loginButton),
        contentDescription = "LoginButtonImage",
        alignment = Alignment.BottomCenter,
        modifier =
            modifier.clickable {
                onClick()
            },
    )
}
