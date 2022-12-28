package com.example.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


// Objects are not going to be stored in Room DB because Room only stores
// primitive data types. Here, we've "Owner" which is an object and also a
// list of String which isn't a primitive data type. So, we're going to create
// a "type converter" for that.
@Entity
data class Blog(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val image: String,
    val likes: Int,
    val owner: Owner,
    val publishDate: String,
    val tags: List<String>,
    val text: String
)
