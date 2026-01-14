package com.example.timetracker.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.timetracker.navigation.NavGraph
import com.example.timetracker.navigation.Screen
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
            currentScreen?.let { screen ->
                TopAppBar(
                    title = { Text(text = currentScreen.title) },
                    navigationIcon = {
                        if (!screen.showBottomBar) {
                            IconButton(onClick = {
                                navController.popBackStack()
                            }) {
                                Icon(
                                    imageVector = Icons.Filled.ArrowBackIosNew,
                                    contentDescription = "Back"
                                )
                            }
                        }
                    },
                    actions = {
                        if (screen.showNewLogAction) {
                            IconButton(
                                onClick = {
                                    navController.navigate(Screen.NewLog.route)
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Add,
                                    contentDescription = "New Log"
                                )
                            }
                        }
                        if (screen.showNewActivityAction) {
                            IconButton(
                                onClick = {
                                    navController.navigate(Screen.NewActivity.route)
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Add,
                                    contentDescription = "New Activity"
                                )
                            }
                        }
                    }
                )
            }
        },
        bottomBar = {
            if (currentScreen?.showBottomBar == true) {
                BottomBar(navController)
            }
        }
    ) { padding ->
        NavGraph(
            navController = navController,
            modifier = Modifier.padding(padding)
        )
    }
}