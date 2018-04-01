package com.example.dzzheng3.mockmvpkotlin.data

import com.example.dzzheng3.mockmvpkotlin.data.model.Pokemon
import com.example.dzzheng3.mockmvpkotlin.data.remote.PokemonApi
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataManager @Inject constructor(private val mPokemonApi: PokemonApi) {
    fun getPokemonList(limit: Int): Single<List<String>> {
        return mPokemonApi.getPokemonList(limit).toObservable()
                .flatMapIterable { (results) -> results }
                .map { (name) -> name }
                .toList()
    }

    fun getPokemon(name: String): Single<Pokemon> {
        return mPokemonApi.getPokemon(name)
    }
}