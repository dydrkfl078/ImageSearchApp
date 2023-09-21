package com.example.imagesearchapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.imagesearchapp.data.model.Document
import com.example.imagesearchapp.databinding.ItemPreviewBinding

class ImageSearchViewHolder(
    private val binding: ItemPreviewBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(document: Document){
        val dateTime = if ( document.datetime.isNotEmpty()) document.datetime.substring(0,10) else ""
        val displaySitename = document.displaySitename

        itemView.apply {
            binding.itemImg.load(document.thumbnailUrl)
            binding.itemTvTitle.text = "[Image] $displaySitename"
            binding.itemTvDate.text = dateTime
        }
    }
}