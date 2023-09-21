package com.example.imagesearchapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.imagesearchapp.data.model.Document
import com.example.imagesearchapp.databinding.ItemPreviewBinding

class ImageSearchAdapter : ListAdapter<Document, ImageSearchViewHolder>(ImageDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSearchViewHolder {
        return ImageSearchViewHolder(
            ItemPreviewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ImageSearchViewHolder, position: Int) {
        val document = currentList[position]
        holder.bind(document)
    }

    companion object {
        private val ImageDiffCallback = object : DiffUtil.ItemCallback<Document>(){
            override fun areContentsTheSame(oldItem: Document, newItem: Document): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Document, newItem: Document): Boolean {
                return oldItem.thumbnailUrl == newItem.thumbnailUrl
            }
        }
    }
}