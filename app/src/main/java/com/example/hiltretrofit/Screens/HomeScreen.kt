package com.example.hiltretrofit.Screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hiltretrofit.BundleClass
import com.example.hiltretrofit.models.PostList
import com.example.hiltretrofit.models.PostListItem
import com.example.hiltretrofit.viewModels.tweetViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(onclick: (Int) -> Unit) {

    val tweetViewModel: tweetViewModel = hiltViewModel()
    val tweets: State<List<PostListItem>> = tweetViewModel.tweets.collectAsState()

    val postList = PostList(
        tweets.value
    )
    BundleClass.bundle.putParcelable("postList", postList)
    if (tweets.value.isNotEmpty()) {
        Column() {
            TopAppBar(title = { Text("top bar") }, colors = TopAppBarDefaults.topAppBarColors(
                Color.Cyan
            ))

            LazyColumn() {
                itemsIndexed(tweets.value) { index, item ->
                    if(index==0) Spacer(modifier = Modifier.height(5.dp))
                    HomeItem(postListItem = item, { index ->
                        onclick(index)
                    }, index = index)
                   if(index==tweets.value.lastIndex) Spacer(modifier = Modifier.height(10.dp))
                }
            }


        }


    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator(
                color = Color.Black
            )
        }
    }
}

@Composable
fun HomeItem(postListItem: PostListItem, onclick: (Int) -> Unit, index: Int) {
    Card(
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 15.dp)
            .clickable {
                onclick(index)
            },
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(
            Color.LightGray
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Column(horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Top) {

                Text(
                    text = postListItem.id.toString(),
                    style = MaterialTheme.typography.headlineMedium
                )
                Text(text = postListItem.title, style = MaterialTheme.typography.bodyMedium)

            }
        }
    }
}