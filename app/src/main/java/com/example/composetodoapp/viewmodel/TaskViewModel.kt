package com.example.composetodoapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.composetodoapp.data.Task

class TaskViewModel: ViewModel()
{
    private var nextId = 0
    private val _tasks = mutableStateListOf<Task>()
    val tasks : List<Task> = _tasks

    fun addTask(title:String)
    {
        if(title.isNotBlank())
        {
            _tasks.add(Task(id=nextId++,title= title))
        }
    }

    fun deleteTask(task: Task)
    {
        _tasks.remove(task)
    }

    // to toggle the task to Done
    fun toggleDone(task: Task) {
        val index = _tasks.indexOf(task)
        if (index != -1) {
            _tasks[index] = _tasks[index].copy(isDone = !task.isDone)
        }
    }

}