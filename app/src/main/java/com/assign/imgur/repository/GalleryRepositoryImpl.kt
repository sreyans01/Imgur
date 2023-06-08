package com.assign.imgur.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.assign.imgur.GalleryTopWeekImages
import com.assign.imgur.interfaces.GalleryHttpInterface
import com.assign.imgur.interfaces.GalleryRepository
import com.assign.imgur.utils.AppDelegate
import com.assign.imgur.utils.Constants
import com.assign.imgur.utils.Resource
import com.assign.imgur.utils.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GalleryRepositoryImpl() : GalleryRepository {

    private val galleryHttpInterface: GalleryHttpInterface

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

    init {
        galleryHttpInterface =
            RetrofitClient.getClientWithInterceptor(AppDelegate.getInstance().clientID)
                .create(GalleryHttpInterface::class.java)
    }
}