package com.example.ourcourage.android.presentation.ui.mypage

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ourcourage.android.data.model.response.MyPageEditResultResponseDto
import com.example.ourcourage.android.domain.model.HomeUserInfo
import com.example.ourcourage.android.domain.model.MyPageUserInfo
import com.example.ourcourage.android.domain.usecase.MyPageEditInfoUseCase
import com.example.ourcourage.android.domain.usecase.MyPageUserInfoUseCase
import com.example.ourcourage.android.util.base.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(
    private val myPageUserInfoUseCase: MyPageUserInfoUseCase,
    private val myPageEditInfoUseCase: MyPageEditInfoUseCase
) : ViewModel() {

    private val _myPageUserInfoUiState = MutableStateFlow<UiState<MyPageUserInfo>>(UiState.Loading)
    val myPageUserInfoUiState: StateFlow<UiState<MyPageUserInfo>> get() = _myPageUserInfoUiState

    private val _myPageEditUserInfoUiState = MutableStateFlow<UiState<MyPageEditResultResponseDto>>(UiState.Loading)
    val myPageEditUserInfoUiState: StateFlow<UiState<MyPageEditResultResponseDto>> get() = _myPageEditUserInfoUiState

    fun fetchUserInfo() {
        viewModelScope.launch {
            myPageUserInfoUseCase.invoke().fold(
                onSuccess = { userInfo ->
                    _myPageUserInfoUiState.value = UiState.Success(userInfo)
                },
                onFailure = { error ->
                    _myPageUserInfoUiState.value = UiState.Failure(error.message)
                    if (error is HttpException) {
                        val errorBody = error.response()?.errorBody()?.string()
                        Log.e("hyeon", "http 연결 실패 $errorBody")
                    }
                    Log.e("hyeon", "실패 ${error.message}")
                }
            )
        }
    }

    fun editUserInfo(editNickname: String) {
        viewModelScope.launch {
            myPageEditInfoUseCase.invoke(editNickname).fold(
                onSuccess = { result ->
                    _myPageEditUserInfoUiState.value = UiState.Success(result)
                    fetchUserInfo() // 닉네임 수정 후 최신정보 가져오는 로직 추가
                },
                onFailure = { error ->
                    if (error is HttpException) {
                        val errorBody = error.response()?.errorBody()?.string()
                        Log.e("hyeon", "http 연결 실패 $errorBody")
                    }
                    Log.e("hyeon", "실패 ${error.message}")
                }
            )
        }
    }
}