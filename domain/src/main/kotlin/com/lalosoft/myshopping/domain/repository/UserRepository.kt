package com.lalosoft.myshopping.domain.repository

import com.lalosoft.myshopping.domain.User

interface UserRepository {
    fun login(user: User, callback: LoginUserCallback)
    fun logout(token: String, callback: LogoutUserCallback)
}

interface LogoutUserCallback {
    fun onLogoutSuccess()
    fun onLogoutError(error: String)
}

interface LoginUserCallback {
    fun onLoginSuccess(token: String)
    fun onUsernamePasswordNotMatch()
    fun onLoginError(error: String)
}