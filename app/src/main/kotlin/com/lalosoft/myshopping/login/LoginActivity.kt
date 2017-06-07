package com.lalosoft.myshopping.login

import android.content.Intent
import android.os.Bundle
import com.lalosoft.myshopping.BaseActivity
import com.lalosoft.myshopping.R
import com.lalosoft.myshopping.data.callTo
import com.lalosoft.myshopping.data.toast
import com.lalosoft.myshopping.home.HomeActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {

    override fun buildPresenter() = LoginPresenter(this)

    override fun getContentViewID() = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        login_button.setOnClickListener {
            val email = email_text_input.text.toString()
            val password = password_text_input.text.toString()
            presenter?.login(email, password)
        }

        remember_login_cb.setOnCheckedChangeListener(presenter)
    }

    override fun clearErrors() {
        email_text_input.error = null
        password_text_input.error = null
    }

    override fun showEmailNotValidError() {
        email_text_input.error = getString(R.string.login_is_not_valid)
    }

    override fun showPassNotValidError() {
        password_text_input.error = getString(R.string.password_is_not_valid)
    }

    override fun showLoginSuccess() {
        callTo(HomeActivity::class.java)
    }

    override fun showUsernamePasswordNotMatchError() {
        toast(getString(R.string.login_do_not_match))
    }

    override fun showError(error: String) {
        toast("Login error: $error")
    }

}