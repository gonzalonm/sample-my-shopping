package com.lalosoft.myshopping

interface BaseView {
    fun showLoginNotValidError()
    fun showPassNotValidError()
    fun showLoginSuccess()
    fun showUsernamePasswordNotMatchError()
    fun showError(error: String)
}