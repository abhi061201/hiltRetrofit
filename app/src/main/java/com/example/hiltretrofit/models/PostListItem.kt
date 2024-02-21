package com.example.hiltretrofit.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
 class PostListItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
):Parcelable

//
//data class PostListItem(
//    val body: String,
//    val id: Int,
//    val title: String,
//    val userId: Int
//)