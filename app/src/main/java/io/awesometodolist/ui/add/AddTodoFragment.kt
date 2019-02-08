package io.awesometodolist.ui.add

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import io.awesometodolist.R
import io.awesometodolist.common.InjectorUtils
import kotlinx.android.synthetic.main.fragment_add_todo.*

/**
 * Fragment to add new todos.
 */
class AddTodoFragment : Fragment(), TextWatcher {

    private lateinit var viewModel: AddTodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Model
        val factory = InjectorUtils.getViewModelFactory(activity!!)
        viewModel = ViewModelProviders.of(this, factory).get(AddTodoViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_todo, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        img_close.setOnClickListener { finishUI() }

        btn_add_todo.setOnClickListener {
            viewModel.addNewTodo(et_new_todo.text.toString())
            finishUI()
        }
    }

    override fun onResume() {
        super.onResume()
        et_new_todo.addTextChangedListener(this)
    }

    private fun finishUI() {
        activity?.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
        et_new_todo.removeTextChangedListener(this)
    }

    // callbacks
    override fun afterTextChanged(s: Editable?) {
        // Do nothing
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        // Do nothing
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        btn_add_todo.isEnabled = count > 0
    }
}
