package com.example.composetodoapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composetodoapp.data.Task
import com.example.composetodoapp.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskListScreen(
    viewModel: TaskViewModel,
    onAddClick: () -> Unit
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("My Tasks") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Text("+")
            }
        }
    ) { padding ->
        if (viewModel.tasks.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Text("No tasks yet.")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .padding(16.dp)
            ) {
                items(viewModel.tasks) { task -> TaskItem(task = task, viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun TaskItem(task: Task, viewModel: TaskViewModel) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = if (task.isDone) "✅ ${task.title}" else task.title,
            style = MaterialTheme.typography.bodyLarge)
        Row {
            TextButton(onClick = { viewModel.toggleDone(task) }) {
                Text(if (task.isDone) "Undo" else "Done")
            }
            TextButton(onClick = { viewModel.deleteTask(task) }) {
                Text("Delete")
            }
        }
    }
}
