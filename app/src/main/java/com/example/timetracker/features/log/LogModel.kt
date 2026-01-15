package com.example.timetracker.features.log

import com.example.timetracker.features.activity.ActivityModel
import java.time.LocalDate
import java.time.LocalTime

data class LogModel(
    val id: Long = System.currentTimeMillis(),
    val activity: ActivityModel,
    val date: LocalDate,
    val startTime: LocalTime,
    val endTime: LocalTime
)
