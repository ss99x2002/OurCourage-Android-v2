package com.example.ourcourage.android.presentation.ui.mypage.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.User
import com.example.ourcourage.android.domain.model.MyPageUserInfo

@Composable
fun MyPageProfileNickNameText(
    modifier: Modifier = Modifier,
    myPageUserInfo: MyPageUserInfo,
    onClickEditButton: () -> Unit = { },
) {
    Row(modifier = modifier) {
        Text(
            "${myPageUserInfo.nickname}님",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 4.dp),
        )

        Image(
            painter = painterResource(R.drawable.ic_pen),
            contentDescription = "EditButton",
            modifier =
                Modifier
                    .size(20.dp)
                    .align(Alignment.CenterVertically)
                    .clickable {
                        onClickEditButton()
                    },
        )
    }
}
