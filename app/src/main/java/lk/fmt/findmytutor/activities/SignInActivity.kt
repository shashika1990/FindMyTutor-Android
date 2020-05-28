package lk.fmt.findmytutor.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_sign_in.*
import lk.fmt.findmytutor.R
import lk.fmt.findmytutor.dto.UserForSignIn
import lk.fmt.findmytutor.helpers.Validation
import lk.fmt.findmytutor.helpers.extensions.snackbarError
import lk.fmt.findmytutor.listeners.APIServiceListener
import lk.fmt.findmytutor.services.api.responsemodels.SignInResponse
import lk.fmt.findmytutor.utils.PreferenceManager

class SignInActivity : AppCompatActivity(), APIServiceListener {

    private val userForSignIn = UserForSignIn()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        initActivity()
    }

    private fun initActivity() {
        btnSignIn?.setOnClickListener { signIn() }
        btnSignUp?.setOnClickListener { btnSignIn?.setVisibility(isVisible = true) }
    }

    private fun signIn() {
        /*if (validateUserInputs()) {
            UserServiceImpl(this).signIn(userForSignIn)
        }*/

        btnSignIn?.setVisibility(isVisible = false)
        spinner?.setVisibility = View.VISIBLE
    }

    private fun validateUserInputs(): Boolean {
        userForSignIn.email = editTxtEmail?.text.toString().trim()
        userForSignIn.password = editTxtpassword.text.toString().trim()

        if (!Validation.isNotNullOrBlank(userForSignIn.email) ||
            !Validation.isNotNullOrBlank(userForSignIn.password)
        ) {
            snackbarError(getString(R.string.blank_field))
            return false
        } else if (!Validation.isValidEmail(userForSignIn.email!!)) {
            snackbarError(getString(R.string.invalid_email))
            return false
        }

        return true
    }

    private fun goToHomeScreen() {
        Intent(this, HomeActivity::class.java).apply {
            this.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(this)
            finish()
        }
    }

    override fun <T> onSuccess(data: T?) {
        data?.let {
            val res = it as SignInResponse

            PreferenceManager.isLoggedIn = true
            PreferenceManager.token = res.token
            PreferenceManager.name = String.format("%s %s", res.user.firstName, res.user.lastName)
            PreferenceManager.email = res.user.email
            PreferenceManager.mobile = res.user.mobile

            goToHomeScreen()
        }

    }

    override fun onFailure(message: String) { snackbarError(message) }

    override fun onError(message: String) { snackbarError(message) }

}