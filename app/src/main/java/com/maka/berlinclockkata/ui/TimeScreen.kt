package com.maka.berlinclockkata.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.maka.berlinclockkata.ui.components.SystemTime

@Composable
fun TimeScreen(
    uiState: UIState,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth(),
    ) {
        SystemTime(time = uiState.systemTime)
    }
}