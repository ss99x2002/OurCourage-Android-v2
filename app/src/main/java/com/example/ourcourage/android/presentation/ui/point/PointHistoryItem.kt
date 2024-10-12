package com.example.ourcourage.android.presentation.ui.point

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme
import com.example.ourcourage.android.ui.theme.StrokeBlue

@Composable
fun PointHistoryItem(
    modifier: Modifier = Modifier,
    multiUse: MultiUse,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {
        Column(modifier.padding(vertical = 12.dp, horizontal = 16.dp)) {
            Text(
                text = multiUse.useAt,
                modifier = Modifier,
            )
            Row(modifier = Modifier) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_background),
                    modifier =
                    Modifier
                        .padding(end = 12.dp, top = 2.dp)
                        .size(70.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .border(width = 1.dp, color = Color(StrokeBlue.value), shape = RoundedCornerShape(20.dp)),
                    contentDescription = "MultiUseCafeThumbNail",
                )
                Column(
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "+${multiUse.point}p 획득",
                        modifier = Modifier.wrapContentWidth(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )
                    Text(
                        text = "대여장소 : ${multiUse.locationName + multiUse.locationAddress} ",
                        modifier = Modifier.wrapContentWidth(),
                        fontSize = 14.sp,
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PointHistoryItemPreview() {
    OurCourageAndroidv2Theme {
        PointHistoryItem(
            modifier = Modifier.wrapContentSize(),
            multiUse = MultiUse(multiUseContainerId = 1, locationName = "블루포트 인하대점", useAt = "2024-10-10 10:45:21", status = "대여중", userId = 1, locationImageUrl = R.drawable.img_tumbler),
        )
    }
}
