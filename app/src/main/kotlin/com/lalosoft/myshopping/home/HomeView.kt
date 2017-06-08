package com.lalosoft.myshopping.home

import com.lalosoft.myshopping.BaseView
import com.lalosoft.myshopping.domain.Item

interface HomeView : BaseView {
    fun render(list: List<Item>)
    fun renderEmpty()
    fun renderError()
}