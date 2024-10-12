package com.example.ourcourage.android.presentation.ui.mypage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.User
import com.example.ourcourage.android.presentation.ui.component.OurCourageDefaultButtonComponent

@Composable
fun MyPageProfile(
    modifier: Modifier = Modifier,
    user: User,
    onClickEditButton: () -> Unit = { },
) {
    var isEditingNickName = remember { mutableStateOf(false) }

    Row(
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_profile),
            contentDescription = "ProfileImage",
            modifier =
                Modifier
                    .size(60.dp),
        )

        Column(
            modifier =
                Modifier
                    .padding(start = 8.dp, top = 4.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            if (isEditingNickName.value) {
                MyPageProfileNickNameEditText(
                    modifier = Modifier,
                )
            } else {
                MyPageProfileNickNameText(
                    modifier = Modifier,
                    user = user,
                    onClickEditButton = onClickEditButton,
                )
            }

            Text(
                text = if (user.gender) "남성 / 개인회원" else "여성 / 개인회원",
            )
        }

        Spacer(
            modifier = Modifier.fillMaxWidth(0.3f),
        )
        Box(
            modifier =
                Modifier
                    .align(Alignment.CenterVertically),
        ) {
            OurCourageDefaultButtonComponent(
                text = if (isEditingNickName.value) "수정완료" else "로그아웃",
                onClick = {
                    if (isEditingNickName.value) {
                        // 수정완료 시행
                    } else {
                        // 로그아웃 시행
                    }
                },
                isEnabled = true,
            )
        }
    }
}
