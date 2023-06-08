package com.assign.imgur.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.assign.imgur.GalleryTopWeekImages
import com.assign.imgur.interfaces.GalleryRepository
import com.assign.imgur.repository.GalleryRepositoryImpl
import com.assign.imgur.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val galleryRepository: GalleryRepository
) : ViewModel() {

    fun getGalleryTopWeekImages(): LiveData<Resource<GalleryTopWeekImages>> {
        return galleryRepository.getGalleryTopWeekImages()
    }

    init {
        getGalleryTopWeekImages()
    }

}