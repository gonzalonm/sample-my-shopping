package com.lalosoft.myshopping.login

import com.lalosoft.myshopping.BaseView

interface LoginView : BaseView {
    fun showEmailNotValidError()
    fun showPassNotValidError()
    fun showLoginSuccess()
    fun showUsernamePasswordNotMatchError()
    fun showError(error: String)
    fun clearErrors()
}