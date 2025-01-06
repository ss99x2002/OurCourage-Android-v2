package com.example.ourcourage.android.presentation.ui.scan

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ourcourage.android.data.model.request.MultiUseLocationRequestDto
import com.example.ourcourage.android.domain.mapper.toDto
import com.example.ourcourage.android.domain.model.RentalLocationInfo
import com.example.ourcourage.android.domain.usecase.RentalLocationInfoUseCase
import com.example.ourcourage.android.presentation.ui.scan.type.ScanPurpose
import com.example.ourcourage.android.util.base.UiState
import com.example.ourcourage.android.util.handleApiError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScanViewModel @Inject constructor(
    private val rentalLocationInfoUseCase: RentalLocationInfoUseCase
) : ViewModel() {
    private val _scanUiState = MutableStateFlow<UiState<RentalLocationInfo>>(UiState.Loading)
    val scanUiState: StateFlow<UiState<RentalLocationInfo>> get() = _scanUiState

    fun fetchRentalLocationInfo(rentalLocationRequestDto: MultiUseLocationRequestDto) {
        viewModelScope.launch {
            // MultiUseLocationRequestDto로 qrCodeResult를 mapping 로직 추가
            rentalLocationInfoUseCase.invoke(rentalLocationRequestDto).fold(
                onSuccess = { rentalLocationInfo ->
                    _scanUiState.value = UiState.Success(rentalLocationInfo)
                    Log.e("hyeon", "rentalLocationInfo : ${rentalLocationInfo}")
                },
                onFailure = { error ->
                    error.handleApiError("hyeon")
                    _scanUiState.value = UiState.Failure(error.message)
                }
            )
        }
    }

    fun scanQrCodeResult(qrCodeResult: String, scanPurpose: ScanPurpose) {
        viewModelScope.launch {
            when (scanPurpose) {
                ScanPurpose.RENTAL -> {
                    qrCodeResult.toDto<MultiUseLocationRequestDto>()?.let {
                        fetchRentalLocationInfo(it)
                    } ?: run {
                        _scanUiState.value = UiState.Failure("QR코드 정보를 가져오는데 실패했습니다.")
                    }
                }

                ScanPurpose.RETURN -> {

                }
            }
        }

    }
}