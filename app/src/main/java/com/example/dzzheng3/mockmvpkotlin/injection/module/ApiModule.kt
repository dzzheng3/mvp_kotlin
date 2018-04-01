package com.example.dzzheng3.mockmvpkotlin.injection.module

import com.example.dzzheng3.mockmvpkotlin.data.remote.PokemonApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = arrayOf(NetworkModule::class))
class ApiModule {
    @Singleton
    @Provides
    fun providePokemonApi(retrofit: Retrofit): PokemonApi {
        return retrofit.create(PokemonApi::class.java)
    }
}