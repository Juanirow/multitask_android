package mx.juanma.multitask.Login

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import mx.juanma.multitask.CustomMatcher
import mx.juanma.multitask.R
import mx.juanma.multitask.modules.Login.LoginActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by Juancho on 28/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Rule @JvmField
    val mRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java)

    @Test
    fun shouldSetNullErrorWhenEmailIsEmpty() {
        val error = mRule.activity.resources.getString(R.string.error_email_required)
        onView(withId(R.id.inputEmail)).perform(typeText(""))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.inputPassword)).perform(typeText(""))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnLogin)).perform(click())
        onView(withId(R.id.labelEmail)).check(matches(CustomMatcher.hasTextInputLayoutErrorText(error)))
    }

    @Test
    fun shouldSetErrorWhenTheEmailIsInvalid() {
        val error = mRule.activity.resources.getString(R.string.error_email_invalid)
        onView(withId(R.id.inputEmail)).perform(typeText("nailah"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.inputPassword)).perform(typeText(""))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnLogin)).perform(click())
        onView(withId(R.id.labelEmail)).check(matches(CustomMatcher.hasTextInputLayoutErrorText(error)))
    }

    @Test
    fun shouldSetErrorWhenPasswordIsEmpty() {
        val error = mRule.activity.resources.getString(R.string.error_password_required)
        onView(withId(R.id.inputEmail)).perform(typeText("nailah@mail.com"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.inputPassword)).perform(typeText(""))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnLogin)).perform(click())
        onView(withId(R.id.labelPassword)).check(matches(CustomMatcher.hasTextInputLayoutErrorText(error)))
    }

    @Test
    fun shouldSetErrorWhenPasswordWrongLength() {
        val error = mRule.activity.resources.getString(R.string.error_password_required)
        onView(withId(R.id.inputEmail)).perform(typeText("nailah@mail.com"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.inputPassword)).perform(typeText("12345"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnLogin)).perform(click())
        onView(withId(R.id.labelPassword)).check(matches(CustomMatcher.hasTextInputLayoutErrorText(error)))
    }

}