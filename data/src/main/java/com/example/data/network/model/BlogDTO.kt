package com.example.data.network.model

data class BlogDTO(
    val id: String?,
    val image: String?,
    val likes: Int?,
    val ownerDTO: OwnerDTO?,
    val publishDate: String?,
    val tags: List<String>?,
    val text: String?
)