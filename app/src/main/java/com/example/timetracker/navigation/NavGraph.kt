package com.example.timetracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.timetracker.features.activity.ActivitiesViewModel
import com.example.timetracker.features.log.LogsViewModel
import com.example.timetracker.ui.screens.ActivitiesScreen
import com.example.timetracker.ui.screens.HomeScreen
import com.example.timetracker.ui.screens.NewActivityScreen
import com.example.timetracker.ui.screens.NewLogScreen
import com.example.timetracker.ui.screens.SettingsScreen
import com.example.timetracker.ui.screens.StatisticsScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    activitiesViewModel: ActivitiesViewModel,
    logsViewModel: LogsViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier
    ) {
        composable(Screen.Home.route) {
            HomeScreen(logsViewModel)
        }

        composable(Screen.Activities.route) {
            ActivitiesScreen(activitiesViewModel)
        }

        composable(Screen.Statistics.route) {
            StatisticsScreen()
        }

        composable(Screen.Settings.route) {
            SettingsScreen()
        }

        composable(Screen.NewLog.route) {
            NewLogScreen(activitiesViewModel, logsViewModel)
        }

        composable(Screen.NewActivity.route) {
            NewActivityScreen(activitiesViewModel)
        }
    }
}
