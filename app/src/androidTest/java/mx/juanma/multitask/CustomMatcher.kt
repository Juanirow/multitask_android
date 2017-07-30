package mx.juanma.multitask

import android.support.design.widget.TextInputLayout
import android.view.View
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher


/**
 * Created by Juancho on 28/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
object CustomMatcher {
    fun hasTextInputLayoutErrorText(expectedErrorText: String): Matcher<View> {
        return object : TypeSafeMatcher<View>() {

            override
            fun describeTo(description: Description) {

            }

            override
            fun matchesSafely(view: View): Boolean {
                if (view !is TextInputLayout) {
                    return false
                }

                val error = (view as TextInputLayout).error ?: return false

                val hint = error.toString()

                return expectedErrorText == hint
            }
        }
    }
}