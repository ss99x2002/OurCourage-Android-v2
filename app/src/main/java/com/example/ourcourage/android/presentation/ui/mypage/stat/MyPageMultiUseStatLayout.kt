package com.example.ourcourage.android.presentation.ui.mypage.stat

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.domain.User
import com.example.ourcourage.android.model.ChipState
import com.example.ourcourage.android.presentation.ui.component.chip.OurCourageChips
import com.example.ourcourage.android.ui.theme.BackgroundTransparentWhite
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme
import com.example.ourcourage.android.ui.theme.PrimaryBlue
import com.example.ourcourage.android.ui.theme.StatReturnTypePink
import com.example.ourcourage.android.ui.theme.StrokeBlue
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.column.columnChart
import com.patrykandpatrick.vico.compose.chart.scroll.rememberChartScrollState
import com.patrykandpatrick.vico.compose.style.ChartStyle
import com.patrykandpatrick.vico.compose.style.ProvideChartStyle
import com.patrykandpatrick.vico.core.DefaultColors
import com.patrykandpatrick.vico.core.axis.AxisItemPlacer
import com.patrykandpatrick.vico.core.axis.horizontal.HorizontalAxis
import com.patrykandpatrick.vico.core.axis.vertical.VerticalAxis
import com.patrykandpatrick.vico.core.chart.column.ColumnChart
import com.patrykandpatrick.vico.core.chart.composed.plus
import com.patrykandpatrick.vico.core.chart.values.AxisValuesOverrider
import com.patrykandpatrick.vico.core.component.shape.LineComponent
import com.patrykandpatrick.vico.core.component.shape.Shapes
import com.patrykandpatrick.vico.core.component.text.TextComponent
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.FloatEntry
import com.patrykandpatrick.vico.core.entry.composed.ComposedChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.composed.plus
import com.patrykandpatrick.vico.core.entry.entryOf

val chipElements =
    mutableStateListOf(
        ChipState("주별", mutableStateOf(true)),
        ChipState("월별", mutableStateOf(false)),
    )

val rentalList = listOf(5, 8, 12, 7, 10, 14, 9)
val returnList = listOf(1, 3, 5, 7, 1, 3, 5)


val week = listOf("월", "화", "수", "목", "금", "토", "일")
val month = listOf("1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월")

@Composable
fun MyPageMultiUseStatLayout(
    modifier: Modifier = Modifier,
    title: String,
    user: User,
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
                    onChipClick = { _, _, chipIndex -> selectedGraphType = chipElements[chipIndex].toString() },
                    chipModifier =
                    Modifier
                        .padding(
                            horizontal = 12.dp,
                        )
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
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(top = 8.dp),
                colorList = listOf(PrimaryBlue, StatReturnTypePink),
                bottomAxisLabels = getBottomAxisLabels(selectedGraphType),
                rentalData = rentalList,
                returnData = returnList,
            )
        }
    }
}

private fun getBottomAxisLabels(selectedType: String): List<String> {
    return when (selectedType) {
        "주별" -> week
        "월별" -> month
        else -> week
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

@Composable
fun MyPageMultiUseStatGraph(
    modifier: Modifier = Modifier,
    colorList: List<Color>,
    bottomAxisLabels: List<String>,
    rentalData: List<Int>,
    returnData: List<Int>,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        ProvideChartStyle(rememberChartStyle(colorList)) {
            // 그래프 모델 생성
            val rentalChartModel = createChartModel(rentalData)
            val returnChartModel = createChartModel(returnData)

            // 그래프 표시
            Chart(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .padding(horizontal = 8.dp, vertical = 8.dp),
                chart = createColumnChart(),
                chartModelProducer = ComposedChartEntryModelProducer(
                    rentalChartModel.plus(returnChartModel)
                ),
                startAxis = createStartAxis(),
                bottomAxis = createBottomAxis(bottomAxisLabels),
                runInitialAnimation = true,
                chartScrollState = rememberChartScrollState(),
            )
        }
    }
}

@Composable
fun rememberChartStyle(columnChartColors: List<Color>): ChartStyle {
    val isDarkTheme = isSystemInDarkTheme()
    val defaultColors = if (isDarkTheme) DefaultColors.Dark else DefaultColors.Light

    return remember(columnChartColors, isDarkTheme) {
        ChartStyle(
            axis = ChartStyle.Axis(
                axisLabelColor = Color(defaultColors.axisLabelColor),
                axisGuidelineColor = Color(defaultColors.axisGuidelineColor),
                axisLineColor = Color(defaultColors.axisLineColor),
            ),
            columnChart = ChartStyle.ColumnChart(
                columns = columnChartColors.map { color ->
                    LineComponent(
                        color = color.toArgb(),
                        thicknessDp = 25f,
                        shape = Shapes.cutCornerShape(topLeftPercent = 20, topRightPercent = 20),
                    )
                },
                dataLabel = TextComponent.Builder().build(),
            ),
            lineChart = ChartStyle.LineChart(lines = emptyList()),
            marker = ChartStyle.Marker(),
            elevationOverlayColor = Color(defaultColors.elevationOverlayColor),
        )
    }
}

private fun createChartModel(data: List<Int>): ChartEntryModelProducer {
    return ChartEntryModelProducer(data.mapIndexed { index, value ->
        entryOf(x = index.toFloat(), y = value.toFloat())
    })
}

@Composable
private fun createColumnChart() = columnChart(
    mergeMode = ColumnChart.MergeMode.Grouped,
    axisValuesOverrider = AxisValuesOverrider.fixed(minY = 0f, maxY = 20f),
    spacing = 10.dp,
)

@Composable
private fun createStartAxis() = rememberStartAxis(
    itemPlacer = AxisItemPlacer.Vertical.default(maxItemCount = 6),
)

@Composable
private fun createBottomAxis(labels: List<String>) = rememberBottomAxis(
    itemPlacer = AxisItemPlacer.Horizontal.default(),
    valueFormatter = { value, _ ->
        labels[value.toInt() % labels.size]
    }
)

@Preview(showBackground = true)
@Composable
fun MyPageMultiUseStatLayoutPreview() {
    OurCourageAndroidv2Theme {
        MyPageMultiUseStatLayout(
            title = "나의 다회용기 통계",
            user = User("수밍밍이", true),
            modifier =
            Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
        )
    }
}
