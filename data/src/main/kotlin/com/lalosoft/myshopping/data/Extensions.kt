package com.lalosoft.myshopping.data

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.lalosoft.myshopping.domain.Item
import com.lalosoft.myshopping.domain.User
import com.squareup.picasso.Picasso
import org.json.JSONObject
import java.util.regex.Pattern

val EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$"

fun String.isEmail(): Boolean {
    val pattern = Pattern.compile(EMAIL_PATTERN)
    return pattern.matcher(this).matches()
}

fun String.toJson(): JSONObject {
    return JSONObject(this)
}

fun Activity.toast(message: String) {
    runOnUiThread { Toast.makeText(this, message, Toast.LENGTH_SHORT).show() }
}

fun ViewGroup.inflate(resource: Int): View = LayoutInflater.from(context).inflate(resource, this, false)

fun ImageView.load(url: String) {
    if (!url.isEmpty()) Picasso.with(context).load(url).into(this)
}

fun Activity.callTo(clazz: Class<out Activity>) {
    startActivity(Intent(this, clazz))
}

fun User.toJson() : String {
    val jsonObject = JSONObject()
    jsonObject.put("username", username)
    jsonObject.put("password", password)
    return jsonObject.toString()
}