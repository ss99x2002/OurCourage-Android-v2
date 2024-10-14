package com.example.ourcourage.android.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ourcourage.android.MultiUseList.multiUseList
import com.example.ourcourage.android.R
import com.example.ourcourage.android.presentation.ui.component.OurCourageTextTopBar
import com.example.ourcourage.android.presentation.ui.home.list.HomeMultiUseHistoryList
import com.example.ourcourage.android.presentation.ui.home.top.HomeMultiUseTopTitle
import com.example.ourcourage.android.ui.theme.BackgroundBlue
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    userName: String,
) {
    Column(modifier = modifier.background(Color(BackgroundBlue.value))) {
        OurCourageTextTopBar(
            title = "홈",
            isUsedIcon = true,
            iconDrawableRes = R.drawable.ic_notification,
        )

        HomeMultiUseTopTitle(
            text = "${userName}님의",
            modifier =
                Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
        )

        HomeMultiUseHistoryList(
            list = multiUseList,
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    OurCourageAndroidv2Theme {
       HomeScreen(
            userName = "신서현",
            modifier = Modifier.fillMaxSize(),
        )
    }
}
