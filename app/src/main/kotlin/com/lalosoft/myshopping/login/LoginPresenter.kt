package com.lalosoft.myshopping.login

import android.widget.CompoundButton
import com.lalosoft.myshopping.App
import com.lalosoft.myshopping.BasePresenter
import com.lalosoft.myshopping.data.api.LoginApiService
import com.lalosoft.myshopping.data.api.LoginCallback
import com.lalosoft.myshopping.data.isEmail

class LoginPresenter(val view: LoginView) : BasePresenter(), CompoundButton.OnCheckedChangeListener {

    val loginService = LoginApiService()
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