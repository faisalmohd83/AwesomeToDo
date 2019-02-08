package io.awesometodolist.common

import android.content.Context
import io.awesometodolist.db.TodoDatabase
import io.awesometodolist.db.TodoRepository

/**
 * Common util for injections at runtime.
 */
object InjectorUtils {

    private fun getTodoRepository(context: Context): TodoRepository {
        return TodoRepository.getInstance(TodoDatabase.getInstance(context).todoDao())
    }

    fun getViewModelFactory(context: Context): ViewModelFactory {
        val repository = getTodoRepository(context)
        return ViewModelFactory(repository)
    }
}