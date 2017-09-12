package mx.juanma.multitask.modules.AddCategory

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import mx.juanma.multitask.CustomMatcher
import mx.juanma.multitask.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Juancho on 12/09/17.
 * Nakva
 * linanjm90@gmail.com
 */
@RunWith(AndroidJUnit4::class)
class AddCategoryActivityTest {

    @Rule @JvmField
    val mRule = ActivityTestRule<AddCategoryActivity>(AddCategoryActivity::class.java)

    @Test
    fun shouldSetNullErrorWhenNameIsEmpty() {
        val error = mRule.activity.resources.getString(R.string.error_category_required)
        onView(withId(R.id.inputName)).perform(typeText(""))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.fabOk)).perform(click())
        onView(withId(R.id.labelName)).check(matches(CustomMatcher.hasTextInputLayoutErrorText(error)))
    }

    @Test
    fun shouldShowSessionExpiredError() {
        val error = mRule.activity.resources.getString(R.string.error_expired_session)
        onView(withId(R.id.inputName)).perform(typeText("test_expiredSession"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.fabOk)).perform(click())
        onView(withText(error)).check(matches(allOf(withText(error),
                isDisplayed())))
    }

    @Test
    fun shouldShowInternalServerError() {
        val error = mRule.activity.resources.getString(R.string.error_server_generic)
        onView(withId(R.id.inputName)).perform(typeText("test_server"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.fabOk)).perform(click())
        onView(withText(error)).check(matches(allOf(withText(error),
                isDisplayed())))
    }
}