package ru.alextroy.mvvmretrofitcoroutines.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.alextroy.mvvmretrofitcoroutines.R
import ru.alextroy.mvvmretrofitcoroutines.model.PostItem

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {
    private var posts: List<PostItem> = ArrayList()

    inner class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val body: TextView = itemView.findViewById(R.id.body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return PostsViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val postItem = posts[position]
        holder.title.text = postItem.title
        holder.body.text = postItem.body
    }

    override fun getItemCount() = posts.size

    internal fun setPosts(posts: List<PostItem>) {
        this.posts = posts
        notifyDataSetChanged()
    }
}