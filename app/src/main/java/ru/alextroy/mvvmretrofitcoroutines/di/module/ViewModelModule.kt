package ru.alextroy.mvvmretrofitcoroutines.di.module

import dagger.Module
import dagger.Provides
import ru.alextroy.mvvmretrofitcoroutines.viewmodel.PostsViewModel
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Singleton
    @Provides
    internal fun providePostsViewModel(): PostsViewModel {
        return PostsViewModel()
    }
}