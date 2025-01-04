package com.example.ourcourage.android.presentation.ui.mypage.stat

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.domain.model.DailyStatistics
import com.example.ourcourage.android.domain.model.MonthlyStatistics
import com.example.ourcourage.android.presentation.model.ChipState
import com.example.ourcourage.android.presentation.ui.component.chip.OurCourageChips
import com.example.ourcourage.android.ui.theme.BackgroundTransparentWhite
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme
import com.example.ourcourage.android.ui.theme.PrimaryBlue
import com.example.ourcourage.android.ui.theme.StatReturnTypePink
import com.example.ourcourage.android.ui.theme.StrokeBlue

val chipElements =
    mutableStateListOf(
        ChipState("주별", mutableStateOf(true)),
        ChipState("월별", mutableStateOf(false)),
    )

val week = listOf("월", "화", "수", "목", "금", "토", "일")
val month = listOf("1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월")

@Composable
fun MyPageMultiUseStatLayout(
    modifier: Modifier = Modifier,
    title: String,
    dailyStatistics: List<DailyStatistics>,
    monthlyStatistics: List<MonthlyStatistics>,
) {
    var selectedGraphType by remember { mutableStateOf("주별") }

    Column(modifier = modifier) {
        Text(
            text = title,
            modifier =
                Modifier.padding(
                    bottom = 12.dp,
                ),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )
        Card(
            modifier =
                Modifier
                    .fillMaxWidth(),
            colors = CardDefaults.cardColors(BackgroundTransparentWhite),
            border =
                BorderStroke(1.dp, Color(StrokeBlue.value)),
        ) {
            Row(modifier = Modifier.padding(top = 12.dp)) {
                OurCourageChips(
                    elements = chipElements,
                    modifier =
                        Modifier
                            .width(200.dp)
                            .height(48.dp)
                            .align(Alignment.CenterVertically),
                    onChipClick = { text, _, chipIndex ->
                        chipElements.forEachIndexed { index, chipState ->
                            chipState.isSelected.value = (index == chipIndex)
                        }
                        selectedGraphType = text
                    },
                    chipModifier =
                        Modifier
                            .padding(horizontal = 12.dp)
                            .height(30.dp)
                            .width(80.dp)
                            .align(Alignment.CenterVertically),
                    chipFontSize = 12,
                )

                Column(
                    modifier =
                        Modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 32.dp),
                ) {
                    MyPageMultiUseStatType(
                        typeColor = Color(PrimaryBlue.value),
                        type = "대여",
                    )

                    MyPageMultiUseStatType(
                        typeColor = Color(StatReturnTypePink.value),
                        type = "반납",
                    )
                }
            }

            MyPageMultiUseStatGraph(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .padding(top = 8.dp),
                colorList = listOf(PrimaryBlue, StatReturnTypePink),
                dailyStatistics = dailyStatistics,
                monthlyStatistics = monthlyStatistics,
                isMonthlySelected = selectedGraphType == "월별",
                bottomAxisLabels = getBottomAxisLabels(selectedGraphType),
            )
        }
    }
}

@Composable
fun MyPageMultiUseStatType(
    typeColor: Color,
    type: String,
) {
    Row {
        Box(
            modifier =
                Modifier
                    .background(
                        color = typeColor,
                        shape = CircleShape,
                    )
                    .size(8.dp)
                    .align(Alignment.CenterVertically),
        )

        Text(
            text = type,
            fontSize = 12.sp,
            modifier =
                Modifier
                    .padding(start = 4.dp)
                    .align(Alignment.CenterVertically),
            color = Color.Black,
        )
    }
}

fun getBottomAxisLabels(
    selectedType: String,
): List<String> {
    return when (selectedType) {
        "주별" -> week
        "월별" -> month
        else -> week
    }
}

@Preview(showBackground = true)
@Composable
fun MyPageMultiUseStatLayoutPreview() {
    OurCourageAndroidv2Theme {
        MyPageMultiUseStatLayout(
            title = "나의 다회용기 통계",
            dailyStatistics = listOf(),
            monthlyStatistics = listOf(),
            modifier =
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
        )
    }
}
