package com.example.ourcourage.android.presentation.ui.home.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.ui.theme.PrimaryBlue
import com.example.ourcourage.android.ui.theme.StrokeGrey

@Composable
fun HomeMultiUseHistoryItem(
    modifier: Modifier = Modifier,
    multiUse: MultiUse,
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(1.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Row {
            Image(
                modifier =
                    Modifier
                        .padding(12.dp)
                        .size(45.dp)
                        .border(
                            1.dp,
                            Color(StrokeGrey.value),
                            shape = RoundedCornerShape(10.dp),
                        ),
                painter = painterResource(id = multiUse.locationImageUrl),
                contentDescription = "multiUseImage",
            )
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy((-4).dp),
            ) {
                Row {
                    Text(
                        text = "다회용기",
                        modifier = Modifier.padding(end = 8.dp),
                        color = Color.Black,
                        fontSize = 12.sp,
                    )
                    Text(
                        text = multiUse.status,
                        color = Color(PrimaryBlue.value),
                        fontSize = 12.sp,
                    )
                }
                Text(
                    text = "대여일시 : ${multiUse.useAt}",
                    fontSize = 12.sp,
                    color = Color.Black,
                )
            }
        }
    }
}
