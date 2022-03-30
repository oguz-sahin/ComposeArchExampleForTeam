package com.example.composearchexampleforteam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composearchexampleforteam.ui.screen.Screen
import com.example.composearchexampleforteam.ui.screen.addtask.AddTaskScreen
import com.example.composearchexampleforteam.ui.screen.addtask.AddTaskViewModel
import com.example.composearchexampleforteam.ui.theme.ComposeArchExampleForTeamTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArchExampleForTeamTheme {
                Scaffold {
                    NavigationComponent()
                }
            }
        }
    }
}

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.AddTask.route
    ) {
        composable(Screen.AddTask.route) {
            val addTaskViewModel = hiltViewModel<AddTaskViewModel>()
            AddTaskScreen(
                navigateDetailScreen = { navController.navigate(Screen.Detail.route) },
                viewModel = addTaskViewModel
            )
        }

        composable(Screen.Detail.route) {

        }
    }
}

