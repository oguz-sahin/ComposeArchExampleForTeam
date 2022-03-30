package com.example.composearchexampleforteam.ui.screen.addtask

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AddTaskViewModel @Inject constructor() : ViewModel() {

    var taskUiState by mutableStateOf(TaskUiState.initial())
        private set


    fun setSelectedCategory(categoryTypes: CategoryTypes) {
        taskUiState = taskUiState.copy(selectedCategory = categoryTypes)
    }

    fun onTaskNameChanged(name: String) {
        taskUiState = taskUiState.copy(name = name)
    }

    fun onTaskDescriptionChanged(description: String) {
        taskUiState = taskUiState.copy(description = description)
    }


}