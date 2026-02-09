package com.maka.berlinclockkata.domain.usecase

import com.maka.berlinclockkata.domain.model.LightBulbStatus
import org.junit.Before
import org.junit.Test
import java.time.LocalTime
import kotlin.test.assertEquals

class ConvertLocalTimeToBerlinTimeUseCaseTest {

    private lateinit var useCase: ConvertLocalTimeToBerlinTimeUseCase

    @Before
    fun setUp() {
        useCase = ConvertLocalTimeToBerlinTimeUseCase()
    }

    // Seconds Light Bulb Tests
    @Test
    fun `seconds light bulb is ON when seconds are even (0)`() {
        val result = useCase(LocalTime.of(12, 30, 0))
        assertEquals(LightBulbStatus.ON, result.secondsLightBulb)
    }

    @Test
    fun `seconds light bulb is OFF when seconds are odd (1)`() {
        val result = useCase(LocalTime.of(12, 30, 1))
        assertEquals(LightBulbStatus.OFF, result.secondsLightBulb)
    }

    @Test
    fun `seconds light bulb is ON when seconds are even (58)`() {
        val result = useCase(LocalTime.of(12, 30, 58))
        assertEquals(LightBulbStatus.ON, result.secondsLightBulb)
    }

    @Test
    fun `seconds light bulb is OFF when seconds are odd (59)`() {
        val result = useCase(LocalTime.of(12, 30, 59))
        assertEquals(LightBulbStatus.OFF, result.secondsLightBulb)
    }
}