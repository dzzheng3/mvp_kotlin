package com.example.dzzheng3.mockmvpkotlin.injection.component

import com.example.dzzheng3.mockmvpkotlin.injection.ConfigPersistent
import com.example.dzzheng3.mockmvpkotlin.injection.module.ActivityModule
import dagger.Component

@ConfigPersistent
@Component(dependencies = arrayOf(AppComponent::class))
interface ConfigPersistentComponent {
    fun activityComponent(activityModule: ActivityModule): ActivityComponent
}