package com.example.timetracker.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.timetracker.features.activity.ActivitiesViewModel
import com.example.timetracker.ui.components.ActivityItem
import com.example.timetracker.ui.components.BottomSheetContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActivitiesScreen(viewModel: ActivitiesViewModel) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )

    val selectedActivity = viewModel.selectedActivity

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            items(viewModel.activities) { activity ->
                ActivityItem(
                    activity = activity,
                    onLongClick = {
                        viewModel.selectActivity(activity)
                    }
                )
            }
        }

        if (selectedActivity != null) {
            ModalBottomSheet(
                onDismissRequest = {
                    viewModel.clearSelection()
                },
                sheetState = sheetState
            ) {
                BottomSheetContent(
                    onDeleteClick = {
                        viewModel.deleteSelectedActivity()
                    }
                )
            }
        }
    }
}