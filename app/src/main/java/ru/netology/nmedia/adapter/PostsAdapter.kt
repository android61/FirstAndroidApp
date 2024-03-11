package ru.netology.nmedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.dto.function
import java.util.Collections.list

interface OnInteractionListener{
    fun onLike(post: Post)
    fun onRemove(post: Post)
    fun onEdit(post: Post)
    fun onShare(post: Post)
    fun onVideo(post: Post)
}
//typealias onLikeListener =(Post) -> Unit
//typealias onShareListener=(Post) -> Unit
//typealias onRemoveListener = (Post) -> Unit

class PostsAdapter(private val onInteractionListener:OnInteractionListener): ListAdapter<Post, PostViewHolder>(PostDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = ru.netology.nmedia.databinding.CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(view, onInteractionListener)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PostViewHolder(private val binding: CardPostBinding, private val onInteractionListener:OnInteractionListener) : RecyclerView.ViewHolder(binding.root){
fun bind(post: Post){
    with(binding) {

        author.text = post.author
        published.text = post.published
        content.text = post.content
        imageLike.text = function(post.likes).toString()
        imageShare.text = function(post.shares).toString()
        amtView.text = function(post.view).toString()

        imageLike.isChecked = post.likeByMe

        backgroundVideo.setOnClickListener {
            if (post.video != null) {
               onInteractionListener.onVideo(post)
            }
        }



        play.setOnClickListener{
            if (post.video != null) {
                onInteractionListener.onVideo(post)
            }
        }

        if (post.video == null) {
            binding.playVideoGroup.visibility = View.GONE
        } else {
            binding.playVideoGroup.visibility = View.VISIBLE
        }

        imageLike.setOnClickListener {
            onInteractionListener.onLike(post)

        }
        imageShare.setOnClickListener {
           onInteractionListener.onShare(post)
        }
        menu.setOnClickListener {PopupMenu(it.context, it).apply {
         inflate(R.menu.options_post)
         setOnMenuItemClickListener {item ->
             when(item.itemId){
                 R.id.remove ->{
                     onInteractionListener.onRemove(post)
                     true
                 }
                 R.id.edit ->{
                     onInteractionListener.onEdit(post)
                     true
                 }
                 else -> false
             }
         }
        }.show()
        }
    }
}
}

object PostDiffCallback: DiffUtil.ItemCallback<Post>(){
    override fun areItemsTheSame(oldItem: Post, newItem: Post) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Post, newItem: Post) = oldItem == newItem



}