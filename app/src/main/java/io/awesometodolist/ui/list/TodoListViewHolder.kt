package io.awesometodolist.ui.list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*

/**
 * View holder for {@link TodoListAdapter}.
 */
class TodoListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var tvTodo = itemView.tv_todo!!
}
