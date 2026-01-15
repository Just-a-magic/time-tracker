package com.example.timetracker.features.log

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDialog
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import java.time.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerField(
    label: String,
    time: LocalTime?,
    onTimeSelected: (LocalTime) -> Unit
) {
    var showPicker by remember { mutableStateOf(false) }

    val timeState = rememberTimePickerState(
        initialHour = time?.hour ?: 12,
        initialMinute = time?.minute ?: 0
    )

    if (showPicker) {
        TimePickerDialog(
            title = {},
            onDismissRequest = { showPicker = false },

            confirmButton = {
                TextButton(
                    onClick = {
                        onTimeSelected(
                            LocalTime.of(
                                timeState.hour,
                                timeState.minute
                            )
                        )
                        showPicker = false
                    }
                ) {
                    Text("OK")
                }
            },

            dismissButton = {
                TextButton(
                    onClick = { showPicker = false }
                ) {
                    Text("Cancel")
                }
            },
        ) {
            TimePicker(state = timeState)
        }
    }

    OutlinedTextField(
        value = time?.toString() ?: "",
        onValueChange = {},
        label = { Text(label) },
        enabled = false,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { showPicker = true }
    )
}