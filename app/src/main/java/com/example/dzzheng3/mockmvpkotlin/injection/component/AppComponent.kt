package com.example.dzzheng3.mockmvpkotlin.injection.component

import com.example.dzzheng3.mockmvpkotlin.data.DataManager
import com.example.dzzheng3.mockmvpkotlin.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun dataManager(): DataManager
}