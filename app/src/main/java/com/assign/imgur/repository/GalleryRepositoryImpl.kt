package com.assign.imgur.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.assign.imgur.GalleryTopWeekImages
import com.assign.imgur.interfaces.GalleryHttpInterface
import com.assign.imgur.interfaces.GalleryRepository
import com.assign.imgur.utils.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GalleryRepositoryImpl @Inject constructor(
    private val galleryHttpInterface: GalleryHttpInterface,
) : GalleryRepository {

    /**
     * Gets the top week images from gallery using the Imgur API
     * @return - Returns the gallery top week images live data wrapped by a Resource class
     */
    override fun getGalleryTopWeekImages(): LiveData<Resource<GalleryTopWeekImages>> {
        val result: MutableLiveData<Resource<GalleryTopWeekImages>> =
            MutableLiveData<Resource<GalleryTopWeekImages>>()
        galleryHttpInterface.getGalleryTopWeekImages()
            .enqueue(object : Callback<GalleryTopWeekImages> {
                override fun onResponse(
                    call: Call<GalleryTopWeekImages>,
                    response: Response<GalleryTopWeekImages>,
                ) {
                    if (response.isSuccessful()) {
                        result.setValue(Resource.Companion.success(response.body()))
                    } else {
                        result.setValue(Resource.Companion.error("Error ${
                            response.message().toString()
                        }", null))
                    }
                }

                override fun onFailure(call: Call<GalleryTopWeekImages>, t: Throwable) {
                    result.setValue(Resource.Companion.error("Error", null))
                }
            })
        return result
    }
}