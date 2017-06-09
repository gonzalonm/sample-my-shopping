package com.lalosoft.myshopping.data.repository

import com.lalosoft.myshopping.data.api.Api
import com.lalosoft.myshopping.data.toJson
import com.lalosoft.myshopping.domain.User
import com.lalosoft.myshopping.domain.repository.LoginUserCallback
import com.lalosoft.myshopping.domain.repository.LogoutUserCallback
import com.lalosoft.myshopping.domain.repository.UserRepository

class CloudUserRepository : BaseCloudRepository(), UserRepository {

    val LOGIN_URL = "$HOST/login"
    val LOGOUT_URL = "$HOST/logout"

    override fun login(user: User, callback: LoginUserCallback) {
        Api.doPostRequest(LOGIN_URL, user.toJson(), { apiResponse ->
            if (apiResponse.success) {
                val json = apiResponse.content?.toJson()
                callback.onLoginSuccess(json!!.getString("token"))
            } else {
                if (apiResponse.error.isEmpty()) {
                    callback.onUsernamePasswordNotMatch()
                } else {
                    callback.onLoginError(apiResponse.error)
                }
            }
        })
    }

    override fun logout(token: String, callback: LogoutUserCallback) {
        val url = LOGOUT_URL + "/" + token
        Api.doGetRequest(url, { apiResponse ->
            if (apiResponse.success) {
                callback.onLogoutSuccess()
            } else {
                callback.onLogoutError(apiResponse.error)
            }
        })
    }
}