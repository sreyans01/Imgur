package com.assign.imgur.viewholder

import android.content.Context
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.assign.imgur.ImageData
import com.assign.imgur.databinding.ItemTopImagesBinding
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

class ImageViewHolder(binding: ItemTopImagesBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private var binding: ItemTopImagesBinding
    private val context: Context? = null

    fun onBind(data: ImageData) {
        val firstImage = data.images.first()
        Picasso.get()
            .load(firstImage.link)
            .fit()
            .into(binding.image)
        val dateTime = Date(firstImage.datetime ?: 0L)
        val format = SimpleDateFormat("dd/mm/yy hh:mm aa")
        binding.datetime.setText(format.format(dateTime))
        binding.title.setText(data.title)
        if (data.imagesCount == 1L)
            binding.fractionalCount.setVisibility(GONE)
        else
            binding.fractionalCount.setVisibility(VISIBLE)
        binding.fractionalCount.setText("1/${data.imagesCount}")
    }

    init {
        this.binding = binding as ItemTopImagesBinding
        binding.lifecycleOwner = context as LifecycleOwner?
    }


}

