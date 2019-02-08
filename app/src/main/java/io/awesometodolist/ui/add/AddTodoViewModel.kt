package io.awesometodolist.ui.add

import androidx.lifecycle.ViewModel
import io.awesometodolist.db.TodoRepository

class AddTodoViewModel internal constructor(
        private val repository: TodoRepository
) : ViewModel() {

    fun addNewTodo(desc: String) {
        repository.insertTodo(desc)
    }
}
