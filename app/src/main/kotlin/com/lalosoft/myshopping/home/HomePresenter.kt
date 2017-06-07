package com.lalosoft.myshopping.home

import com.lalosoft.myshopping.BasePresenter
import com.lalosoft.myshopping.data.api.ShoppingItemApiService
import com.lalosoft.myshopping.data.api.ShoppingItemCallback
import com.lalosoft.myshopping.domain.Item

class HomePresenter(val view: HomeView) : BasePresenter() {

    val service = ShoppingItemApiService()

    override fun onStart() {
        service.getAllItems(object : ShoppingItemCallback{
            override fun retrieveItemsSuccess(list: List<Item>) {
                if (list.isEmpty()) {
                    view.renderEmpty()
                } else {
                    view.render(list)
                }
            }

            override fun retrieveItemsFailure() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

}