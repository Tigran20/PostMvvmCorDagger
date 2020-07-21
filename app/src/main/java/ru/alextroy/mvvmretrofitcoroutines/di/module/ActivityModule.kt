package ru.alextroy.mvvmretrofitcoroutines.di.module

import dagger.Module
import dagger.Provides
import ru.alextroy.mvvmretrofitcoroutines.repository.PostsRepository
import javax.inject.Singleton

@Module
class ActivityModule {
    @Singleton
    @Provides
    internal fun providePostsRepository(): PostsRepository {
        return PostsRepository()
    }
}