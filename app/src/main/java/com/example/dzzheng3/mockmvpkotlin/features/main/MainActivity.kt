package com.example.dzzheng3.mockmvpkotlin.features.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.dzzheng3.mockmvpkotlin.R
import com.example.dzzheng3.mockmvpkotlin.features.base.BaseActivity
import com.zheng.features.common.ErrorView
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainMvpView, ErrorView.ErrorListener {
    override val layout: Int
        get() = R.layout.activity_main
    @Inject
    lateinit var mainPresenter: MainPresenter
    @Inject
    lateinit var pokemonAdapter: PokemonAdapter

    companion object {

        private val POKEMON_COUNT = 20
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent().inject(this)
        mainPresenter.attachView(this)
        setSupportActionBar(toolbar)
        swipe_to_refresh.setProgressBackgroundColorSchemeResource(R.color.primary)
        swipe_to_refresh.setColorSchemeResources(R.color.white)
        swipe_to_refresh.setOnRefreshListener {
            mainPresenter.getPokemon(POKEMON_COUNT)
        }
        recycler_pokemon.layoutManager = LinearLayoutManager(this)
        recycler_pokemon.adapter = pokemonAdapter
        view_error.setErrorListener(this)
        mainPresenter.getPokemon(POKEMON_COUNT)

    }

    override fun showPokeman(pokemans: List<String>) {
        pokemonAdapter.setPokemon(pokemans)
        pokemonAdapter.notifyDataSetChanged()
        recycler_pokemon.visibility = View.VISIBLE
        swipe_to_refresh.visibility = View.VISIBLE
    }

    override fun showProgress(isShow: Boolean) {
        if (isShow) {
            if (recycler_pokemon.visibility == View.VISIBLE && pokemonAdapter.itemCount > 0) {
                swipe_to_refresh.isRefreshing = true
            } else {
                progress.visibility = View.VISIBLE
                recycler_pokemon.visibility = View.GONE
                swipe_to_refresh.visibility = View.GONE
            }
            view_error.visibility = View.GONE
        } else {
            progress.visibility = View.INVISIBLE
            swipe_to_refresh.isRefreshing = false
        }
    }

    override fun showError(error: Throwable) {
        swipe_to_refresh.visibility = View.GONE
        recycler_pokemon.visibility = View.GONE
        view_error.visibility = View.VISIBLE
    }

    override fun onReloadData() {
        mainPresenter.getPokemon(POKEMON_COUNT)
    }

}
