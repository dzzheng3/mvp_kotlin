package com.example.dzzheng3.mockmvpkotlin.features.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import com.example.dzzheng3.mockmvpkotlin.MyAppliction
import com.example.dzzheng3.mockmvpkotlin.injection.component.ActivityComponent
import com.example.dzzheng3.mockmvpkotlin.injection.component.AppComponent
import com.example.dzzheng3.mockmvpkotlin.injection.component.DaggerConfigPersistentComponent
import com.example.dzzheng3.mockmvpkotlin.injection.module.ActivityModule

abstract class BaseActivity : AppCompatActivity() {
    abstract val layout: Int
    private var activityComponent: ActivityComponent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        ButterKnife.bind(this)
        val configPersistentComponent = DaggerConfigPersistentComponent.builder().appComponent(MyAppliction[this].component).build()
        activityComponent = configPersistentComponent.activityComponent(ActivityModule(this))
        activityComponent?.inject(this)
    }

    fun activityComponent(): ActivityComponent {
        return activityComponent as ActivityComponent
    }
}