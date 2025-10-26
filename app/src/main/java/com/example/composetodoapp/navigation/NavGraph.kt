package com.example.composetodoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetodoapp.ui.screens.AddTaskScreen
import com.example.composetodoapp.ui.screens.TaskListScreen
import com.example.composetodoapp.viewmodel.TaskViewModel

@Composable
fun TodoNavGraph(viewModel: TaskViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "list") {
        composable("list") {
            TaskListScreen(viewModel) {
                navController.navigate("add")
            }
        }
        composable("add") {
            AddTaskScreen(viewModel) {
                navController.popBackStack()
            }
        }
    }
}
