package com.example.ourcourage.android.presentation.ui.multiuse.returns.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.domain.model.RentalMultiUse
import com.example.ourcourage.android.domain.model.ReturnDetail
import com.example.ourcourage.android.presentation.ui.multiuse.returns.type.MultiUseDetailCardType
import com.example.ourcourage.android.ui.theme.ButtonBlue
import com.example.ourcourage.android.ui.theme.PrimaryBlue

@Composable
fun MultiUseDetailCareView(
    modifier: Modifier = Modifier,
    title: String,
    multiUse: ReturnDetail,
    type: MultiUseDetailCardType,
) {
    Card(
        modifier =
            modifier
                .border(width = 1.dp, color = Color(ButtonBlue.value), shape = RoundedCornerShape(10.dp))
                .background(Color.White)
                .fillMaxWidth()
                .height(150.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxHeight() // Card의 전체 높이를 채움
                    .fillMaxWidth(),
            // Card의 전체 너비를 채움
            verticalArrangement = Arrangement.Center,
            // 수직 중앙 정렬
            horizontalAlignment = Alignment.CenterHorizontally,
            // 수평 중앙 정렬
        ) {
            Text(
                text = title,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier =
                    Modifier
                        .fillMaxWidth(),
                textAlign = TextAlign.Center,
            )

            when (type) {
                MultiUseDetailCardType.POINT -> {
                    Box(
                        modifier =
                            Modifier
                                .padding(top = 4.dp)
                                .height(60.dp),
                    ) {
                        Text(
                            text = multiUse.point.toString() + "p",
                            color = Color(PrimaryBlue.value),
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,
                            modifier =
                                Modifier
                                    .align(Alignment.Center),
                        )
                    }
                }

                MultiUseDetailCardType.CONTAINER_CATEGORY -> {
                    Image(
                        painter =
                            painterResource(
                                when (multiUse.multiUseContainerId) {
                                    1 -> R.drawable.ic_cup
                                    2 -> R.drawable.ic_bowl
                                    3 -> R.drawable.ic_lunch_box
                                    4 -> R.drawable.ic_untensils
                                    else -> R.drawable.ic_launcher_background
                                },
                            ),
                        contentDescription = "MultiUseContainerImage",
                        modifier =
                            Modifier
                                .padding(top = 4.dp)
                                .size(60.dp),
                    )
                }
            }
        }
    }
}
