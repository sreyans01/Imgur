package com.assign.imgur.interfaces

import androidx.lifecycle.LiveData
import com.assign.imgur.GalleryTopWeekImages
import com.assign.imgur.utils.Resource


interface GalleryRepository {
    fun getGalleryTopWeekImages(): LiveData<Resource<GalleryTopWeekImages>>
}