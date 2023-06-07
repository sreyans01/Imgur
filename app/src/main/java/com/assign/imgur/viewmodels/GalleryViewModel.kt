package com.assign.imgur.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.assign.imgur.GalleryTopWeekImages
import com.assign.imgur.ImageData
import com.assign.imgur.interfaces.GalleryRepository
import com.assign.imgur.repository.GalleryRepositoryImpl
import com.assign.imgur.utils.Resource

class GalleryViewModel() : ViewModel() {

    private val galleryRepository: GalleryRepository

    private var galleryTopWeekImagesMutableLiveData = MutableLiveData<Resource<GalleryTopWeekImages>>()
    val galleryTopWeekImagesLiveData = galleryTopWeekImagesMutableLiveData


    private fun getGalleryTopWeekImages() {
        galleryTopWeekImagesMutableLiveData = galleryRepository.getGalleryTopWeekImages()
    }

    init {
        galleryRepository = GalleryRepositoryImpl()
    }

}