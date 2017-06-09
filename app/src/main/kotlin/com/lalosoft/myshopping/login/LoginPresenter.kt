package com.lalosoft.myshopping.login

import android.widget.CompoundButton
import com.lalosoft.myshopping.App
import com.lalosoft.myshopping.BasePresenter
import com.lalosoft.myshopping.data.isEmail
import com.lalosoft.myshopping.data.repository.CloudUserRepository
import com.lalosoft.myshopping.domain.User
import com.lalosoft.myshopping.domain.repository.LoginUserCallback

class LoginPresenter(val view: LoginView) : BasePresenter(), CompoundButton.OnCheckedChangeListener {

    val userRepository = CloudUserRepository()
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
            userRepository.login(User(email, password), object : LoginUserCallback {
                override fun onLoginSuccess(token: String) {
                    App.get().rememberLogin = rememberLogin
                    App.get().token = token
                    view.showLoginSuccess()
                }

                override fun onUsernamePasswordNotMatch() {
                    view.showUsernamePasswordNotMatchError()
                }

                override fun onLoginError(error: String) {
                    view.showError(error)
                }
            })
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        rememberLogin = isChecked
    }

}