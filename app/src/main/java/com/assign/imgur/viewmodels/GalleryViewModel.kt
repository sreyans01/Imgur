package com.assign.imgur.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.assign.imgur.GalleryTopWeekImages
import com.assign.imgur.interfaces.GalleryRepository
import com.assign.imgur.repository.GalleryRepositoryImpl
import com.assign.imgur.utils.Resource

class GalleryViewModel() : ViewModel() {

    private val galleryRepository: GalleryRepository

    fun getGalleryTopWeekImages(): LiveData<Resource<GalleryTopWeekImages>> {
        return galleryRepository.getGalleryTopWeekImages()
    }

    init {
        galleryRepository = GalleryRepositoryImpl()
    }

}