package ru.alextroy.mvvmretrofitcoroutines.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import ru.alextroy.mvvmretrofitcoroutines.di.App
import ru.alextroy.mvvmretrofitcoroutines.model.Posts
import ru.alextroy.mvvmretrofitcoroutines.repository.PostsRepository
import javax.inject.Inject

class PostsViewModel : ViewModel() {

    @Inject
    lateinit var repository: PostsRepository

    init {
        App.instance.getComponent().inject(this)
    }

    val firstTodo: LiveData<Posts> = liveData(Dispatchers.IO) {
        val postsData = repository.getPosts()
        emit(postsData)
    }
}