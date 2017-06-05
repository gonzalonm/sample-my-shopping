package com.lalosoft.myshopping.data

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import org.json.JSONObject
import java.util.regex.Pattern

val EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$"

fun String.isEmail() : Boolean {
    val pattern = Pattern.compile(EMAIL_PATTERN)
    return pattern.matcher(this).matches()
}

fun String.toJson() : JSONObject {
    return JSONObject(this)
}

fun AppCompatActivity.toast(message: String) {
    runOnUiThread {  Toast.makeText(this, message, Toast.LENGTH_SHORT).show() }
}
