package ru.alextroy.mvvmretrofitcoroutines.api

import retrofit2.http.GET
import ru.alextroy.mvvmretrofitcoroutines.model.Posts

interface PostsApi {
    @GET("posts")
    suspend fun getPosts(): Posts
}