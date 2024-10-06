package com.example.ourcourage.android

import com.example.ourcourage.android.domain.MultiUse

object MultiUseList {
    val multiUseList =
        listOf(
            MultiUse(1, "서울시청", "2021-10-01", "대여중", 1),
            MultiUse(2, "인천시청", "2021-10-02", "대여중", 1),
            MultiUse(1, "서울시청", "2021-10-03", "대여중", 1),
            MultiUse(2, "인천시청", "2021-10-03", "대여중", 1),
            MultiUse(1, "서울시청", "2021-10-04", "대여중", 1),
            MultiUse(1, "서울시청", "2021-10-04", "대여중", 1),
            MultiUse(2, "인천시청", "2021-10-04", "대여중", 1),
            MultiUse(1, "서울시청", "2021-10-05", "대여중", 1),
            MultiUse(2, "인천시청", "2021-10-06", "대여중", 1),
        )
}
