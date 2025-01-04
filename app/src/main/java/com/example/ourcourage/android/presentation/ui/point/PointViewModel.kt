package com.example.ourcourage.android.presentation.ui.point

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ourcourage.android.domain.model.PointHistory
import com.example.ourcourage.android.domain.usecase.PointHistoryInfoUseCase
import com.example.ourcourage.android.util.base.UiState
import com.example.ourcourage.android.util.handleApiError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class PointViewModel
    @Inject
    constructor(
        private val pointHistoryInfoUseCase: PointHistoryInfoUseCase,
    ) : ViewModel() {
        private var _pointHistoryUiState = MutableStateFlow<UiState<PointHistory>>(UiState.Loading)
        val pointHistoryUiState: StateFlow<UiState<PointHistory>> get() = _pointHistoryUiState

        private var currentPage = 0

        fun fetchPointHistory(loadMore: Boolean = false) {
            checkPlusPage(loadMore)
            viewModelScope.launch {
                pointHistoryInfoUseCase.invoke(page = currentPage, size = PAGE_SIZE).fold(
                    onSuccess = { pointHistoryInfo ->
                        if (loadMore) {
                            addPointHistoryData(pointHistoryInfo)
                        } else {
                            _pointHistoryUiState.value = UiState.Success(pointHistoryInfo)
                        }
                        Log.e("hyeon", "성공 $pointHistoryInfo")
                    },
                    onFailure = { error ->
                        error.handleApiError(tag = "hyeon")
                        _pointHistoryUiState.value = UiState.Failure(error.message)
                    },
                )
            }
        }

        private fun addPointHistoryData(pointHistoryInfo: PointHistory) {
            _pointHistoryUiState.value =
                UiState.Success(
                    (pointHistoryUiState.value as UiState.Success).data.copy(
                        content = (pointHistoryUiState.value as UiState.Success).data.content + pointHistoryInfo.content,
                    ),
                )
        }

        private fun checkPlusPage(loadMore: Boolean) {
            if (loadMore) {
                currentPage++
            } else {
                currentPage = 0
            }
        }

        companion object {
            private const val PAGE_SIZE = 10
        }
    }
