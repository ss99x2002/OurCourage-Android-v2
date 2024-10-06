package com.example.ourcourage.android.presentation.ui.home

import android.graphics.fonts.FontStyle
import androidx.annotation.DrawableRes
import androidx.annotation.Size
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.MultiUseList
import com.example.ourcourage.android.MultiUseList.multiUseList
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.ui.theme.BackgroundBlue
import com.example.ourcourage.android.ui.theme.OurCourageAndroidv2Theme
import com.example.ourcourage.android.ui.theme.PrimaryBlue
import com.example.ourcourage.android.ui.theme.StrokeGrey

@Composable
fun HomeScreen() {

}

@Composable
fun HomeScreenContent(modifier: Modifier = Modifier, userName: String) {
    Column(modifier = modifier.background(Color(BackgroundBlue.value))) {
        HomeTopBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 0.dp),
            title = "홈",
            iconDrawableRes = R.drawable.ic_notification
        )
        HomeTopTitle(
            text = "${userName}님의",
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        )

        HomeMultiUseList(
            list = multiUseList,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        )
    }
}

@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
    title: String,
    iconDrawableRes: Int
) {
    Box(modifier = modifier) {
        Text(
            text = title,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterStart)
        )

        Image(
            painter = painterResource(id = iconDrawableRes),
            contentDescription = "notificationIcon",
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.CenterEnd)
        )
    }


}

@Composable
fun HomeTopTitle(
    modifier: Modifier = Modifier, text: String,
    onClickIcon: () -> Unit = {}
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy((-12).dp)
    ) {
        Row(
            modifier = Modifier.wrapContentSize(),
            horizontalArrangement = Arrangement.spacedBy((-4).dp)
        ) {
            Text(
                text = text,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
            Image(
                modifier = Modifier
                    .size(40.dp)
                    .clickable {
                        onClickIcon()
                    },
                painter = painterResource(
                    R.drawable.img_leaf_clover
                ),
                contentDescription = "leafCloverImage",
            )
        }
        Text(
            text = "다회용기 대여 현황",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )
    }
}

@Composable
fun HomeMultiUseList(
    modifier: Modifier = Modifier,
    list: List<MultiUse>
) {
    Column(modifier) {
        Card(
            modifier = Modifier.background(Color.White),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(3.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {

            HomeMultiUseListTitle(
                text = "2개",
                textSize = 28f,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 4.dp),
                textWeight = FontWeight.Bold
            )

            LazyColumn(
                modifier = Modifier
                    .padding(12.dp)
                    .height(380.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {

                items(list.size) { index ->
                    HomeMultiUseItem(
                        multiUse = list[index],
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun HomeMultiUseListTitle(
    modifier: Modifier = Modifier,
    text: String,
    textSize: Float,
    textWeight: FontWeight
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy((-4).dp)
    ) {
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "현재 다회용기를",
            color = Color.Black,
            fontSize = textSize.sp,
            textAlign = TextAlign.Center,
            fontWeight = textWeight
        )
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(
                text = text,
                color = Color(PrimaryBlue.value),
                fontSize = textSize.sp,
                fontWeight = textWeight
            )
            Text(
                text = "를 이용중입니다.",
                color = Color.Black,
                fontSize = textSize.sp,
                fontWeight = textWeight
            )
        }
    }
}

@Composable
fun HomeMultiUseItem(
    modifier: Modifier = Modifier,
    multiUse: MultiUse
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(1.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row {
            Image(
                modifier = Modifier
                    .padding(12.dp)
                    .size(45.dp)
                    .border(
                        1.dp, Color(StrokeGrey.value), shape = RoundedCornerShape(10.dp)
                    ),
                painter = painterResource(id = multiUse.multiUseImage),
                contentDescription = "multiUseImage",

                )
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.spacedBy((-4).dp)
            ) {
                Row {
                    Text(
                        text = "다회용기",
                        modifier = Modifier.padding(end = 8.dp),
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                    Text(
                        text = multiUse.status,
                        color = Color(PrimaryBlue.value),
                        fontSize = 12.sp
                    )
                }
                Text(
                    text = "대여일시 : ${multiUse.useAt}",
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    OurCourageAndroidv2Theme {
        HomeScreenContent(
            userName = "신서현",
            modifier = Modifier.fillMaxSize()
        )
    }
}


