package com.lalosoft.myshopping

interface BaseView {
    fun showEmailNotValidError()
    fun showPassNotValidError()
    fun showLoginSuccess()
    fun showUsernamePasswordNotMatchError()
    fun showError(error: String)
    fun clearErrors()
}