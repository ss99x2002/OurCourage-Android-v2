package com.example.ourcourage.android.presentation.type

enum class MultiUseType (val id: Int, val multiUseName : String){
    CUP (1,"컵"),
    BOWL (2, "그릇"),
    BOX(3, "도시락"),
    CUTLERY(4,"수저"),
    UNKNOWN(0, "알 수 없음");

    companion object {
        fun fromId(id: Int): MultiUseType {
            return values().find { it.id == id } ?: UNKNOWN
        }
    }
}