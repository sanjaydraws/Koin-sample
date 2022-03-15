package com.sanjayprajapat.koinsample.api.models

import androidx.annotation.Keep

@Keep
data class AllPosts (
    val allPosts:List<Posts>? = ArrayList()
)