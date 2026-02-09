package com.maka.berlinclockkata.domain.usecase

import com.maka.berlinclockkata.domain.model.BerlinTime
import com.maka.berlinclockkata.domain.model.LightBulbStatus
import java.time.LocalTime

class ConvertLocalTimeToBerlinTimeUseCase {

    operator fun invoke(time: LocalTime): BerlinTime =
        BerlinTime(
            secondsLightBulb = if (time.second % 2 == 0) LightBulbStatus.ON else LightBulbStatus.OFF,
        )

}
