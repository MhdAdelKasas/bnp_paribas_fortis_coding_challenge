package com.maka.berlinclockkata.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class TimeScreenViewModel : ViewModel() {

    private val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")

    private val timeFlow = flow {
        while (true) {
            emit(LocalTime.now())
            delay(1000)
        }
    }

    val uiState: StateFlow<UIState> = flow<UIState> {
        timeFlow.collect { time ->
            emit(
                UIState(
                    systemTime = time.format(timeFormatter)
                )
            )
        }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = UIState()
    )
}