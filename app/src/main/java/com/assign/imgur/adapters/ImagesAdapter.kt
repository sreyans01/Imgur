package com.assign.imgur.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.assign.imgur.ImageData
import com.assign.imgur.R
import com.assign.imgur.databinding.ItemTopImagesBinding
import com.assign.imgur.viewholder.ImageViewHolder


class ImagesAdapter(context: Context, dataList: ArrayList<ImageData>) :
    RecyclerView.Adapter<ImageViewHolder>() {
    private val context: Context
    private val dataList: ArrayList<ImageData>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemTopImagesBinding: ItemTopImagesBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_top_images, parent, false)
        return ImageViewHolder(itemTopImagesBinding)
    }

    override fun getItemCount(): Int {
        return this.dataList.size
    }

    fun setList(list: ArrayList<ImageData>) {
        this.dataList.clear()
        this.dataList.addAll(list)
    }

    init {
        this.dataList = dataList
        this.context = context
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        (holder as ImageViewHolder).onBind(dataList[position])
    }
}