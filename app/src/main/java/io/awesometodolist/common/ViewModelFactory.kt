package io.awesometodolist.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.awesometodolist.db.TodoRepository
import io.awesometodolist.ui.add.AddTodoViewModel
import io.awesometodolist.ui.list.TodoListViewModel

/**
 * Factory class for ViewModels.
 */
class ViewModelFactory(
        private val repository: TodoRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoListViewModel::class.java)) {
            return TodoListViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(AddTodoViewModel::class.java)) {
            return AddTodoViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknown class name")
    }
}