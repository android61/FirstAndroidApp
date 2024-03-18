package ru.netology.nmedia.repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post

val empty = Post(
    id = 0,
    author = "",
    content = "",
    published = "",
    likeByMe = false,
    video = null,
    videoUrl = null

)
class PostViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: PostRepository = PostRepositoryFile(application)

    val data = repository.getAll()
    val edited = MutableLiveData(empty)

    fun changeContentAndSave(content: String){
        edited.value?.let {
            if (content != it.content){
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
    fun clear() {
        edited.value = empty
    }

}