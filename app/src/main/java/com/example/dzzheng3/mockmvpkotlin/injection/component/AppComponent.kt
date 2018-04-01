package com.example.dzzheng3.mockmvpkotlin.injection.component

import com.example.dzzheng3.mockmvpkotlin.injection.module.AppModule
import dagger.Component

@Component(modules = arrayOf(AppModule::class))
interface AppComponent