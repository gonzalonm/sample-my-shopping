package com.lalosoft.myshopping.data

import org.json.JSONObject

class LoginService(val api: Api = Api) {

    val HOST = "http://private-2906ba-myshopping.apiary-mock.com"
    val LOGIN_URL = "$HOST/login"

    fun login(username: String, password: String, callback: LoginCallback) {
        api.doPostRequest(LOGIN_URL, buildJsonBody(username, password), { apiResponse ->
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
        val jsonObject = JSONObject()
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