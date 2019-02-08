package io.awesometodolist.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import io.awesometodolist.R
import io.awesometodolist.common.InjectorUtils
import io.awesometodolist.db.Todo
import kotlinx.android.synthetic.main.fragment_todo_list.*

/**
 * Fragment to showcase all the Todos from the data source.
 */
class TodoListFragment : Fragment(), Observer<List<Todo>> {

    private lateinit var mRecyclerAdapter: TodoListAdapter
    private lateinit var viewModel: TodoListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Model
        val factory = InjectorUtils.getViewModelFactory(activity!!)
        viewModel = ViewModelProviders.of(this, factory).get(TodoListViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        toolbar_layout.title = getString(R.string.app_name)

        mRecyclerAdapter = TodoListAdapter()

        rv_todo_list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mRecyclerAdapter
        }

        tv_empty_list.setOnClickListener { view ->
            view.findNavController().navigate(R.id.addTodoFragment)
        }

        fab_new_todo.setOnClickListener { view ->
            view.findNavController().navigate(R.id.addTodoFragment)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_todo_list, container, false)

    override fun onResume() {
        super.onResume()
        // Listen to data change
        viewModel.getAllTodos()?.observe(this, this)
    }

    override fun onChanged(userList: List<Todo>) {
        if (userList.isNotEmpty()) {
            mRecyclerAdapter.submitList(userList)
            rv_todo_list.visibility = View.VISIBLE
            tv_empty_list.visibility = View.GONE
        } else {
            rv_todo_list.visibility = View.GONE
            tv_empty_list.visibility = View.VISIBLE
        }
    }

    override fun onPause() {
        viewModel.getAllTodos()?.removeObserver(this)
        super.onPause()
    }
}
