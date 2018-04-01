package com.example.dzzheng3.mockmvpkotlin.features.main

import com.example.dzzheng3.mockmvpkotlin.features.base.MvpView

interface MainMvpView:MvpView{
    fun showPokeman(pokeman:List<String>)
    fun showProgress(isShow:Boolean)
    fun showError(error:Throwable)
}