package com.maka.berlinclockkata.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.maka.berlinclockkata.ui.components.BerlinClockTime
import com.maka.berlinclockkata.ui.components.SystemTime

@Composable
fun TimeScreen(
    uiState: UIState,
    isDarkTheme: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        BerlinClockTime(
            berlinTime = uiState.berlinTime,
            isDarkTheme = isDarkTheme
        )
        Spacer(modifier = Modifier.height(16.dp))

        SystemTime(time = uiState.systemTime)
    }
}