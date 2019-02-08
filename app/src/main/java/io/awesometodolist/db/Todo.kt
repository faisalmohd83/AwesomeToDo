package io.awesometodolist.db

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity class for todo table.
 */
@Entity(tableName = "todo")
data class Todo(val desc: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

