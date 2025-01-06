package com.example.ourcourage.android.presentation.ui.multiuse.returns

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ourcourage.android.domain.model.RentalLocationInfo
import com.example.ourcourage.android.domain.model.ReturnDetail
import com.example.ourcourage.android.domain.model.ReturnLocationInfo
import com.example.ourcourage.android.domain.model.ReturnMultiUse
import com.example.ourcourage.android.domain.repository.MultiUseRepository
import com.example.ourcourage.android.domain.usecase.ReturnLocationInfoUseCase
import com.example.ourcourage.android.domain.usecase.ReturnMultiUseUseCase
import com.example.ourcourage.android.util.base.UiState
import com.example.ourcourage.android.util.handleApiError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReturnViewModel @Inject constructor(
    private val returnLocationInfoUseCase: ReturnLocationInfoUseCase,
    private val returnMultiUseUseCase: ReturnMultiUseUseCase
) : ViewModel() {

    private val _returnUiState = MutableStateFlow<UiState<ReturnMultiUse>>(UiState.Loading)
    val returnUiState: StateFlow<UiState<ReturnMultiUse>> get() = _returnUiState

    private val _locationInfoUiState = MutableStateFlow<UiState<ReturnDetail>>(UiState.Loading)
    val locationInfoUiState: StateFlow<UiState<ReturnDetail>> get() = _locationInfoUiState

    fun fetchLocationInfo(locationId: String) {
        viewModelScope.launch {
            returnLocationInfoUseCase.invoke(locationId).fold(
                onSuccess = { locationInfo ->
                    _locationInfoUiState.value = UiState.Success(locationInfo)
                },
                onFailure = { error ->
                    error.handleApiError("hyeon")
                    _locationInfoUiState.value = UiState.Failure(error.message)
                }
            )
        }
    }
}