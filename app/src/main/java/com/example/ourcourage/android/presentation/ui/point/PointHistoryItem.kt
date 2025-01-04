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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.domain.model.PointContent
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme
import com.example.ourcourage.android.ui.theme.StrokeBlue

@Composable
fun PointHistoryItem(
    modifier: Modifier = Modifier,
    pointContent: PointContent,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(1.dp),
    ) {
        Column(modifier.padding(vertical = 12.dp, horizontal = 16.dp)) {
            Text(
                text = pointContent.useAt,
                modifier = Modifier,
                fontSize = 10.sp,
            )
            Row(modifier = Modifier) {
                AsyncImage(
                    model = ImageRequest.Builder(
                        context = LocalContext.current
                    )
                        .data(pointContent.pointTypeImageUrl)
                        .build(),
                    modifier =
                    Modifier
                        .padding(end = 12.dp, top = 2.dp)
                        .size(55.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .border(width = 1.dp, color = Color(StrokeBlue.value), shape = RoundedCornerShape(5.dp)),
                    contentDescription = "MultiUseCafeThumbNail",
                    contentScale = ContentScale.FillHeight
                )
                Column(
                    modifier =
                    Modifier
                        .align(Alignment.CenterVertically)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = "+${pointContent.point}p 획득",
                        modifier = Modifier.wrapContentWidth(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                    )
                    Text(
                        text = "대여장소 : ${pointContent.rentalLocationName} ${pointContent.rentalLocationAddress}",
                        modifier = Modifier.wrapContentWidth(),
                        fontSize = 12.sp,
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
            pointContent = PointContent(
                useAt = "2021.09.01",
                useAtParsed = "2021.09.01",
                point = 1000,
                pointTypeImageUrl = "ss",
                rentalLocationAddress = "인하대점",
                rentalLocationName = "블루포트",
                returnLocationAddress = "블루포트",
                returnLocationName = "블루포트"
            )
        )
    }
}
