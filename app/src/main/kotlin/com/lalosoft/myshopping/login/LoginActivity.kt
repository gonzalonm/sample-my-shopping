package com.lalosoft.myshopping.login

import android.os.Bundle
import com.lalosoft.myshopping.BaseActivity
import com.lalosoft.myshopping.R
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

}