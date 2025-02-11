package com.example.api_retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter // Declare postAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview) // Make sure this matches the ID in your XML
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize the adapter with an empty list at first
        postAdapter = PostAdapter(listOf())

        // Set the adapter to RecyclerView
        recyclerView.adapter = postAdapter

        // Fetch the posts from the API
        fetchPosts()
    }

    private fun fetchPosts() {
        RetrofitInstance.api.getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful && response.body() != null) {
                    val posts = response.body()!!

                    // Update the adapter with the fetched posts
                    postAdapter = PostAdapter(posts)
                    recyclerView.adapter = postAdapter
                } else {
                    // Show an error message if response is not successful
                    Toast.makeText(this@MainActivity, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                // Handle failure and show an error message
                Toast.makeText(this@MainActivity, "Failure: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
