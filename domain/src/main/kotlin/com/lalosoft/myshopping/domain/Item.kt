package com.lalosoft.myshopping.domain

import org.json.JSONObject

data class Item(val name: String, val price: Int, val url: String) {

    companion object {
        fun fromJson(json: String): Item {
            val jsonItem = JSONObject(json)
            return Item(jsonItem.getString("name"),
                    jsonItem.getInt("price"),
                    jsonItem.getString("image"))
        }
    }
}
