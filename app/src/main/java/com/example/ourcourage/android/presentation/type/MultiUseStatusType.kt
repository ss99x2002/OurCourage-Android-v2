package com.example.ourcourage.android.presentation.type

import com.example.ourcourage.android.presentation.type.MultiUseType.UNKNOWN

enum class MultiUseStatusType(val statusType: String, val statusName: String) {
    USING("USING", "사용중"),
    RETURN("RETURN", "반납됨"),
    UNKNOWN("UNKNOWN", "알 수 없음");

    companion object {
        fun fromType(type: String): MultiUseStatusType {
            return MultiUseStatusType.values().find { it.statusType == type } ?: UNKNOWN
        }
    }
}