package com.example.api_retrofit


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class PostAdapter(private val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvtitle:TextView=view.findViewById(R.id.tv_Title)
        private val tvbody:TextView=view.findViewById(R.id.tv_Body)
        fun bind(post: Post) {
            tvtitle.text = post.title
            tvbody.text = post.body
        }
    }
}
