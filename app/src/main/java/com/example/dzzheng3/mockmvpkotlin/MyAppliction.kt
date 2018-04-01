package com.example.dzzheng3.mockmvpkotlin

import android.app.Application
import com.example.dzzheng3.mockmvpkotlin.injection.component.AppComponent
import com.example.dzzheng3.mockmvpkotlin.injection.component.DaggerAppComponent
import com.example.dzzheng3.mockmvpkotlin.injection.module.AppModule
import com.example.dzzheng3.mockmvpkotlin.injection.module.NetworkModule
import com.singhajit.sherlock.core.Sherlock
import com.squareup.leakcanary.LeakCanary

class MyAppliction : Application() {
    internal var mAppComponent: AppComponent? = null
    var component: AppComponent
        get() {
            if (mAppComponent == null) {
                mAppComponent = DaggerAppComponent.builder()
                        .appModule(AppModule(this))
                        .networkModule(NetworkModule(this))
                        .build()
            }
            return mAppComponent as AppComponent
        }
        set(value) {}

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this)
            Sherlock.init(this)
        }
    }
}