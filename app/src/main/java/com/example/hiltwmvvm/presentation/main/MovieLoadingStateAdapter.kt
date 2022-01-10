package com.example.hiltwmvvm.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hiltwmvvm.databinding.LayoutLoadingStateBinding

class MovieLoadingStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<MovieLoadingStateAdapter.LoadStateViewHolder>() {

    inner class LoadStateViewHolder(private val binding: LayoutLoadingStateBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.retryBtn.setOnClickListener {
                retry.invoke()
            }
        }

        fun bind(loadState: LoadState) {
            with(binding) {
                progressbar.isVisible = loadState is LoadState.Loading
                retryBtn.isVisible = loadState !is LoadState.Loading
                errorTxt.isVisible = loadState !is LoadState.Loading
            }
        }
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        val binding =
            LayoutLoadingStateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LoadStateViewHolder(binding)
    }

}