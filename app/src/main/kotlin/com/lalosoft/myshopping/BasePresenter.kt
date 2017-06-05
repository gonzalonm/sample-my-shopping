package com.lalosoft.myshopping

abstract class BasePresenter(val view: BaseView) {

    fun onCreate() {
        // to be implemented by sub-classes
    }

    fun onStart() {
        // to be implemented by sub-classes
    }

    fun onResume() {
        // to be implemented by sub-classes
    }

    fun onPause() {
        // to be implemented by sub-classes
    }

    fun onStop() {
        // to be implemented by sub-classes
    }

}
