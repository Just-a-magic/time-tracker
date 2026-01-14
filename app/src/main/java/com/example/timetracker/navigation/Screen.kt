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
    val icon: ImageVector? = null
) {
    object Home : Screen(
        "home",
        "Home",
        icon = Icons.Filled.Home
    )
    object Activities : Screen(
        "activities",
        "Activities",
        icon = Icons.AutoMirrored.Filled.FormatListBulleted
    )
    object Statistics : Screen(
        "statistics",
        "Statistics",
        icon = Icons.Filled.DataUsage
    )
    object Settings : Screen(
        "settings",
        "Settings",
        icon = Icons.Filled.Settings
    )

    object NewLog : Screen(
        "new log",
        "New Log"
    )

    object NewActivity : Screen(
        "new activity",
        "New Activity"
    )
}