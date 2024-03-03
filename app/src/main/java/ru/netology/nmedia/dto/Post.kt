package ru.netology.nmedia.dto

import kotlin.math.floor

data class Post(
    val id: Long,
    val author: String,
    val published: String,
    val content: String,
    val video: String? = null,
    val videoUrl: String? = null,
    val likes: Int = 0,
    val shares: Int = 0,
    val view: Int = 0,
    val likeByMe: Boolean = false,
    val shareByMe: Boolean = false
)

fun function(count: Int) =
    if (count in 1_100000..9_999999) {
        (floor(count / 100000.0) / 10).toString() + "M"
    } else if (count in 1000000..10000000|| count >= 10_000000) {
        ((count / 100000) / 10).toString() + "M"
    } else if (count in 1100..9999) {
        (floor(count / 100.0) / 10).toString() + "K"
    } else if (count in 1000 .. 10000 || count >=10000) {
        ((count / 100) / 10).toString() + "K"
    } else count




