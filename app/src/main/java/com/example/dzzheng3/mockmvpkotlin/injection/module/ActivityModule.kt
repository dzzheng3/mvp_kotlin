package com.example.dzzheng3.mockmvpkotlin.injection.module

import android.app.Activity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val mActivity: Activity) {
    @Provides
    internal fun provideActivity(): Activity {
        return mActivity
    }
}