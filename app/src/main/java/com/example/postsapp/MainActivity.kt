package com.example.postsapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.postsapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var recyclerView:RecyclerView
   lateinit var postAppAdapter: PostAppAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        fetchPosts()
        recyclerView = binding.rvPosts
        recyclerView.layoutManager= LinearLayoutManager(this)


    }
    fun fetchPosts() {
        val apiInterface =
            ApiClient.buildApiInterface(PostsApiInterface::class.java)
        val request = apiInterface.fetchPosts()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(p0: Call<List<Post>>, p1: Response<List<Post>>) {
                if (p1.isSuccessful) {
                    val posts = p1.body()
                    posts?.let {
                        postAppAdapter = PostAppAdapter(it)
                        recyclerView.adapter = postAppAdapter

                        Toast.makeText(
                            baseContext,
                            "fetched ${posts.size} posts",
                            Toast.LENGTH_LONG
                        )
                            .show()
                    }
                }else {
                    Toast.makeText(baseContext, p1.errorBody()?.string(), Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(p0: Call<List<Post>>, p1: Throwable) {
                Toast.makeText(baseContext, p1.message, Toast.LENGTH_LONG).show()
            }


        })
    }
}























