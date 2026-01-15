package com.example.timetracker.features.activity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ActivitiesViewModel : ViewModel() {

    private val _activities = mutableStateListOf<ActivityModel>()
    val activities: List<ActivityModel> = _activities
    var tempName by mutableStateOf("")

    var selectedActivity by mutableStateOf<ActivityModel?>(null)
        private set

    fun addActivity(name: String) {
        if (name.isNotBlank()) {
            _activities.add(ActivityModel(name = name))
        }
    }

    fun selectActivity(activity: ActivityModel) {
        selectedActivity = activity
    }

    fun deleteSelectedActivity() {
        selectedActivity?.let {
            _activities.remove(it)
        }
        selectedActivity = null
    }

    fun clearSelection() {
        selectedActivity = null
    }
}