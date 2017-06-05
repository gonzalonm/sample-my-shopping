package com.lalosoft.myshopping

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<T : BasePresenter> : AppCompatActivity() {

    var presenter: T? = null

    abstract fun getContentViewID(): Int
    abstract fun buildPresenter(): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getContentViewID())
        presenter = buildPresenter()
        presenter?.onCreate()
    }

    override fun onStart() {
        super.onStart()
        presenter?.onStart()
    }

    override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter?.onPause()
    }

    override fun onStop() {
        super.onStop()
        presenter?.onStop()
    }

}