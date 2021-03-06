package io.awesometodolist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.awesometodolist.db.Todo
import io.awesometodolist.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@Suppress("UNCHECKED_CAST")
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule<MainActivity>(MainActivity::class.java, false, false)

    @Test
    fun shouldAddItem() {
        val app = InstrumentationRegistry.getTargetContext().applicationContext as Todo
        val vm: MainViewModelTest = mock()
        app.viewModelFactory = object : ViewModelProvider.AndroidViewModelFactory(app) {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return vm as T
            }
        }
        val items = MutableLiveData<List<Todo>>()
        whenever(vm.items).thenReturn(items)
        rule.launchActivity(null)

        onView(withId(R.id.fab)).perform(click())

        verify(vm).addItemOrFabClicked(any())
    }

}
