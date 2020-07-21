package ru.alextroy.mvvmretrofitcoroutines.repository

import ru.alextroy.mvvmretrofitcoroutines.api.PostsApi
import ru.alextroy.mvvmretrofitcoroutines.di.App
import javax.inject.Inject


class PostsRepository {

    @Inject
    lateinit var retrofit: PostsApi

    init {
        App.instance.getComponent().inject(this)
    }

    private var client: PostsApi = retrofit
    suspend fun getPosts() = client.getPosts()
}