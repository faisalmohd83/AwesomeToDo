package io.awesometodolist.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import io.awesometodolist.R
import io.awesometodolist.db.Todo

/**
 * Adapter for {@link TodoListFragment}.
 */
class TodoListAdapter : ListAdapter<Todo, TodoListViewHolder>(diffCallback) {

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Todo>() {

            override fun areItemsTheSame(item1: Todo, item2: Todo): Boolean {
                return item1.id == item2.id
            }

            override fun areContentsTheSame(item1: Todo, item2: Todo): Boolean {
                return item1.desc == item2.desc
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, pos: Int): TodoListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return TodoListViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: TodoListViewHolder, pos: Int) {
        val item = getItem(pos)
        viewHolder.tvTodo.text = item.desc
    }
}