package com.maka.berlinclockkata.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SystemTime(
    time: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = time,
        modifier = modifier
    )
}

@Preview
@Composable
private fun SystemTimePreview() {
    SystemTime("15:46:43")
}