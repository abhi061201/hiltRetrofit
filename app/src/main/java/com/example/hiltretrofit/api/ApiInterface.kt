package com.example.hiltretrofit.api

import com.example.hiltretrofit.models.PostListItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    suspend fun getPostList():Response<List<PostListItem>>
}