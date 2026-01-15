package com.example.timetracker.ui.components

import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.timetracker.features.activity.ActivityModel

@Composable
fun ActivityItem(
    activity: ActivityModel,
    onClickOrLongClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .combinedClickable(
                onClick = onClickOrLongClick,
                onLongClick = onClickOrLongClick
            )
            .padding(16.dp)
    ) {
        Text(
            text = activity.name,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}