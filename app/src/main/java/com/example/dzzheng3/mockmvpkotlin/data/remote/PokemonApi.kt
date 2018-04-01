package com.example.dzzheng3.mockmvpkotlin.data.remote

import com.example.dzzheng3.mockmvpkotlin.data.model.Pokemon
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int): Single<List<Pokemon>>

    @GET("pokemon/{name}")
    fun getPokemon(@Path("name") name: String): Single<Pokemon>
}
