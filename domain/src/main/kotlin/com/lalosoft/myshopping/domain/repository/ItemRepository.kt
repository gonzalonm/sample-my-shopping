package com.lalosoft.myshopping.domain.repository

interface ItemRepository {
    fun getAllItems(userId: String, callback: com.lalosoft.myshopping.domain.repository.ItemDataCallback)
}

interface ItemDataCallback {
    fun retrieveItemsSuccess(list: List<com.lalosoft.myshopping.domain.Item>)
    fun retrieveItemsFailure()
}