package com.maka.berlinclockkata.domain.model

data class BerlinTime(
    val secondsLightBulb: LightBulbStatus = LightBulbStatus.OFF,
    val fiveHoursLightBulbs: List<LightBulbStatus> = List(4) { LightBulbStatus.OFF },
    val oneHoursLightBulbs: List<LightBulbStatus> = List(4) { LightBulbStatus.OFF },
    val fiveMinutesLightBulbs: List<LightBulbStatus> = List(11) { LightBulbStatus.OFF },
    val oneMinuteLightBulbs: List<LightBulbStatus> = List(4) { LightBulbStatus.OFF }
)
