package io.awesometodolist.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.awesometodolist.db.Todo
import io.awesometodolist.db.TodoRepository

/**
 * ViewModel class for {@link TodoListFragment}.
 */
class TodoListViewModel internal constructor(
        repository: TodoRepository
) : ViewModel() {

    private var todoList: LiveData<List<Todo>> = repository.getAllTodos()

    fun getAllTodos(): LiveData<List<Todo>>? {
        return todoList
    }
}