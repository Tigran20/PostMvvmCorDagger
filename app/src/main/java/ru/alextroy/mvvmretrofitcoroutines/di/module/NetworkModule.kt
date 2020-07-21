package ru.alextroy.mvvmretrofitcoroutines.di.module

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.alextroy.mvvmretrofitcoroutines.api.PostsApi
import ru.alextroy.mvvmretrofitcoroutines.utils.BASE_URL
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    internal fun providePostApi(retrofit: Retrofit): PostsApi {
        return retrofit.create(PostsApi::class.java)
    }

    @Singleton
    @Provides
    internal fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }
}