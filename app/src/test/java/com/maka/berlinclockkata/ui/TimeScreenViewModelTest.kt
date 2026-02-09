package com.maka.berlinclockkata.ui

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import kotlin.test.assertNotEquals

@OptIn(ExperimentalCoroutinesApi::class)
class TimeScreenViewModelTest {

    private val testDispatcher = UnconfinedTestDispatcher()
    private lateinit var viewModel: TimeScreenViewModel

    @Before
    fun Setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = TimeScreenViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `uiState initial value has empty system time`() {
        val initialState = viewModel.uiState.value
        assertEquals("", initialState.systemTime)
    }

    @Test
    fun `uiState is not null`() {
        assertNotNull(viewModel.uiState.value)
    }


}