package com.example.dzzheng3.mockmvpkotlin.injection.module

import android.content.Context
import com.example.dzzheng3.mockmvpkotlin.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
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

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.POKEAPI_API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}