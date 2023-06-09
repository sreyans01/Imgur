package com.assign.imgur.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.assign.imgur.GalleryTopWeekImages
import com.assign.imgur.interfaces.GalleryRepository
import com.assign.imgur.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GalleryViewModel @Inject constructor(
    private val galleryRepository: GalleryRepository,
) : ViewModel() {

    /**
     * Used to get the top week gallery image data from the repository and pass it to the view.
     * @return - LiveData of the top week gallery image data wrapped by resource.
     */
    fun getGalleryTopWeekImages(): LiveData<Resource<GalleryTopWeekImages>> {
        return galleryRepository.getGalleryTopWeekImages()
    }

    init {
        getGalleryTopWeekImages()
    }

}