package com.example.timetracker.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.timetracker.features.activity.ActivitiesViewModel
import com.example.timetracker.features.log.DatePickerField
import com.example.timetracker.features.log.LogsViewModel
import com.example.timetracker.features.log.TimePickerField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewLogScreen(
    activitiesViewModel: ActivitiesViewModel,
    logsViewModel: LogsViewModel
) {
    var showActivitiesSheet by remember { mutableStateOf(false) }

    if (showActivitiesSheet) {
        ModalBottomSheet(
            onDismissRequest = { showActivitiesSheet = false }
        ) {
            activitiesViewModel.activities.forEach { activity ->
                ListItem(
                    headlineContent = { Text(activity.name) },
                    modifier = Modifier.clickable {
                        logsViewModel.selectedActivity = activity
                        showActivitiesSheet = false
                    }
                )
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = logsViewModel.selectedActivity?.name ?: "",
            onValueChange = {},
            label = { Text(text = "Activity") },
            enabled = false,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { showActivitiesSheet = true }
        )

        Spacer(Modifier.height(12.dp))

        DatePickerField(logsViewModel)

        Spacer(Modifier.height(12.dp))

        TimePickerField(
            label = "Start time",
            time = logsViewModel.startTime,
            onTimeSelected = { logsViewModel.startTime = it }
        )

        Spacer(Modifier.height(12.dp))

        TimePickerField(
            label = "End time",
            time = logsViewModel.endTime,
            onTimeSelected = { logsViewModel.endTime = it }
        )
    }
}