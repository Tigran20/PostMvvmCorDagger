package ru.alextroy.mvvmretrofitcoroutines.di

import android.app.Application
import ru.alextroy.mvvmretrofitcoroutines.di.component.DaggerAppComponent
import ru.alextroy.mvvmretrofitcoroutines.di.component.AppComponent

class App : Application() {

    companion object {
        lateinit var instance: App
            private set
    }

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.factory().create(this)
    }

    fun getComponent(): AppComponent = appComponent
}