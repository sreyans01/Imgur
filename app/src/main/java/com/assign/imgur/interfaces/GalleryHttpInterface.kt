package com.assign.imgur.interfaces

import com.assign.imgur.GalleryTopWeekImages
import retrofit2.Call
import retrofit2.http.GET

interface GalleryHttpInterface {

    @GET("gallery/top/week")
    fun getGalleryTopWeekImages(): Call<GalleryTopWeekImages>
}