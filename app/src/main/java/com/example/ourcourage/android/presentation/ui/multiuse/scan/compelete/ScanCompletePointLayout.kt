package com.example.ourcourage.android.presentation.ui.multiuse.scan.compelete

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.presentation.ui.component.OurCourageDefaultButtonComponent
import com.example.ourcourage.android.ui.theme.StrokeBlue

@Composable
fun MultiUseReturnPointLayout(
    modifier: Modifier,
    multiUse: MultiUse,
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .fillMaxHeight(0.74f)
                .background(Color.White)
                .border(
                    width = 1.dp,
                    color = Color(StrokeBlue.value),
                    shape = RoundedCornerShape(10.dp),
                )
                .clip(RoundedCornerShape(10.dp)),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "적립",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 56.dp),
        )
        Text(
            text = "100" + "p",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
        )

        Text(
            text = "장소 : ${multiUse.locationName + multiUse.locationAddress}",
            fontSize = 18.sp,
            modifier =
                Modifier
                    .align(Alignment.Start)
                    .padding(start = 24.dp, end = 24.dp, top = 52.dp),
        )
        Text(
            text = "인증 일시 : ${multiUse.useAt}",
            fontSize = 18.sp,
            modifier =
                Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 24.dp),
        )
        Text(
            text = "누적 포인트 : ${multiUse.point}p",
            fontSize = 18.sp,
            modifier =
                Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 24.dp),
        )

        Spacer(modifier = Modifier.weight(1f))

        OurCourageDefaultButtonComponent(
            text = "홈으로",
            onClick = { },
            modifier =
                Modifier
                    .wrapContentHeight()
                    .width(120.dp)
                    .padding(bottom = 48.dp),
            isEnabled = true,
        )
    }
}
