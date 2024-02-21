package com.example.hiltretrofit.Repositary

import com.example.hiltretrofit.api.ApiInterface
import com.example.hiltretrofit.models.PostListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetsyRepo @Inject constructor(private val apiInterface: ApiInterface) {

    var _tweets = MutableStateFlow<List<PostListItem>>(emptyList())
    val tweets : StateFlow<List<PostListItem>>
        get() = _tweets
   suspend fun getAllTweets(){
        var response = apiInterface.getPostList()
       if(response.isSuccessful && response.body()!=null){
           _tweets.emit(response.body()!!)
       }
    }
}