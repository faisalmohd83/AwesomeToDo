package io.awesometodolist.db

import org.jetbrains.anko.doAsync

/**
 * Repository module for handling data operations.
 */
class TodoRepository private constructor(private val todoDao: TodoDao) {

    fun getAllTodos() = todoDao.getAllTodos()

    fun insertTodo(text: String) {
        doAsync {
            val todo = Todo(desc = text)
            todoDao.insert(todo)
        }
    }

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: TodoRepository? = null

        fun getInstance(todoDao: TodoDao) =
                instance ?: synchronized(this) {
                    instance ?: TodoRepository(todoDao).also { instance = it }
                }
    }

}
