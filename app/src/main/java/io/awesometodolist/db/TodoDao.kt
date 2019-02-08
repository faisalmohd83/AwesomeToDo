package io.awesometodolist.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
abstract class TodoDao {

    @Query("SELECT * FROM todo")
    abstract fun getAllTodos(): LiveData<List<Todo>>

    @Insert
    abstract fun insert(todo: Todo)

}