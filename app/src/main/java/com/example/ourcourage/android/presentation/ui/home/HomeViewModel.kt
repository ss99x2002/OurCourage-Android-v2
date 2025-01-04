package com.example.ourcourage.android.presentation.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ourcourage.android.domain.model.HomeUserInfo
import com.example.ourcourage.android.domain.usecase.HomeUserInfoUseCase
import com.example.ourcourage.android.util.base.UiState
import com.example.ourcourage.android.util.handleApiError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val homeUserInfoUseCase: HomeUserInfoUseCase,
    ) : ViewModel() {
        private val _uiState = MutableStateFlow<UiState<HomeUserInfo>>(UiState.Loading)
        val uiState: StateFlow<UiState<HomeUserInfo>> get() = _uiState

        fun fetchUserInfo() {
            viewModelScope.launch {
                homeUserInfoUseCase.invoke().fold(
                    onSuccess = { userInfo ->
                        _uiState.value = UiState.Success(userInfo)
                    },
                    onFailure = { error ->
                        _uiState.value = UiState.Failure(error.message)
                        error.handleApiError(tag = "hyeon")
                    },
                )
            }
        }
    }
