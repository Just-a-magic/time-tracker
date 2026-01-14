package com.example.timetracker.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.timetracker.navigation.NavGraph
import com.example.timetracker.navigation.getScreenByRoute
import com.example.timetracker.ui.components.BottomBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val currentScreen = getScreenByRoute(currentRoute)

    Scaffold(
        topBar = {
            if (currentScreen != null) {
                TopAppBar(
                    title = {
                        Text(text = currentScreen.title)
                    }
                )
            }
        },
        bottomBar = {
            BottomBar(navController = navController)
        }
    ) { paddingValues ->
        NavGraph(
            navController = navController,
            modifier = Modifier.padding(paddingValues)
        )
    }
}