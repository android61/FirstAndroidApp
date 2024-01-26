package ru.netology.nmedia.dto

data class Post(
    val id: Int,
    val author: String,
    val published: String,
    val content: String,
    var likes: Int = 0,
    var shares: Int = 0,
    var view: Int = 0,
    var likeByMe: Boolean = false,
    var shareByMe: Boolean = false
)




