package mx.juanma.multitask.helpers

import java.util.regex.Pattern


/**
 * Created by Juancho on 27/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
object EmailValidator {

    val REG = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"

    /**
     * Verify if the email is an valid email
     * @param email email to validate
     * *
     * @return true if the email is an valid email
     */
    fun isValid(email: String): Boolean {
        val pattern = Pattern.compile(REG)
        val matcher = pattern.matcher(email)

        return matcher.matches()
    }
}