package com.maka.berlinclockkata.ui

import com.maka.berlinclockkata.domain.model.BerlinTime
import com.maka.berlinclockkata.domain.model.LightBulbStatus
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

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
    fun `uiState initial value has default BerlinTime`() {
        val initialState = viewModel.uiState.value
        assertEquals(BerlinTime(), initialState.berlinTime)
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

    @Test
    fun `berlinTime in initial state has all lights off`() {
        val berlinTime = viewModel.uiState.value.berlinTime

        assertEquals(LightBulbStatus.OFF, berlinTime.secondsLightBulb)
        assertEquals(4, berlinTime.fiveHoursLightBulbs.count { it == LightBulbStatus.OFF })
        assertEquals(4, berlinTime.oneHoursLightBulbs.count { it == LightBulbStatus.OFF })
        assertEquals(11, berlinTime.fiveMinutesLightBulbs.count { it == LightBulbStatus.OFF })
        assertEquals(4, berlinTime.oneMinuteLightBulbs.count { it == LightBulbStatus.OFF })
    }

    @Test
    fun `fiveHoursLightBulbs has 4 elements`() {
        val size = viewModel.uiState.value.berlinTime.fiveHoursLightBulbs.size
        assertEquals(4, size)
    }

    @Test
    fun `oneHoursLightBulbs has 4 elements`() {
        val size = viewModel.uiState.value.berlinTime.oneHoursLightBulbs.size
        assertEquals(4, size)
    }

    @Test
    fun `fiveMinutesLightBulbs has 11 elements`() {
        val size = viewModel.uiState.value.berlinTime.fiveMinutesLightBulbs.size
        assertEquals(11, size)
    }

    @Test
    fun `oneMinuteLightBulbs has 4 elements`() {
        val size = viewModel.uiState.value.berlinTime.oneMinuteLightBulbs.size
        assertEquals(4, size)
    }
}