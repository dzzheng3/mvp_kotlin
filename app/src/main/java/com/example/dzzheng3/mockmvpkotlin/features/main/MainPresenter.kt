package com.example.dzzheng3.mockmvpkotlin.features.main

import com.example.dzzheng3.mockmvpkotlin.data.DataManager
import com.example.dzzheng3.mockmvpkotlin.features.base.BasePresenter
import com.example.dzzheng3.mockmvpkotlin.injection.ConfigPersistent
import com.zheng.util.rx.scheduler.SchedulerUtils
import javax.inject.Inject

@ConfigPersistent
class MainPresenter @Inject constructor(val dataManager: DataManager) : BasePresenter<MainMvpView>() {
    override fun attachView(view: MainMvpView) {
        super.attachView(view)
    }

    fun getPokemon(limit: Int) {
        checkViewAttached()
        mvpView?.showProgress(true)
        dataManager.getPokemonList(limit).compose(SchedulerUtils.ioToMain<List<String>>())
                .subscribe({pokemons->
                    mvpView?.showProgress(false)
                    mvpView?.showPokeman(pokemons)
                },{throwable ->
                    mvpView?.showProgress(true)
                    mvpView?.showError(throwable)
                })
    }
}