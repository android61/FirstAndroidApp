package ru.netology.nmedia.repository

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.repository.PostRepository
import ru.netology.nmedia.repository.PostRepositoryInMemoryImpl

val empty = Post(
    id = 0,
    author = "",
    content = "",
    published = "",
    likeByMe = false,
    video = null,
    videoUrl = null

)
class PostViewModel : ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()
    val data = repository.getAll()
    val edited = MutableLiveData(empty)

    fun changeContentAndSave(content: String){
        edited.value?.let {
            if (content != it.content ){
                repository.save(it.copy(content = content))
            }
            edited.value = empty
        }
    }


    fun likeById(id: Long) = repository.likeById(id)
    fun shareById(id: Long) = repository.shareById(id)
    fun removeById(id: Long) = repository.removebyId(id)
    fun edit(post: Post){
        edited.value = post
    }

}