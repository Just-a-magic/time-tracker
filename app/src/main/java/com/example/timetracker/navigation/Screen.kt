package com.example.timetracker.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.FormatListBulleted
import androidx.compose.material.icons.filled.DataUsage
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings


sealed class Screen(
    val route: String,
    val title: String,
    val icon: ImageVector? = null,
    val showBottomBar: Boolean,
    val showNewLogAction: Boolean = false
) {
    object Home : Screen(
        route = "home",
        title = "Home",
        icon = Icons.Filled.Home,
        showBottomBar = true,
        showNewLogAction = true
    )
    object Activities : Screen(
        route = "activities",
        title = "Activities",
        icon = Icons.AutoMirrored.Filled.FormatListBulleted,
        showBottomBar = true
    )
    object Statistics : Screen(
        route = "statistics",
        title = "Statistics",
        icon = Icons.Filled.DataUsage,
        showBottomBar = true
    )
    object Settings : Screen(
        route = "settings",
        title = "Settings",
        icon = Icons.Filled.Settings,
        showBottomBar = true
    )

    object NewLog : Screen(
        route = "new log",
        title = "New Log",
        showBottomBar = false
    )

    object NewActivity : Screen(
        route = "new activity",
        title = "New Activity",
        showBottomBar = false
    )
}