package com.example.hiltwmvvm.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.hiltwmvvm.R
import com.example.hiltwmvvm.data.model.MovieData
import com.example.hiltwmvvm.databinding.ItemMovieBinding
import com.example.hiltwmvvm.utils.Constants

class MovieAdapter : PagingDataAdapter<MovieData, MovieAdapter.MovieViewHolder>(
    COMPARATOR
) {

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<MovieData>() {
            override fun areItemsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieData, newItem: MovieData): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieData) {
            with(binding) {
                Glide.with(itemView)
                    .load("${Constants.IMAGE_BASE_URL}${movie.backdrop_path}")
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_broken_image)
                    .into(movieImage)

                titleTxt.text = movie.title
            }
        }
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }
}