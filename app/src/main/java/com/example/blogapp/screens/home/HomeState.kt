package com.example.blogapp.screens.home

import com.example.domain.model.Blog

// holding the state of home
data class HomeState(
    var isLoading: Boolean = false,
    var data: List<Blog>? = null,
    var error: String = ""
)
