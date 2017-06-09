package com.lalosoft.myshopping.data.repository

import com.lalosoft.myshopping.domain.Item
import com.lalosoft.myshopping.domain.repository.ItemDataCallback
import com.lalosoft.myshopping.domain.repository.ItemRepository
import org.json.JSONObject

class CloudItemRepository : BaseCloudRepository(), ItemRepository {

    val ITEMS_URL = "$HOST/items"

    override fun getAllItems(userId: String, callback: ItemDataCallback) {
        val url = ITEMS_URL + "/" + userId
        api.doGetRequest(url, { apiResponse ->
            if (apiResponse.success) {
                callback.retrieveItemsSuccess(convertToList(apiResponse.content))
            } else {
                callback.retrieveItemsFailure()
            }
        })
    }

    private fun convertToList(content: String?): List<Item> {
        val list = arrayListOf<Item>()
        val json = JSONObject(content)
        val jsonArray = json.getJSONArray("items")
        var pos = 0
        while (pos < jsonArray.length()) {
            val jsonItem = jsonArray.getJSONObject(pos)
            list.add(Item.fromJson(jsonItem.toString()))
            pos++
        }
        return list
    }
}