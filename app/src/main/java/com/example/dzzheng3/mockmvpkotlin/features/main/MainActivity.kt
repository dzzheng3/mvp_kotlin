package com.example.dzzheng3.mockmvpkotlin.features.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.dzzheng3.mockmvpkotlin.R
import com.zheng.features.common.ErrorView

class MainActivity : AppCompatActivity(), MainMvpView, ErrorView.ErrorListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showPokeman(pokeman: List<String>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress(isShow: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(error: Throwable) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onReloadData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
