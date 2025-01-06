package com.example.ourcourage.android.presentation.type

enum class MultiUseType(val id: Int, val multiUseName: String) {
    CUP(1, "컵"),
    BOWL(2, "그릇"),
    LUNCHBOX(3, "도시락"),
    CUTLERY(4, "수저"),
    UNKNOWN(0, "알 수 없음"),
    ;

    companion object {
        fun fromId(id: Int): MultiUseType {
            return values().find { it.id == id } ?: UNKNOWN
        }

        fun fromIdList(idList: List<Long>): List<MultiUseType> {
            return idList.map { fromId(it.toInt()) }
        }
    }
}
