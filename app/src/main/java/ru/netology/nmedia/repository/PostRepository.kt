package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import ru.netology.nmedia.dto.Post

interface PostRepository {
    fun getAll(): LiveData<List<Post>>
//    fun like()
//    fun share()

    fun likeById(id: Long)
    fun shareById(id: Long)
}