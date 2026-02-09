package com.maka.berlinclockkata.domain.usecase

import com.maka.berlinclockkata.domain.model.BerlinTime
import java.time.LocalTime

class ConvertLocalTimeToBerlinTimeUseCase {

    operator fun invoke(time: LocalTime): BerlinTime =
        BerlinTime(

        )

}
