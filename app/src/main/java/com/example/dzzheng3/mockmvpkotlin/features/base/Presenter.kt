package com.example.dzzheng3.mockmvpkotlin.features.base

interface Presenter<V:MvpView>{
    fun attachView(view:V)
    fun detachView()
}