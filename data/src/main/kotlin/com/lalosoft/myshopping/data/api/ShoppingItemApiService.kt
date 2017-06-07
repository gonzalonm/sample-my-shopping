package com.lalosoft.myshopping.data.api

import com.lalosoft.myshopping.domain.Item

class ShoppingItemApiService : BaseApiService() {

    fun getAllItems(callback: ShoppingItemCallback) {
        callback.retrieveItemsSuccess(listOf(
                Item("iPad", "", "http://lorempixel.com/640/480/technics/1/"),
                Item("DJ Console", "", "http://lorempixel.com/640/480/technics/2/"),
                Item("Notebook", "", "http://lorempixel.com/640/480/technics/3/"),
                Item("Capacitor", "", "http://lorempixel.com/640/480/technics/4/"),
                Item("Headphone", "", "http://lorempixel.com/640/480/technics/5/"),
                Item("Headphone Pro", "", "http://lorempixel.com/640/480/technics/6/"),
                Item("Headset bluetooth", "", "http://lorempixel.com/640/480/technics/7/"),
                Item("Capacitor 2", "", "http://lorempixel.com/640/480/technics/8/"),
                Item("Led TV", "", "http://lorempixel.com/640/480/technics/9/"),
                Item("MP3", "", "http://lorempixel.com/640/480/technics/10/")
        ))
    }

}

interface ShoppingItemCallback {
    fun retrieveItemsSuccess(list: List<Item>)
    fun retrieveItemsFailure()
}