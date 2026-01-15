package com.example.timetracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.timetracker.features.log.LogsViewModel

@Composable
fun HomeScreen(logsViewModel: LogsViewModel) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(logsViewModel.logs) { log ->
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = log.activity.name)
                Text(text = "${log.date}")
                Text(text = "${log.startTime} - ${log.endTime}")
            }
        }
    }
}