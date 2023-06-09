package com.assign.imgur.viewholder

import android.content.Context
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.assign.imgur.ImageData
import com.assign.imgur.databinding.ItemTopImagesListviewBinding
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

class ListImageViewHolder(binding: ItemTopImagesListviewBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private var binding: ItemTopImagesListviewBinding
    private val context: Context? = null

    fun onBind(data: ImageData) {
        val firstImage = data.images.first()
        Picasso.get()
            .load(firstImage.link)
            .fit()
            .into(binding.image)
        val dateTime = Date(firstImage.datetime ?: 0L)
        val format = SimpleDateFormat("DD/MM/YY hh:mm aa")
        binding.datetime.setText(format.format(dateTime))
        binding.title.setText(data.title)
        if (data.imagesCount == 1L) {
            binding.totalImages.setVisibility(GONE)
            binding.tvImages.setVisibility(GONE)
        }
        else {
            binding.totalImages.setVisibility(VISIBLE)
            binding.tvImages.setVisibility(VISIBLE)
        }
        binding.totalImages.setText("1/${data.imagesCount}")
    }

    init {
        this.binding = binding as ItemTopImagesListviewBinding
        binding.lifecycleOwner = context as LifecycleOwner?
    }


}

