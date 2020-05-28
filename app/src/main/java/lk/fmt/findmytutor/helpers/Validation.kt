package lk.fmt.findmytutor.helpers

import android.util.Log

object Validation {

    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPasswordLength(password: String): Boolean {
        return password.length >= 8
    }

    fun isValidPassword(password: String): Boolean {
        val regex = """\A(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#${'$'}%^&*]).{8,}\z""".toRegex()
        val matchResult = regex.matchEntire(password)
        Log.d("", "")

        return matchResult != null
    }

    fun isNotNullOrBlank(s: String?): Boolean {
        return s?.isNotBlank() ?: false
    }

}