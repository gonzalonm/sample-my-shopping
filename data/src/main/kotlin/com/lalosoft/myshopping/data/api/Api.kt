package com.lalosoft.myshopping.data.api

import com.lalosoft.myshopping.data.toJson
import okhttp3.*
import java.io.IOException

object Api {

    private enum class Method {
        GET, POST, DELETE, PUT
    }

    val JSON: MediaType? = MediaType.parse("application/json; charset=utf-8")

    class ApiResponse<out T>(val success: Boolean = true, val content: T? = null, val error: String = "")

    fun doGetRequest(url: String, callback: (ApiResponse<String>) -> Unit) {
        doRequest(url = url, method = Method.GET, callback = callback)
    }

    fun doPostRequest(url: String, body: String, callback: (ApiResponse<String>) -> Unit) {
        doRequest(url, body, Method.POST, callback)
    }

    private fun doRequest(url: String, body: String? = null, method: Method, callback: (ApiResponse<String>) -> Unit) {
        val client = client()

        val request = resolveMethod(url, method, body)

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                callback(ApiResponse<String>(false, error = e.toString()))
            }

            override fun onResponse(call: Call?, response: Response?) {
                val jsonResponse = response?.body()?.string()!!.toJson()
                if (jsonResponse["result"] == "success") {
                    callback(ApiResponse(content = jsonResponse.toString()))
                } else {
                    ApiResponse<String>(false)
                }
            }
        })
    }

    private fun client() = OkHttpClient()

    private fun resolveMethod(url: String, method: Method, body: String? = null): Request {
        val builder = Request.Builder().url(url)
        when (method) {
            Method.GET -> return builder.get().build()
            Method.POST -> return builder.post(RequestBody.create(JSON, body!!)).build()
            Method.DELETE -> throw TODO("not implemented")
            Method.PUT -> throw TODO("not implemented")
        }
    }

}