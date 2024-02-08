package ru.netology.nmedia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.dto.function
import java.util.Collections.list


typealias onLikeListener =(Post) -> Unit
typealias onShareListener=(Post) -> Unit

class PostsAdapter(private val onLike: onLikeListener, private val onShare: onShareListener): ListAdapter<Post, PostViewHolder>(PostDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(view, onLike, onShare)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PostViewHolder(private val binding: CardPostBinding, private val onLike:onLikeListener, private val onShare:onShareListener) : RecyclerView.ViewHolder(binding.root){
fun bind(post: Post){
    with(binding) {

        author.text = post.author
        published.text = post.published
        content.text = post.content
        amtLike.text = function(post.likes).toString()
        amtShare.text = function(post.shares).toString()
        amtView.text = function(post.view).toString()

        imageLike.setImageResource(if (post.likeByMe) R.drawable.favorite_24 else R.drawable.favorite_fill0_wght400_grad0_opsz24)

        imageLike.setOnClickListener {
            onLike(post)

        }
        imageShare.setOnClickListener {
            onShare(post)
        }
    }
}
}
object PostDiffCallback: DiffUtil.ItemCallback<Post>(){
    override fun areItemsTheSame(oldItem: Post, newItem: Post) = oldItem.id == newItem.id



    override fun areContentsTheSame(oldItem: Post, newItem: Post) = oldItem == newItem



}