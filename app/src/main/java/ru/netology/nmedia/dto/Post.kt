package ru.netology.nmedia.dto

import kotlin.math.floor

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

fun function(count: Int) =
    if (count in 1_100000..9_999999) {
        (floor(count / 100000.0) / 10).toString() + "M"
    } else if (count == 1000000 || count >= 10_000000) {
        ((count / 100000) / 10).toString() + "M"
    } else if (count in 1100..9999) {
        (floor(count / 100.0) / 10).toString() + "K"
    } else if (count == 1000 || count >= 10000) {
        ((count / 100) / 10).toString() + "K"
    } else count




