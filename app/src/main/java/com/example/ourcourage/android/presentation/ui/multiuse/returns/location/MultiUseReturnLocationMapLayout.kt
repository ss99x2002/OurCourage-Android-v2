package com.example.ourcourage.android.presentation.ui.multiuse.returns.location

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.domain.model.ReturnLocationInfo
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.Marker
import com.naver.maps.map.compose.MarkerState
import com.naver.maps.map.compose.NaverMap
import com.naver.maps.map.compose.rememberCameraPositionState as rememberCameraPositionState

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun MultiUseReturnLocationMapLayout(
    modifier: Modifier = Modifier,
    title: String = "",
    @DrawableRes
    titleIconRes: Int,
    returnLocationList: List<ReturnLocationInfo>
) {
    Column(modifier = modifier) {
        Row {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )

            Image(
                painter = painterResource(titleIconRes),
                contentDescription = "titleIconImage",
                modifier =
                Modifier
                    .size(35.dp)
                    .padding(start = 4.dp),
            )
        }
        NaverMap(
            cameraPositionState = rememberCameraPositionState {
                position = CameraPosition(
                    LatLng(
                        returnLocationList.first().latitude,
                        returnLocationList.first().longitude
                    ), 17.0
                )
            },
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(20.dp))
        ) {
            returnLocationList.forEach { location ->
                Marker(
                    state = MarkerState(
                        position = LatLng(location.latitude, location.longitude)
                    )
                )
            }
        }
    }
}
