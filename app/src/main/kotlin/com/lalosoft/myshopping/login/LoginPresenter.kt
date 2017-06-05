package com.lalosoft.myshopping.login

import com.lalosoft.myshopping.BasePresenter
import com.lalosoft.myshopping.isEmail

class LoginPresenter(view: LoginView) : BasePresenter(view) {

    fun login(email: String, password: String) {
        if (!email.isEmail()) view.showLoginNotValidError()
        if (password.isEmpty() || password.length < 3) view.showPassNotValidError()

        // TODO: execute login async
    }

}