package com.lalosoft.myshopping.data.repository

import com.lalosoft.myshopping.data.api.Api
import com.lalosoft.myshopping.domain.User
import com.lalosoft.myshopping.domain.repository.UserDataCallback
import com.lalosoft.myshopping.domain.repository.UserRepository

class CloudUserRepository : BaseCloudRepository(), UserRepository {

    val LOGIN_URL = "$HOST/login"

    override fun login(user: User, callback: UserDataCallback) {
        Api.doPostRequest(LOGIN_URL, buildJsonBody(user.username, user.password), { apiResponse ->
            if (apiResponse.success) {
                callback.onLoginSuccess()
            } else {
                if (apiResponse.error.isEmpty()) {
                    callback.onUsernamePasswordNotMatch()
                } else {
                    callback.onError(apiResponse.error)
                }
            }
        })
    }

    private fun buildJsonBody(username: String, password: String): String {
        val jsonObject = org.json.JSONObject()
        jsonObject.put("username", username)
        jsonObject.put("password", password)
        return jsonObject.toString()
    }
}