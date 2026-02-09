package com.maka.berlinclockkata.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.maka.berlinclockkata.domain.model.LightBulbStatus

@Composable
fun LightBulbRow(
    lightBulbs: List<LightBulbStatus>,
    onColor: (Int) -> Color,
    isDarkTheme: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        lightBulbs.forEachIndexed { index, status ->
            LightBulb(
                status = status,
                onColor = onColor(index),
                isDarkTheme = isDarkTheme,
                shape = when (index) {
                    0 -> RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp)
                    lightBulbs.lastIndex -> RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp)
                    else -> RectangleShape
                },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            )
        }
    }
}
