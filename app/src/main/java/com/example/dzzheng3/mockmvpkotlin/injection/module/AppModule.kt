package com.example.dzzheng3.mockmvpkotlin.injection.module

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = arrayOf(ApiModule::class))
class AppModule(private val mApplication: Application) {
            @Singleton
            @Provides
            fun ProvideApplicationContext(): Application {
                return mApplication
    }
}