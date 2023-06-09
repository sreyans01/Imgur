package com.assign.imgur.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.assign.imgur.ImageData
import com.assign.imgur.R
import com.assign.imgur.databinding.ItemTopImagesGridviewBinding
import com.assign.imgur.databinding.ItemTopImagesListviewBinding
import com.assign.imgur.utils.Constants
import com.assign.imgur.viewholder.GridImageViewHolder
import com.assign.imgur.viewholder.ListImageViewHolder


class ImagesAdapter(context: Context, dataList: ArrayList<ImageData>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val context: Context
    private val dataList: ArrayList<ImageData>
    private var viewType = Constants.VIEWTYPE_GRID


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        when(this.viewType) {
            Constants.VIEWTYPE_GRID -> {
                val itemTopImagesGridviewBinding: ItemTopImagesGridviewBinding =
                    DataBindingUtil.inflate(layoutInflater, R.layout.item_top_images_gridview, parent, false)
                return GridImageViewHolder(itemTopImagesGridviewBinding)
            }
            Constants.VIEWTYPE_LIST -> {
                val itemTopImagesListviewBinding: ItemTopImagesListviewBinding =
                    DataBindingUtil.inflate(layoutInflater, R.layout.item_top_images_listview, parent, false)
                return ListImageViewHolder(itemTopImagesListviewBinding)
            }
            else->{
                val itemTopImagesGridviewBinding: ItemTopImagesGridviewBinding =
                    DataBindingUtil.inflate(layoutInflater, R.layout.item_top_images_gridview, parent, false)
                return GridImageViewHolder(itemTopImagesGridviewBinding)
            }
        }
    }



    override fun getItemCount(): Int {
        return this.dataList.size
    }

    /**
     * Sets a new list of recycler view items
     * @param list - the new list to be set
     */
    fun setList(list: ArrayList<ImageData>) {
        this.dataList.clear()
        this.dataList.addAll(list)
    }

    init {
        this.dataList = dataList
        this.context = context
    }

    /**
     * Calls the OnBind from the correct viewholder class as per the viewtype
     * @param holder - viewholder object which holds the view
     * @param position - the current item position
     */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is GridImageViewHolder) {
            (holder as GridImageViewHolder).onBind(dataList[position])
        } else if (holder is ListImageViewHolder) {
            (holder as ListImageViewHolder).onBind(dataList[position])
        }
    }

    /**
     * Set viewtype as GRID or LIST of recycler view item.
     * @param viewType - 0 represents GRID view type, 1 represents LIST view type
     */
    fun setViewType(viewType: Int) {
        this.viewType = viewType
    }
}