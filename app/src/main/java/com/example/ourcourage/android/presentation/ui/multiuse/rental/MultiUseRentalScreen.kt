package com.example.ourcourage.android.presentation.ui.multiuse.rental

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ourcourage.android.R
import com.example.ourcourage.android.presentation.ui.component.OurCourageTextTopBar
import com.example.ourcourage.android.presentation.ui.multiuse.rental.choice.MultiUseRentalChoiceLayout
import com.example.ourcourage.android.presentation.ui.multiuse.rental.location.MultiUseRentalLocationMapLayout
import com.example.ourcourage.android.ui.theme.BackgroundBlue
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme

@Composable
fun MultiUseRentalScreen(modifier: Modifier = Modifier) {
    Box {
        Column(modifier) {
            OurCourageTextTopBar("대여내용")
            MultiUseRentalLocationMapLayout(
                title = "대여장소",
                titleIconRes = R.drawable.ic_location_pin,
                modifier =
                    Modifier
                        .padding(horizontal = 24.dp),
            )

            MultiUseRentalChoiceLayout(
                title = "취급 다회용기",
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp, top = 24.dp),
            )

            MultiUseRentalChoiceChips(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp, vertical = 8.dp),
            )
        }

        Image(
            modifier =
                Modifier
                    .width(150.dp)
                    .wrapContentHeight()
                    .align(Alignment.TopEnd),
            painter = painterResource(R.drawable.img_multi_use_rental_top_sun_background),
            contentDescription = "MultiUseRentalTopSunBackgroundImage",
            contentScale = ContentScale.Crop,
        )

        Image(
            modifier =
                Modifier
                    .width(120.dp)
                    .wrapContentHeight()
                    .align(Alignment.BottomStart),
            painter = painterResource(R.drawable.img_multi_use_rental_sun_bottom_background),
            contentDescription = "MultiUseRentalTopSunBackgroundImage",
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MultiUseRentalScreenPreview() {
    OurCourageAndroidv2Theme {
        MultiUseRentalScreen(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(Color(BackgroundBlue.value)),
        )
    }
}
