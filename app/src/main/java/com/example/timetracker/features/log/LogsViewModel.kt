package com.example.timetracker.features.log

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.timetracker.features.activity.ActivityModel
import java.time.LocalDate
import java.time.LocalTime

class LogsViewModel : ViewModel() {

    private val _logs = mutableStateListOf<LogModel>()
    val logs: List<LogModel> = _logs

    var selectedActivity by mutableStateOf<ActivityModel?>(null)
    var selectedDate by mutableStateOf<LocalDate?>(null)
    var startTime by mutableStateOf<LocalTime?>(null)
    var endTime by mutableStateOf<LocalTime?>(null)

    fun saveLog() {
        val activity = selectedActivity
        val date = selectedDate
        val start = startTime
        val end = endTime

        if (activity != null && date != null && start != null && end != null) {
            _logs.add(
                LogModel(
                    activity = activity,
                    date = date,
                    startTime = start,
                    endTime = end
                )
            )
            clearForm()
        }
    }

    private fun clearForm() {
        selectedActivity = null
        selectedDate = null
        startTime = null
        endTime = null
    }
}