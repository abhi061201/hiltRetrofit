package com.example.hiltretrofit.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hiltretrofit.Repositary.TweetsyRepo
import com.example.hiltretrofit.models.PostListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class tweetViewModel @Inject constructor(private  val repositary: TweetsyRepo) : ViewModel() {

    val tweets: StateFlow<List<PostListItem>>
        get() = repositary._tweets

    init {
        viewModelScope.launch {
            repositary.getAllTweets()
        }
    }

}