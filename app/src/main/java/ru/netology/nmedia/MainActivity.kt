package ru.netology.nmedia

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.adapter.OnInteractionListener
import ru.netology.nmedia.adapter.PostsAdapter
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.repository.PostViewModel
import ru.netology.nmedia.repository.empty
import ru.netology.nmedia.util.AndroidUtils
import ru.netology.nmedia.util.AndroidUtils.focusAndShowKeyboard
import kotlin.math.floor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        val adapter = PostsAdapter(object : OnInteractionListener {
            override fun onLike(post: Post) {
                viewModel.likeById(post.id)
            }

            override fun onRemove(post: Post) {
                viewModel.removeById(post.id)
            }

            override fun onEdit(post: Post) {
                viewModel.edit(post)
                binding.edit.setText(post.content)
            }

            override fun onShare(post: Post) {
                viewModel.shareById(post.id)
            }
        })
        binding.list.adapter = adapter

        viewModel.data.observe(this) { posts ->
            val newPost = adapter.currentList.size < posts.size && adapter.currentList.size > 0
            adapter.submitList(posts) {
                if (newPost) {
                    binding.list.smoothScrollToPosition(0)
                }
            }
            viewModel.edited.observe(this) { post ->
                if (post.id != 0L) {
                    binding.group.visibility = View.VISIBLE
                    binding.edit.setText(post.content)
                    binding.edit.focusAndShowKeyboard()
                } else {
                    binding.group.visibility = View.INVISIBLE
                }
            }
            binding.save.setOnClickListener {
                val text = binding.edit.text.toString().trim()
                if (text.isEmpty()) {
                    Toast.makeText(this, "Ошибка. Пустой контент", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }


                viewModel.changeContentAndSave(text)

                binding.edit.setText("")
                binding.edit.clearFocus()
                AndroidUtils.hideKeyboard(it)
            }
            binding.cancelButton.setOnClickListener {
                viewModel.edit(empty)
                binding.edit.setText("")
            }
        }
    }
}











