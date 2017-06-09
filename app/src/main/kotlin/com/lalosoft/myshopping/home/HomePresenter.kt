package com.lalosoft.myshopping.home

import com.lalosoft.myshopping.App
import com.lalosoft.myshopping.BasePresenter
import com.lalosoft.myshopping.data.repository.CloudItemRepository
import com.lalosoft.myshopping.data.repository.CloudUserRepository
import com.lalosoft.myshopping.domain.Item
import com.lalosoft.myshopping.domain.repository.ItemDataCallback
import com.lalosoft.myshopping.domain.repository.LogoutUserCallback

class HomePresenter(val view: HomeView) : BasePresenter() {

    val service = CloudItemRepository()
    val userRepository = CloudUserRepository()

    override fun onStart() {
        service.getAllItems(App.get().token, object : ItemDataCallback {
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

    fun logout() {
        userRepository.logout(App.get().token, object : LogoutUserCallback {
            override fun onLogoutSuccess() {
                App.get().token = ""
                App.get().rememberLogin = false
                view.restartApp()
            }

            override fun onLogoutError(error: String) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

}