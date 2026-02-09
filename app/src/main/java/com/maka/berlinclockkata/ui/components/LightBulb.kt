package com.maka.berlinclockkata.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.maka.berlinclockkata.domain.model.LightBulbStatus

@Composable
fun LightBulb(
    status: LightBulbStatus,
    shape: Shape,
    isDarkTheme: Boolean,
    onColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(shape)
            .border(
                width = 2.dp,
                color = if (isDarkTheme) Color.White else Color.Black,
                shape = shape
            )
            .background(
                color = when (status) {
                    LightBulbStatus.ON -> onColor
                    LightBulbStatus.OFF -> Color.Transparent
                }
            )
    )
}