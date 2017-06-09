package com.lalosoft.myshopping.home

import android.view.Menu
import android.view.MenuItem
import com.lalosoft.myshopping.BaseActivity
import com.lalosoft.myshopping.R
import com.lalosoft.myshopping.data.toast
import com.lalosoft.myshopping.domain.Item
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity<HomePresenter>(), HomeView {

    override fun renderError() {
        toast(getString(R.string.render_error))
    }

    override fun renderEmpty() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun render(list: List<Item>) {
        runOnUiThread { recycler_view.adapter = HomeAdapter(list) }
    }

    override fun getContentViewID() = R.layout.activity_home

    override fun buildPresenter() = HomePresenter(this)

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.menu_logout) presenter?.logout()
        return true
    }
}
