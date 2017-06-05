package com.lalosoft.myshopping.login

import android.os.Bundle
import com.lalosoft.myshopping.BaseActivity
import com.lalosoft.myshopping.R
import com.lalosoft.myshopping.data.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {

    override fun buildPresenter() = LoginPresenter(this)

    override fun getContentViewID() = R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        login_button.setOnClickListener {
            val email = username_text_input.text.toString()
            val password = password_text_input.text.toString()
            presenter?.login(email, password)
        }
    }

    override fun showLoginNotValidError() {
        toast("Login not valid")
    }

    override fun showPassNotValidError() {
        toast("Pass does not have valid format")
    }

    override fun showLoginSuccess() {
        toast("Login success!")
    }

    override fun showUsernamePasswordNotMatchError() {
        toast("Username or password do not match")
    }

    override fun showError(error: String) {
        toast("Login error: $error")
    }

}