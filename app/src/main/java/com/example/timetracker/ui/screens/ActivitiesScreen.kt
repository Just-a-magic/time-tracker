package com.example.timetracker.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timetracker.features.activity.ActivitiesViewModel

@Composable
fun ActivitiesScreen(viewModel: ActivitiesViewModel) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(viewModel.activities) { activity ->
            Text(
                text = activity.name,
                modifier = Modifier.padding(16.dp),
                fontSize = 18.sp
            )
        }
    }
}