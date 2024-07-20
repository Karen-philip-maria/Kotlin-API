package com.example.postsapp
import retrofit2.http.GET

interface PostsApiInterface {
    @GET("/posts")
    fun fetchPosts(): retrofit2.Call<List<Post>>
}