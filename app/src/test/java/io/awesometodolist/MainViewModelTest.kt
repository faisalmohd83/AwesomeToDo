package io.awesometodolist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.awesometodolist.db.Todo
import io.awesometodolist.db.TodoDao
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class MainViewModelTest {

    @Suppress("unused")
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun `should add item`() {
        val app: TodoApp = mock()
        val dao: TodoDao = mock()
        whenever(app.dao).thenReturn(dao)
        val vm = MainViewModel(app)
        val todo: Todo = mock()

        vm.addItemOrFabClicked(todo)

        verify(dao).insert(todo)
    }
}
