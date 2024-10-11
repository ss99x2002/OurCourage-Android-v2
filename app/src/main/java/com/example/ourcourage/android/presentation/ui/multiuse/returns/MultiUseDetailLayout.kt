package com.example.ourcourage.android.presentation.ui.multiuse.returns

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.ui.theme.ButtonBlue

@Composable
fun MultiUseDetailLayout(
    modifier: Modifier = Modifier,
    title: String,
    multiUse: MultiUse,
) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 16.dp),
        ) {
            Image(
                painter = painterResource(multiUse.locationImageUrl),
                contentDescription = "MultiUseRentalCafeImage",
                modifier =
                    Modifier
                        .size(100.dp)
                        .border(
                            width = 1.dp,
                            color = Color(ButtonBlue.value),
                            shape = RoundedCornerShape(10.dp),
                        )
                        .clip(shape = RoundedCornerShape(10.dp)),
            )

            Column(
                modifier = Modifier.padding(start = 12.dp),
            ) {
                Text(
                    text = "대여장소",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = multiUse.locationName,
                    fontSize = 16.sp,
                )
                Text(
                    text = "대여일시",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = multiUse.useAt,
                    fontSize = 16.sp,
                )
            }
        } // 상단 대여조회

        MultiUseDetailCardViews(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 18.dp),
            multiUse = multiUse,
        )
    }
}

@Composable
fun MultiUseDetailCardViews(
    modifier: Modifier = Modifier,
    multiUse: MultiUse,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        MultiUseDetailCareView(
            modifier =
                Modifier
                    .weight(1f),
            title = "대여\n다회용기 종류",
            multiUse = multiUse,
            type = MultiUseDetailCardType.CONTAINER_CATEGORY,
        )

        MultiUseDetailCareView(
            modifier =
                Modifier
                    .weight(1f),
            title = "반납시\n획득 포인트",
            multiUse = multiUse,
            type = MultiUseDetailCardType.POINT,
        )
    }
}
