package com.lalosoft.myshopping.data.repository

import com.lalosoft.myshopping.domain.Item
import com.lalosoft.myshopping.domain.repository.ItemDataCallback
import com.lalosoft.myshopping.domain.repository.ItemRepository

class DiskItemRepository : ItemRepository {

    override fun getAllItems(userId: String, callback: ItemDataCallback) {
        callback.retrieveItemsSuccess(listOf(
                Item("iPad", 1, "http://lorempixel.com/640/480/technics/1/"),
                Item("DJ Console", 1, "http://lorempixel.com/640/480/technics/2/"),
                Item("Notebook", 1, "http://lorempixel.com/640/480/technics/3/"),
                Item("Capacitor", 1, "http://lorempixel.com/640/480/technics/4/"),
                Item("Headphone", 1, "http://lorempixel.com/640/480/technics/5/"),
                Item("Headphone Pro", 1, "http://lorempixel.com/640/480/technics/6/"),
                Item("Headset bluetooth", 1, "http://lorempixel.com/640/480/technics/7/"),
                Item("Capacitor 2", 1, "http://lorempixel.com/640/480/technics/8/"),
                Item("Led TV", 1, "http://lorempixel.com/640/480/technics/9/"),
                Item("MP3", 1, "http://lorempixel.com/640/480/technics/10/")
        ))
    }

}