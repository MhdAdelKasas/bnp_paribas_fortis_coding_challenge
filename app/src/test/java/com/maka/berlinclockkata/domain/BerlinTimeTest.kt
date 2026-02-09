package com.maka.berlinclockkata.domain

import com.maka.berlinclockkata.domain.model.BerlinTime
import com.maka.berlinclockkata.domain.model.LightBulbStatus
import org.junit.Test
import kotlin.test.assertEquals

class BerlinTimeTest {

    @Test
    fun `default BerlinTime has secondsLightBulb OFF`() {
        val berlinTime = BerlinTime()
        assertEquals(LightBulbStatus.OFF, berlinTime.secondsLightBulb)
    }

    @Test
    fun `default BerlinTime has 4 fiveHoursLightBulbs all OFF`() {
        val berlinTime = BerlinTime()
        assertEquals(4, berlinTime.fiveHoursLightBulbs.size)
        assertEquals(4, berlinTime.fiveHoursLightBulbs.count { it == LightBulbStatus.OFF })
    }

    @Test
    fun `default BerlinTime has 4 oneHoursLightBulbs all OFF`() {
        val berlinTime = BerlinTime()
        assertEquals(4, berlinTime.oneHoursLightBulbs.size)
        assertEquals(4, berlinTime.oneHoursLightBulbs.count { it == LightBulbStatus.OFF })
    }

    @Test
    fun `default BerlinTime has 11 fiveMinutesLightBulbs all OFF`() {
        val berlinTime = BerlinTime()
        assertEquals(11, berlinTime.fiveMinutesLightBulbs.size)
        assertEquals(11, berlinTime.fiveMinutesLightBulbs.count { it == LightBulbStatus.OFF })
    }

    @Test
    fun `default BerlinTime has 4 oneMinuteLightBulbs all OFF`() {
        val berlinTime = BerlinTime()
        assertEquals(4, berlinTime.oneMinuteLightBulbs.size)
        assertEquals(4, berlinTime.oneMinuteLightBulbs.count { it == LightBulbStatus.OFF })
    }

    @Test
    fun `BerlinTime can be created with custom values`() {
        val berlinTime = BerlinTime(
            secondsLightBulb = LightBulbStatus.ON,
            fiveHoursLightBulbs = listOf(
                LightBulbStatus.ON,
                LightBulbStatus.ON,
                LightBulbStatus.OFF,
                LightBulbStatus.OFF
            ),
            oneHoursLightBulbs = listOf(
                LightBulbStatus.OFF,
                LightBulbStatus.OFF,
                LightBulbStatus.OFF,
                LightBulbStatus.OFF
            ),
            fiveMinutesLightBulbs = listOf(
                LightBulbStatus.ON, LightBulbStatus.ON, LightBulbStatus.ON,
                LightBulbStatus.ON, LightBulbStatus.ON, LightBulbStatus.ON,
                LightBulbStatus.ON, LightBulbStatus.ON, LightBulbStatus.OFF,
                LightBulbStatus.OFF, LightBulbStatus.OFF,
            ),
            oneMinuteLightBulbs = listOf(
                LightBulbStatus.ON,
                LightBulbStatus.ON,
                LightBulbStatus.OFF,
                LightBulbStatus.OFF
            )
        )

        assertEquals(LightBulbStatus.ON, berlinTime.secondsLightBulb)
        assertEquals(2, berlinTime.fiveHoursLightBulbs.count { it == LightBulbStatus.ON })
        assertEquals(0, berlinTime.oneHoursLightBulbs.count { it == LightBulbStatus.ON })
        assertEquals(8, berlinTime.fiveMinutesLightBulbs.count { it == LightBulbStatus.ON })
        assertEquals(2, berlinTime.oneMinuteLightBulbs.count { it == LightBulbStatus.ON })
    }
}