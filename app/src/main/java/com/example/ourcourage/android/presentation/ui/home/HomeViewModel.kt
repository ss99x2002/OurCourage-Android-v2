package com.example.ourcourage.android.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ourcourage.android.domain.model.UserInfo
import com.example.ourcourage.android.domain.usecase.UserInfoUseCase
import com.example.ourcourage.android.util.base.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userInfoUseCase: UserInfoUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<UserInfo>>(UiState.Loading)
    val uiState: StateFlow<UiState<UserInfo>> get() = _uiState

    fun fetchUserInfo() {
        viewModelScope.launch {
            userInfoUseCase.invoke().fold(
                onSuccess = { userInfo ->
                    _uiState.value = UiState.Success(userInfo)
                },
                onFailure = { throwable ->
                    _uiState.value = UiState.Failure(throwable.message)
                }
            )
        }
    }

}