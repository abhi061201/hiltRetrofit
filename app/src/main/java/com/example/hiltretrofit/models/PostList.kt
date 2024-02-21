package com.example.hiltretrofit.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class PostList (
    var postList : List<PostListItem>
):Parcelable