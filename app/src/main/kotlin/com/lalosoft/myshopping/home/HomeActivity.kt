package com.lalosoft.myshopping.home

import com.lalosoft.myshopping.BaseActivity
import com.lalosoft.myshopping.R
import com.lalosoft.myshopping.domain.Item
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity<HomePresenter>(), HomeView {

    override fun renderEmpty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun render(list: List<Item>) {
        recycler_view.adapter = HomeAdapter(list)
    }

    override fun getContentViewID() = R.layout.activity_home

    override fun buildPresenter() = HomePresenter(this)
}
