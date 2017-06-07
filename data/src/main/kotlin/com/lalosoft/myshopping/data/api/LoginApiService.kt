package com.lalosoft.myshopping.data.api

import com.lalosoft.myshopping.data.api.Api.doPostRequest

class LoginApiService : BaseApiService() {

    val LOGIN_URL = "$HOST/login"

    fun login(username: String, password: String, callback: LoginCallback) {
        doPostRequest(LOGIN_URL, buildJsonBody(username, password), { apiResponse ->
            if (apiResponse.success) {
                callback.onSuccess()
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

interface LoginCallback {
    fun onSuccess()
    fun onUsernamePasswordNotMatch()
    fun onError(error: String)
}