package com.example.ourcourage.android.presentation.ui.mypage.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ourcourage.android.R
import com.example.ourcourage.android.domain.model.MyPageUserInfo
import com.example.ourcourage.android.presentation.ui.component.OurCourageDefaultButtonComponent
import com.example.ourcourage.android.presentation.ui.mypage.MyPageViewModel

@Composable
fun MyPageProfile(
    modifier: Modifier = Modifier,
    myPageUserInfo: MyPageUserInfo,
    onClickEditButton: () -> Unit = { },
    myPageViewModel: MyPageViewModel = hiltViewModel(),
) {
    var isEditingNickName by remember { mutableStateOf(false) }
    var nickname by remember { mutableStateOf(myPageUserInfo.nickname) }

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
            if (isEditingNickName) {
                MyPageProfileNickNameEditText(
                    modifier = Modifier.width(125.dp),
                    value = nickname,
                    onValueChange = { nickname = it },
                )
            } else {
                MyPageProfileNickNameText(
                    modifier = Modifier,
                    myPageUserInfo = myPageUserInfo,
                    onClickEditButton = { isEditingNickName = !isEditingNickName },
                )
            }

            Text(
                text = if (myPageUserInfo.gender) "남성 / 개인회원" else "여성 / 개인회원",
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
                text = if (isEditingNickName) "수정완료" else "로그아웃",
                onClick = {
                    if (isEditingNickName) {
                        myPageViewModel.editUserInfo(nickname)
                        isEditingNickName = false
                    } else {
                        // 로그아웃 시행
                    }
                },
                isEnabled = true,
            )
        }
    }
}
