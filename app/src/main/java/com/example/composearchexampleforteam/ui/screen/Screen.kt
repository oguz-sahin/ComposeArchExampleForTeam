package com.example.composearchexampleforteam.ui.screen

sealed class Screen(val route: String) {
    object AddTask : Screen("AddNewTaskScreen")
    object Detail : Screen("Detail")
}
