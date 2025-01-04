package com.example.ourcourage.android.presentation.ui.mypage.stat

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import com.example.ourcourage.android.domain.model.DailyStatistics
import com.example.ourcourage.android.domain.model.MonthlyStatistics
import com.patrykandpatrick.vico.compose.axis.horizontal.rememberBottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.rememberStartAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.column.columnChart
import com.patrykandpatrick.vico.compose.chart.scroll.rememberChartScrollState
import com.patrykandpatrick.vico.compose.style.ChartStyle
import com.patrykandpatrick.vico.compose.style.ProvideChartStyle
import com.patrykandpatrick.vico.core.DefaultColors
import com.patrykandpatrick.vico.core.axis.AxisItemPlacer
import com.patrykandpatrick.vico.core.chart.column.ColumnChart
import com.patrykandpatrick.vico.core.chart.values.AxisValuesOverrider
import com.patrykandpatrick.vico.core.component.shape.LineComponent
import com.patrykandpatrick.vico.core.component.shape.Shapes
import com.patrykandpatrick.vico.core.component.text.TextComponent
import com.patrykandpatrick.vico.core.entry.ChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.composed.ComposedChartEntryModelProducer
import com.patrykandpatrick.vico.core.entry.composed.plus
import com.patrykandpatrick.vico.core.entry.entryOf

@Composable
fun MyPageMultiUseStatGraph(
    modifier: Modifier = Modifier,
    colorList: List<Color>,
    dailyStatistics: List<DailyStatistics>,
    monthlyStatistics: List<MonthlyStatistics>,
    isMonthlySelected: Boolean,
    bottomAxisLabels: List<String>,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        ProvideChartStyle(rememberChartStyle(colorList)) {
            // 그래프 모델 생성
            val rentalChartModel =
                createChartModel(
                    if (isMonthlySelected) {
                        monthlyStatistics.map { it.useCount }
                    } else {
                        dailyStatistics.map { it.useCount }
                    },
                )
            val returnChartModel =
                createChartModel(
                    if (isMonthlySelected) {
                        monthlyStatistics.map { it.returnCount }
                    } else {
                        dailyStatistics.map { it.returnCount }
                    },
                )

            // 그래프 표시
            Chart(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                chart = createColumnChart(),
                chartModelProducer =
                    ComposedChartEntryModelProducer(
                        rentalChartModel.plus(returnChartModel),
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
            axis =
                ChartStyle.Axis(
                    axisLabelColor = Color(defaultColors.axisLabelColor),
                    axisGuidelineColor = Color(defaultColors.axisGuidelineColor),
                    axisLineColor = Color(defaultColors.axisLineColor),
                ),
            columnChart =
                ChartStyle.ColumnChart(
                    columns =
                        columnChartColors.map { color ->
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
    return ChartEntryModelProducer(
        data.mapIndexed { index, value ->
            entryOf(x = index.toFloat(), y = value.toFloat())
        },
    )
}

@Composable
private fun createColumnChart() =
    columnChart(
        mergeMode = ColumnChart.MergeMode.Grouped,
        axisValuesOverrider = AxisValuesOverrider.fixed(minY = 0f, maxY = 20f),
        spacing = 10.dp,
    )

@Composable
private fun createStartAxis() =
    rememberStartAxis(
        itemPlacer = AxisItemPlacer.Vertical.default(maxItemCount = 6),
    )

@Composable
private fun createBottomAxis(labels: List<String>) =
    rememberBottomAxis(
        itemPlacer = AxisItemPlacer.Horizontal.default(),
        valueFormatter = { value, _ ->
            labels[value.toInt() % (labels.size)]
        },
    )
