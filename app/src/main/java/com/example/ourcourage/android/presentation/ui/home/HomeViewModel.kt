package com.example.ourcourage.android.presentation.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ourcourage.android.data.datasource.remote.MyPageRemoteDataSource
import com.example.ourcourage.android.domain.model.HomeUserInfo
import com.example.ourcourage.android.domain.usecase.UserInfoUseCase
import com.example.ourcourage.android.util.base.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userInfoUseCase: UserInfoUseCase,
    private val myPageRemoteDataSource: MyPageRemoteDataSource
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<HomeUserInfo>>(UiState.Loading)
    val uiState: StateFlow<UiState<HomeUserInfo>> get() = _uiState

    fun fetchUserInfo() {
        viewModelScope.launch {
            userInfoUseCase.invoke().fold(
                onSuccess = { userInfo ->
                    _uiState.value = UiState.Success(userInfo)
                },
                onFailure = { error ->
                    _uiState.value = UiState.Failure(error.message)
                    if (error is HttpException) {
                        val errorBody = error.response()?.errorBody()?.string()
                        Log.e("hyeon", "next question http 연결 실패 $errorBody")
                    }
                    Log.e("hyeon", "next question 실패 ${error.message}")
                }
            )
        }
    }

}