package mx.juanma.multitask.helpers

import org.junit.Test
import org.junit.Assert.*

/**
 * Created by Juancho on 27/07/17.
 * Nakva
 * linanjm90@gmail.com
 */
class EmailValidatorTest {

    @Test
    fun shouldReturnFalseWhenEmailEmpty() {
        val email = ""
        val res = EmailValidator.isValid(email)
        assertFalse(res)
    }

    @Test
    fun shouldReturnFalseWhenEmailInvalid() {
        val email = "nailah"
        val res = EmailValidator.isValid(email)
        assertFalse(res)
    }

    @Test
    fun shouldReturnFalseWhenEmailWithoutDomain() {
        val email = "nailah@asd"
        val res = EmailValidator.isValid(email)
        assertFalse(res)
    }

    @Test
    fun shouldReturnTrueWhenEmailValid() {
        val email = "nailah@mail.com"
        val res = EmailValidator.isValid(email)
        assertTrue(res)
    }
}