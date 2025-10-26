package com.example.composetodoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composetodoapp.navigation.TodoNavGraph
import com.example.composetodoapp.ui.theme.ComposeTodoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTodoAppTheme {
                val viewModel: com.example.composetodoapp.viewmodel.TaskViewModel = viewModel()
                TodoNavGraph(viewModel)
            }
        }
    }
}
