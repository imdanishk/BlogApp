package com.example.blogapp.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.Resource
import com.example.domain.usecases.GetBlogsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getBlogsUseCase: GetBlogsUseCase
) : ViewModel() {

    private val _blogs = mutableStateOf<HomeState>(HomeState())
    // can observe this blog in our UI, but can't change as it's immutable
    val blogs: State<HomeState> = _blogs

    init {
        getBlogs()
    }

    fun getBlogs() {
        getBlogsUseCase().onEach {
            when (it) {
                is Resource.Loading -> {
                    _blogs.value = HomeState(isLoading = true)
                }
                is Resource.Success -> {
                    _blogs.value = HomeState(data = it.data)
                }
                is Resource.Error -> {
                    _blogs.value = HomeState(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }
}