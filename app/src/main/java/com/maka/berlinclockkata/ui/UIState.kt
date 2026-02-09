package com.maka.berlinclockkata.ui

import com.maka.berlinclockkata.domain.model.BerlinTime

data class UIState(
    val berlinTime: BerlinTime = BerlinTime(),
    val systemTime: String = ""
)