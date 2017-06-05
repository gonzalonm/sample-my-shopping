package com.lalosoft.myshopping.login

import com.lalosoft.myshopping.BasePresenter
import com.lalosoft.myshopping.data.LoginCallback
import com.lalosoft.myshopping.data.LoginService
import com.lalosoft.myshopping.data.isEmail

class LoginPresenter(view: LoginView) : BasePresenter(view) {

    val loginService = LoginService()

    fun login(email: String, password: String) {
        if (!email.isEmail()) view.showLoginNotValidError()
        if (password.isEmpty() || password.length < 3) view.showPassNotValidError()

        loginService.login(email, password, object : LoginCallback {
            override fun onSuccess() {
                view.showLoginSuccess()
            }

            override fun onUsernamePasswordNotMatch() {
                view.showUsernamePasswordNotMatchError()
            }

            override fun onError(error: String) {
                view.showError(error)
            }
        })
    }

}