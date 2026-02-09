package com.maka.berlinclockkata.domain.usecase

import com.maka.berlinclockkata.domain.model.BerlinTime
import com.maka.berlinclockkata.domain.model.LightBulbStatus
import java.time.LocalTime

class ConvertLocalTimeToBerlinTimeUseCase {

    operator fun invoke(time: LocalTime): BerlinTime =
        BerlinTime(
            secondsLightBulb = if (time.second % 2 == 0) LightBulbStatus.ON else LightBulbStatus.OFF,
            fiveHoursLightBulbs = createLightBulbsList(4, time.hour / 5),
            oneHoursLightBulbs =createLightBulbsList(4, time.hour % 5),
            fiveMinutesLightBulbs = createLightBulbsList(11, time.minute / 5),
            oneMinuteLightBulbs = createLightBulbsList(4, time.minute % 5)
        )

    private fun createLightBulbsList(size: Int, onCount: Int) =
        List(size) { index ->
            if (index < onCount) LightBulbStatus.ON else LightBulbStatus.OFF
        }
}
