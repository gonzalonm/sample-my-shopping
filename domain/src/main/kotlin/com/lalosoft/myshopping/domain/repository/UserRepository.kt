package com.lalosoft.myshopping.domain.repository

import com.lalosoft.myshopping.domain.User

interface UserRepository {
    fun login(user: User, callback: UserDataCallback)
}

interface UserDataCallback {
    fun onLoginSuccess()
    fun onUsernamePasswordNotMatch()
    fun onError(error: String)
}