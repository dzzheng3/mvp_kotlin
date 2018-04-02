package com.example.dzzheng3.mockmvpkotlin.injection.component

import com.example.dzzheng3.mockmvpkotlin.features.base.BaseActivity
import com.example.dzzheng3.mockmvpkotlin.features.main.MainActivity
import com.example.dzzheng3.mockmvpkotlin.injection.module.ActivityModule
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent : AppComponent {
    fun inject(baseActivity: BaseActivity)
    fun inject(mainActivity: MainActivity)
}