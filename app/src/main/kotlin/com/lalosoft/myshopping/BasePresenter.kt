package com.lalosoft.myshopping

abstract class BasePresenter(val view: BaseView) {

    open fun onCreate() {
        // to be implemented by sub-classes
    }

    open fun onStart() {
        // to be implemented by sub-classes
    }

    open fun onResume() {
        // to be implemented by sub-classes
    }

    open fun onPause() {
        // to be implemented by sub-classes
    }

    open fun onStop() {
        // to be implemented by sub-classes
    }

}
