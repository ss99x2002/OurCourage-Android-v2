package com.example.ourcourage.android.presentation.ui.multiuse.rental.location

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.R

@Composable
fun MultiUseRentalLocationMapLayout(
    title: String,
    titleIconRes: Int,
    modifier: Modifier = Modifier,
    locationName : String,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 6.dp),
            )

            Image(
                painter = painterResource(titleIconRes),
                contentDescription = "titleIconImage",
                modifier =
                    Modifier
                        .size(35.dp)
                        .padding(start = 4.dp),
            )
        }

        Text(
            text = locationName,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp),
        )

        Image(
            painter = painterResource(R.drawable.img_dummy_map),
            contentDescription = "MultiUseRentalDummyMapImage",
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(
                        200.dp,
                    ),
            contentScale = ContentScale.Crop,
        )
    }
}
