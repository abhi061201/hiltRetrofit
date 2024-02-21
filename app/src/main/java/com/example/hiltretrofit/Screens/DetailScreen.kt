package com.example.hiltretrofit.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.hiltretrofit.BundleClass
import com.example.hiltretrofit.models.PostList
import com.example.hiltretrofit.models.PostListItem

@Composable
fun DetailScreen(index: Int) {
    val postList = BundleClass.bundle.getParcelable<PostList>("postList")
    Card(
        modifier = Modifier.padding(20.dp),
        colors = CardDefaults.cardColors(
            Color.LightGray
        )
    ) {
        Column(modifier = Modifier.padding(15.dp,)){
            Text(text = "${postList!!.postList[index].id}", style =MaterialTheme.typography.headlineMedium)
            Text(text = "${postList!!.postList[index].body}", style =MaterialTheme.typography.headlineSmall)
            Text(text = "${postList!!.postList[index].title}", style =MaterialTheme.typography.bodyMedium)
        }
    }
}