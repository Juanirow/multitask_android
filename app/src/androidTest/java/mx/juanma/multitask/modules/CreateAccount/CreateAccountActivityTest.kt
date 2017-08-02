package mx.juanma.multitask.modules.CreateAccount

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
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Juancho on 02/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
@RunWith(AndroidJUnit4::class)
class CreateAccountActivityTest {

    @Rule @JvmField
    val mRule = ActivityTestRule<CreateAccountActivity>(CreateAccountActivity::class.java)

    @Test
    fun shouldSetNullErrorWhenEmailIsEmpty() {
        val error = mRule.activity.resources.getString(R.string.error_email_required)
        onView(withId(R.id.inputEmail)).perform(typeText(""))
        Espresso.closeSoftKeyboard()
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnCreateAccount)).perform(click())
        onView(withId(R.id.labelEmail)).check(matches(CustomMatcher.hasTextInputLayoutErrorText(error)))
    }

    @Test
    fun shouldSetErrorWhenTheEmailIsInvalid() {
        val error = mRule.activity.resources.getString(R.string.error_email_invalid)
        onView(withId(R.id.inputEmail)).perform(typeText("nailah"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.inputPassword)).perform(typeText(""))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnCreateAccount)).perform(click())
        onView(withId(R.id.labelEmail)).check(matches(CustomMatcher.hasTextInputLayoutErrorText(error)))
    }

    @Test
    fun shouldSetErrorWhenPasswordIsEmpty() {
        val error = mRule.activity.resources.getString(R.string.error_password_required)
        onView(withId(R.id.inputEmail)).perform(typeText("nailah@mail.com"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.inputPassword)).perform(typeText(""))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnCreateAccount)).perform(click())
        onView(withId(R.id.labelPassword)).check(matches(CustomMatcher.hasTextInputLayoutErrorText(error)))
    }

    @Test
    fun shouldSetErrorWhenPasswordWrongLength() {
        val error = mRule.activity.resources.getString(R.string.error_password_wrong_length)
        onView(withId(R.id.inputEmail)).perform(typeText("nailah@mail.com"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.inputPassword)).perform(typeText("12345"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnCreateAccount)).perform(click())
        onView(withId(R.id.labelPassword)).check(matches(CustomMatcher.hasTextInputLayoutErrorText(error)))
    }

    @Test
    fun shouldSetErrorWhenPasswordNotMatch() {
        val error = mRule.activity.resources.getString(R.string.error_password_not_match)
        onView(withId(R.id.inputEmail)).perform(typeText("nailah@mail.com"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.inputPassword)).perform(typeText("123456"))
        onView(withId(R.id.inputPasswordAgain)).perform(typeText(""))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnCreateAccount)).perform(click())
        onView(withId(R.id.labelPassword)).check(matches(CustomMatcher.hasTextInputLayoutErrorText(error)))
    }

    @Test
    fun shouldShowServerError() {
        val error = mRule.activity.resources.getString(R.string.error_server_generic)
        onView(withId(R.id.inputEmail)).perform(typeText("nailah@mail.com"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.inputPassword)).perform(typeText("123456"))
        onView(withId(R.id.inputPasswordAgain)).perform(typeText("123456"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnCreateAccount)).perform(click())
        onView(withText(error)).check(matches(allOf(withText(error),
                isDisplayed())))
    }

    @Test
    fun shouldShowUserAlreadyRegister() {
        val error = mRule.activity.resources.getString(R.string.error_user_already_register)
        onView(withId(R.id.inputEmail)).perform(typeText("nailah@mail.com"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.inputPassword)).perform(typeText("223456"))
        onView(withId(R.id.inputPasswordAgain)).perform(typeText("223456"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btnCreateAccount)).perform(click())
        onView(withText(error)).check(matches(allOf(withText(error),
                isDisplayed())))
    }

    @Test
    fun shouldMainScreen() {
        //TODO this test
    }
}