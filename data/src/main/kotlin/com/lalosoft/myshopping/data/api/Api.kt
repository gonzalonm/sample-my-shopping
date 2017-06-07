package com.lalosoft.myshopping.data.api

import com.lalosoft.myshopping.data.toJson

object Api {

    private enum class Method {
        GET, POST, DELETE, PUT
    }

    val JSON: okhttp3.MediaType? = okhttp3.MediaType.parse("application/json; charset=utf-8")

    class ApiResponse<out T>(val success: Boolean = true, val content: T? = null, val error: String = "")

    fun doGetRequest(url: String, callback: (com.lalosoft.myshopping.data.api.Api.ApiResponse<String>) -> Unit) {
        com.lalosoft.myshopping.data.api.Api.doRequest(url = url, method = Method.GET, callback = callback)
    }

    fun doPostRequest(url: String, body: String, callback: (com.lalosoft.myshopping.data.api.Api.ApiResponse<String>) -> Unit) {
        com.lalosoft.myshopping.data.api.Api.doRequest(url, body, Method.POST, callback)
    }

    private fun doRequest(url: String, body: String? = null, method: com.lalosoft.myshopping.data.api.Api.Method, callback: (com.lalosoft.myshopping.data.api.Api.ApiResponse<String>) -> Unit) {
        val client = com.lalosoft.myshopping.data.api.Api.client()

        val request = com.lalosoft.myshopping.data.api.Api.resolveMethod(url, method, body)

        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call?, e: java.io.IOException?) {
                callback(com.lalosoft.myshopping.data.api.Api.ApiResponse<String>(false, error = e.toString()))
            }

            override fun onResponse(call: okhttp3.Call?, response: okhttp3.Response?) {
                val jsonResponse = response?.body()?.string()!!.toJson()
                if (jsonResponse["result"] == "success") {
                    callback(com.lalosoft.myshopping.data.api.Api.ApiResponse(content = jsonResponse.toString()))
                } else {
                    com.lalosoft.myshopping.data.api.Api.ApiResponse<String>(false)
                }
            }
        })
    }

    private fun client() = okhttp3.OkHttpClient()

    private fun resolveMethod(url: String, method: com.lalosoft.myshopping.data.api.Api.Method, body: String? = null): okhttp3.Request {
        val builder = okhttp3.Request.Builder().url(url)
        when (method) {
            com.lalosoft.myshopping.data.api.Api.Method.GET -> return builder.get().build()
            com.lalosoft.myshopping.data.api.Api.Method.POST -> return builder.post(okhttp3.RequestBody.create(com.lalosoft.myshopping.data.api.Api.JSON, body!!)).build()
            com.lalosoft.myshopping.data.api.Api.Method.DELETE -> throw TODO("not implemented")
            com.lalosoft.myshopping.data.api.Api.Method.PUT -> throw TODO("not implemented")
        }
    }

}