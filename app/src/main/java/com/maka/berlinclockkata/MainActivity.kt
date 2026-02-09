package com.maka.berlinclockkata

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.maka.berlinclockkata.ui.TimeScreen
import com.maka.berlinclockkata.ui.TimeScreenViewModel
import com.maka.berlinclockkata.ui.theme.BerlinClockKataTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val viewModel by inject<TimeScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()

            BerlinClockKataTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TimeScreen(
                        uiState = uiState,
                        isDarkTheme = isSystemInDarkTheme(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
