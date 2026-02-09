package com.maka.berlinclockkata.domain.usecase

import com.maka.berlinclockkata.domain.model.BerlinTime
import com.maka.berlinclockkata.domain.model.LightBulbStatus
import java.time.LocalTime

class ConvertLocalTimeToBerlinTimeUseCase {

    operator fun invoke(time: LocalTime): BerlinTime =
        BerlinTime(
            secondsLightBulb = if (time.second % 2 == 0) LightBulbStatus.ON else LightBulbStatus.OFF,
            fiveHoursLightBulbs = List(4) { index ->
                if (index < time.hour / 5) LightBulbStatus.ON else LightBulbStatus.OFF
            },
            oneHoursLightBulbs = List(4) { index ->
                if(index < time.hour % 5) LightBulbStatus.ON else LightBulbStatus.OFF
            },
            fiveMinutesLightBulbs = List(11) { index ->
                if (index < time.minute / 5) LightBulbStatus.ON else LightBulbStatus.OFF
            }
        )

}
