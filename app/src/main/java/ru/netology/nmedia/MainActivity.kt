package ru.netology.nmedia

import android.content.res.Resources
import android.icu.number.Notation
import android.icu.number.NumberFormatter
import android.icu.number.Precision
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.dto.function
import kotlin.math.floor

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            published = "21 мая в 18:36",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            likes = 999,
            shares = 999,
            view = 999
        )
        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            amtLike.text = post.likes.toString()
            amtShare.text = post.shares.toString()
            amtView.text = post.view.toString()


            if (post.likeByMe){
                imageLike.setImageResource(R.drawable.favorite_24)
            }

            imageLike.setOnClickListener{
                if (post.likeByMe) post.likes -- else post.likes ++

                post.likeByMe = !post.likeByMe
                imageLike.setImageResource(if(post.likeByMe)R.drawable.favorite_24 else R.drawable.favorite_fill0_wght400_grad0_opsz24)
                amtLike.text = function(post.likes).toString()
                
            }

            if (post.shareByMe){
                imageShare.setImageResource(R.drawable.share_fill0_wght400_grad0_opsz24)
            }
            imageShare.setOnClickListener{
                if (post.shareByMe) post.shares-- else post.shares ++

                amtShare.text = function(post.shares).toString()
            }


        }
    }
}










