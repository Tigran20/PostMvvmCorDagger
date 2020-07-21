package ru.alextroy.mvvmretrofitcoroutines.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.alextroy.mvvmretrofitcoroutines.di.module.ActivityModule
import ru.alextroy.mvvmretrofitcoroutines.di.module.NetworkModule
import ru.alextroy.mvvmretrofitcoroutines.di.module.ViewModelModule
import ru.alextroy.mvvmretrofitcoroutines.repository.PostsRepository
import ru.alextroy.mvvmretrofitcoroutines.view.MainActivity
import ru.alextroy.mvvmretrofitcoroutines.viewmodel.PostsViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ActivityModule::class, ViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(postsRepository: PostsRepository)
    fun inject(postsViewModel: PostsViewModel)
    fun inject(mainActivity: MainActivity)
}