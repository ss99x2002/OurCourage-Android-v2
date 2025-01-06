package com.example.ourcourage.android.presentation.ui.multiuse.rental

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ourcourage.android.data.model.request.MultiUseRentalRequestDto
import com.example.ourcourage.android.domain.model.RentalDetail
import com.example.ourcourage.android.domain.usecase.RentalMultiUseUseCase
import com.example.ourcourage.android.util.base.UiState
import com.example.ourcourage.android.util.handleApiError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RentalViewModel @Inject constructor(
    private val rentalMultiUseUseCase: RentalMultiUseUseCase
) : ViewModel() {

    private val _rentalUiState = MutableStateFlow<UiState<RentalDetail>>(UiState.Loading)
    val rentalUiState: StateFlow<UiState<RentalDetail>> get() = _rentalUiState

    private val _selectedOptionIndex = MutableStateFlow<Int>(1) // 초기값은 첫 번째 옵션
    val selectedOptionIndex: StateFlow<Int> = _selectedOptionIndex

    fun updateSelectedOption(index: Int) {
        _selectedOptionIndex.value = index
    }

    fun rentalMultiUse(multiUseRentalRequestDto: MultiUseRentalRequestDto) {
        viewModelScope.launch {
            rentalMultiUseUseCase.invoke(multiUseRentalRequestDto).fold(
                onSuccess = { rentalDetail ->
                    _rentalUiState.value = UiState.Success(rentalDetail)
                },
                onFailure = { error ->
                    error.handleApiError("hyeon")
                    _rentalUiState.value = UiState.Failure(error.message)
                }
            )

        }
    }

}