package com.lalosoft.myshopping.home

import com.lalosoft.myshopping.BasePresenter
import com.lalosoft.myshopping.data.repository.CloudItemRepository
import com.lalosoft.myshopping.domain.Item
import com.lalosoft.myshopping.domain.repository.ItemDataCallback

class HomePresenter(val view: HomeView) : BasePresenter() {

    val service = CloudItemRepository()

    override fun onStart() {
        service.getAllItems("1234", object : ItemDataCallback {
            override fun retrieveItemsSuccess(list: List<Item>) {
                if (list.isEmpty()) {
                    view.renderEmpty()
                } else {
                    view.render(list)
                }
            }

            override fun retrieveItemsFailure() {
                view.renderError()
            }
        })
    }

}