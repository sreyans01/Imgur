package com.assign.imgur

import com.google.gson.annotations.SerializedName


data class GalleryTopWeekImages (

  @SerializedName("data"    ) var data    : ArrayList<ImageData> = arrayListOf(),
  @SerializedName("success" ) var success : Boolean?        = null,
  @SerializedName("status"  ) var status  : Int?            = null

)