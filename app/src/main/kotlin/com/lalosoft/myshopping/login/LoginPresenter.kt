package com.lalosoft.myshopping.login

import android.widget.CompoundButton
import com.lalosoft.myshopping.App
import com.lalosoft.myshopping.BasePresenter
import com.lalosoft.myshopping.data.LoginCallback
import com.lalosoft.myshopping.data.LoginService
import com.lalosoft.myshopping.data.isEmail

class LoginPresenter(view: LoginView) : BasePresenter(view), CompoundButton.OnCheckedChangeListener {

    val loginService = LoginService()
    var rememberLogin = false

    override fun onCreate() {
        if (App.get().rememberLogin) {
            // display home activity
            view.showLoginSuccess()
        }
    }

    fun login(email: String, password: String) {
        view.clearErrors()
        if (!email.isEmail()) {
            view.showEmailNotValidError()
        } else if (password.isEmpty() || password.length < 3) {
            view.showPassNotValidError()
        } else {
            loginService.login(email, password, object : LoginCallback {
                override fun onSuccess() {
                    App.get().rememberLogin = rememberLogin
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

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        rememberLogin = isChecked
    }

}