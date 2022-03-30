package com.example.composearchexampleforteam.ui.screen.addtask

data class TaskUiState(
    val selectedCategory: CategoryTypes,
    val name: String,
    val description: String
) {
    companion object {
        fun initial() = TaskUiState(
            selectedCategory = CategoryTypes.PERSONAL,
            name = "",
            description = ""
        )
    }
}
