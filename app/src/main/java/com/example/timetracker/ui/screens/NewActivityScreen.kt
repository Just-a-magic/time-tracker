package com.example.timetracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.timetracker.features.activity.ActivitiesViewModel

@Composable
fun NewActivityScreen(viewModel: ActivitiesViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = viewModel.tempName,
            onValueChange = { viewModel.tempName = it },
            label = { Text("Activity name") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}