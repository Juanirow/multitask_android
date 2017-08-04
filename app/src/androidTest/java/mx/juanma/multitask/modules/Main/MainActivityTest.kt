package mx.juanma.multitask.modules.Main

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
 * Created by Juancho on 04/08/17.
 * Nakva
 * linanjm90@gmail.com
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule @JvmField
    val mRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun shouldShowLoginActivityWhenUserLogout() {
        onView(allOf(withContentDescription("Open navigation drawer"),
                        withParent(withId(R.id.toolbar)),
                        isDisplayed())).perform(click())

        onView(allOf(withId(R.id.design_menu_item_text),
                withText("Logout"), isDisplayed())).perform(click())

        onView(withText(R.string.login)).check(matches(allOf(withText(R.string.login),
                isDisplayed())))

    }
}