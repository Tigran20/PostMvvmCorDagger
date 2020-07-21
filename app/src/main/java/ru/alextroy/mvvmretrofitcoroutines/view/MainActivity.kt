package ru.alextroy.mvvmretrofitcoroutines.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.post_list.*
import ru.alextroy.mvvmretrofitcoroutines.R
import ru.alextroy.mvvmretrofitcoroutines.di.App
import ru.alextroy.mvvmretrofitcoroutines.model.Posts
import ru.alextroy.mvvmretrofitcoroutines.viewmodel.PostsViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: PostsViewModel

    private lateinit var adapter: PostsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.post_list)

        App.instance.getComponent().inject(this)
        initAdapter()
        showData()
    }

    private fun initAdapter() {
        adapter = PostsAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
    }

    private fun showData() {
        viewModel.firstTodo.observe(this, Observer {
            adapter.setPosts(it)
        })
    }
}