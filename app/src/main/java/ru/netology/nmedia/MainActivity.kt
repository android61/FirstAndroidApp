package ru.netology.nmedia

import android.content.res.Resources
import android.icu.number.Notation
import android.icu.number.NumberFormatter
import android.icu.number.Precision
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.dto.function
import ru.netology.nmedia.repository.PostViewModel
import kotlin.math.floor

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                amtLike.text = function(post.likes).toString()
                amtShare.text = function(post.shares).toString()
                amtView.text = post.view.toString()


                imageLike.setImageResource(if(post.likeByMe)R.drawable.favorite_24 else R.drawable.favorite_fill0_wght400_grad0_opsz24)


            }
        }
        binding.imageLike.setOnClickListener {
            viewModel.like()
        }
        binding.imageShare.setOnClickListener{
            viewModel.share()
        }


    }
}










