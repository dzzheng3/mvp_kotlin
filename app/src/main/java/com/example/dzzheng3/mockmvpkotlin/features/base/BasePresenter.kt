package com.example.dzzheng3.mockmvpkotlin.features.base

open class BasePresenter<T : MvpView> : Presenter<T> {
    var mvpView: T? = null
        private set

    override fun attachView(view: T) {
        mvpView = view
    }

    override fun detachView() {
        mvpView = null
    }

    val isViewAttached: Boolean
        get() = mvpView != null

    fun checkViewAttached() {
        if (!isViewAttached) throw MvpNotAttachException()
    }

    private class MvpNotAttachException internal constructor() : RuntimeException(
            "please call attachView before request data from presenter")
}