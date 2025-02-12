package com.example.api_retrofit


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = users[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvtitle:TextView=view.findViewById(R.id.textViewName)
        private val tvbody:TextView=view.findViewById(R.id.textViewEmail)
        fun bind(user: User) {
            tvtitle.text = user.username
            tvbody.text = user.email
        }
    }
}
