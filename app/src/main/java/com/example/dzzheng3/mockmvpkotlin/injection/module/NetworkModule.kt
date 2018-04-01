package com.example.dzzheng3.mockmvpkotlin.injection.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class NetworkModule(private var context: Context) {
    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideChuckIntercepter(): ChuckInterceptor {
        return ChuckInterceptor(context)
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(chuckInterceptor: ChuckInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(chuckInterceptor).build()
    }
}