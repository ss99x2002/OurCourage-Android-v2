package com.example.ourcourage.android.presentation.ui.multiuse.rental.location

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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.model.RentalLocationInfo
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.compose.ExperimentalNaverMapApi
import com.naver.maps.map.compose.Marker
import com.naver.maps.map.compose.MarkerState
import com.naver.maps.map.compose.NaverMap
import com.naver.maps.map.compose.rememberCameraPositionState

@OptIn(ExperimentalNaverMapApi::class)
@Composable
fun MultiUseRentalLocationMapLayout(
    title: String,
    titleIconRes: Int,
    modifier: Modifier = Modifier,
    locationInfo: RentalLocationInfo
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Row {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 6.dp),
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

        Text(
            text = locationInfo.locationName + " " + locationInfo.locationAddress,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp),
        )

        NaverMap(
            cameraPositionState = rememberCameraPositionState {
                position = CameraPosition(
                    LatLng(
                        locationInfo.latitude,
                        locationInfo.longitude
                    ), 23.0
                )
            },
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(20.dp))
        ) {
            Marker(
                state = MarkerState(
                    position = LatLng(locationInfo.latitude, locationInfo.longitude)
                )
            )
        }
    }
}
