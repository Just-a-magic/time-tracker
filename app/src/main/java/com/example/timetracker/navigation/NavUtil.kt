package com.example.timetracker.navigation

fun getScreenByRoute(route: String?): Screen? {
    return when (route) {
        Screen.Home.route -> Screen.Home
        Screen.Activities.route -> Screen.Activities
        Screen.Statistics.route -> Screen.Statistics
        Screen.Settings.route -> Screen.Settings
        Screen.NewLog.route -> Screen.NewLog
        else -> null
    }
}