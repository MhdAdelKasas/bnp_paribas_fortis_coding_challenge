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

    // Five Hours Row Tests
    @Test
    fun `five hours row shows 0 lights for hour 0`() {
        val result = useCase(LocalTime.of(0, 0, 0))
        val onCount = result.fiveHoursLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(0, onCount)
    }

    @Test
    fun `five hours row shows 1 light for hour 5`() {
        val result = useCase(LocalTime.of(5, 0, 0))
        val onCount = result.fiveHoursLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(1, onCount)
    }

    @Test
    fun `five hours row shows 2 lights for hour 10`() {
        val result = useCase(LocalTime.of(10, 0, 0))
        val onCount = result.fiveHoursLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(2, onCount)
    }

    @Test
    fun `five hours row shows 3 lights for hour 15`() {
        val result = useCase(LocalTime.of(15, 0, 0))
        val onCount = result.fiveHoursLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(3, onCount)
    }

    @Test
    fun `five hours row shows 4 lights for hour 20`() {
        val result = useCase(LocalTime.of(20, 0, 0))
        val onCount = result.fiveHoursLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(4, onCount)
    }

    @Test
    fun `five hours row shows 4 lights for hour 23`() {
        val result = useCase(LocalTime.of(23, 0, 0))
        val onCount = result.fiveHoursLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(4, onCount)
    }

    // One Hour Row Tests
    @Test
    fun `one hour row shows 0 lights for hour 0`() {
        val result = useCase(LocalTime.of(0, 0, 0))
        val onCount = result.oneHoursLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(0, onCount)
    }

    @Test
    fun `one hour row shows 1 light for hour 1`() {
        val result = useCase(LocalTime.of(1, 0, 0))
        val onCount = result.oneHoursLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(1, onCount)
    }

    @Test
    fun `one hour row shows 4 lights for hour 4`() {
        val result = useCase(LocalTime.of(4, 0, 0))
        val onCount = result.oneHoursLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(4, onCount)
    }

    @Test
    fun `one hour row shows 0 lights for hour 5`() {
        val result = useCase(LocalTime.of(5, 0, 0))
        val onCount = result.oneHoursLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(0, onCount)
    }

    @Test
    fun `one hour row shows 3 lights for hour 23`() {
        val result = useCase(LocalTime.of(23, 0, 0))
        val onCount = result.oneHoursLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(3, onCount)
    }

    // Five Minutes Row Tests
    @Test
    fun `five minutes row shows 0 lights for minute 0`() {
        val result = useCase(LocalTime.of(12, 0, 0))
        val onCount = result.fiveMinutesLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(0, onCount)
    }

    @Test
    fun `five minutes row shows 1 light for minute 5`() {
        val result = useCase(LocalTime.of(12, 5, 0))
        val onCount = result.fiveMinutesLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(1, onCount)
    }

    @Test
    fun `five minutes row shows 6 lights for minute 30`() {
        val result = useCase(LocalTime.of(12, 30, 0))
        val onCount = result.fiveMinutesLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(6, onCount)
    }

    @Test
    fun `five minutes row shows 11 lights for minute 55`() {
        val result = useCase(LocalTime.of(12, 55, 0))
        val onCount = result.fiveMinutesLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(11, onCount)
    }

    @Test
    fun `five minutes row shows 11 lights for minute 59`() {
        val result = useCase(LocalTime.of(12, 59, 0))
        val onCount = result.fiveMinutesLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(11, onCount)
    }

    // One Minute Row Tests
    @Test
    fun `one minute row shows 0 lights for minute 0`() {
        val result = useCase(LocalTime.of(12, 0, 0))
        val onCount = result.oneMinuteLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(0, onCount)
    }

    @Test
    fun `one minute row shows 1 light for minute 1`() {
        val result = useCase(LocalTime.of(12, 1, 0))
        val onCount = result.oneMinuteLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(1, onCount)
    }

    @Test
    fun `one minute row shows 4 lights for minute 4`() {
        val result = useCase(LocalTime.of(12, 4, 0))
        val onCount = result.oneMinuteLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(4, onCount)
    }

    @Test
    fun `one minute row shows 0 lights for minute 5`() {
        val result = useCase(LocalTime.of(12, 5, 0))
        val onCount = result.oneMinuteLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(0, onCount)
    }

    @Test
    fun `one minute row shows 4 lights for minute 59`() {
        val result = useCase(LocalTime.of(12, 59, 0))
        val onCount = result.oneMinuteLightBulbs.count { it == LightBulbStatus.ON }
        assertEquals(4, onCount)
    }
}