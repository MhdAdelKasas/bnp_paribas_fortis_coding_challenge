package com.maka.berlinclockkata.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.maka.berlinclockkata.domain.model.BerlinTime
import kotlin.rem

@Composable
fun BerlinClockTime(
    berlinTime: BerlinTime,
    isDarkTheme: Boolean,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        // seconds light bulb
        LightBulb(
            status = berlinTime.secondsLightBulb,
            onColor = Color.Yellow,
            isDarkTheme = isDarkTheme,
            shape = CircleShape,
            modifier = Modifier.size(56.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // five hours row
        LightBulbRow(
            lightBulbs = berlinTime.fiveHoursLightBulbs,
            onColor = { Color.Red },
            isDarkTheme = isDarkTheme
        )
        Spacer(modifier = Modifier.height(8.dp))

        // one hour row
        LightBulbRow(
            lightBulbs = berlinTime.oneHoursLightBulbs,
            onColor = { Color.Red },
            isDarkTheme = isDarkTheme
        )
        Spacer(modifier = Modifier.height(8.dp))

        // five minutes row
        LightBulbRow(
            lightBulbs = berlinTime.fiveMinutesLightBulbs,
            onColor = { index -> if ((index + 1) % 3 == 0) Color.Red else Color.Yellow },
            isDarkTheme = isDarkTheme
        )
        Spacer(modifier = Modifier.height(8.dp))

        // one minute row
        LightBulbRow(
            lightBulbs = berlinTime.oneMinuteLightBulbs,
            onColor = { Color.Yellow },
            isDarkTheme = isDarkTheme
        )
    }
}
