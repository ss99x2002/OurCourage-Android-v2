package com.example.ourcourage.android.presentation.ui.home.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.MultiUse
import com.example.ourcourage.android.domain.model.RentalMultiUse

@Composable
fun HomeMultiUseHistoryList(
    modifier: Modifier = Modifier,
    list: List<RentalMultiUse> = emptyList(),
    useCount : Int,
    onClickMultiUseItem: (String) -> Unit,
) {
    Column(modifier) {
        Card(
            modifier = Modifier.background(Color.White),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(3.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
        ) {
            HomeMultiUseHistoryTitle(
                text = "${useCount}개",
                textSize = 28f,
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, bottom = 4.dp),
                textWeight = FontWeight.Bold,
            )

            Box(
                modifier =
                    Modifier
                        .wrapContentHeight(),
            ) {
                Image(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomEnd),
                    painter = painterResource(R.drawable.img_home_tree_background),
                    contentDescription = "backgroundTreeImage",
                    contentScale = ContentScale.Crop,
                )
                LazyColumn(
                    modifier =
                        modifier
                            .padding(top = 10.dp, bottom = 120.dp)
                            .fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    // list 순회하면서 multiUseItem 가져온다.
                    // items import에 따라 사용 다름
                    items(list) { multiUseItem ->
                        HomeMultiUseHistoryItem(
                            multiUse = multiUseItem,
                            modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 4.dp)
                                    .clickable {
                                        onClickMultiUseItem(multiUseItem.useAt)
                                    },
                        )
                    }
                }
            }
        }
    }
}
