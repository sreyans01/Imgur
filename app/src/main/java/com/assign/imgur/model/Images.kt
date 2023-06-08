package com.assign.imgur

import com.google.gson.annotations.SerializedName


data class Images (

  @SerializedName("id"             ) var id            : String?           = null,
  @SerializedName("title"          ) var title         : String?           = null,
  @SerializedName("description"    ) var description   : String?           = null,
  @SerializedName("datetime"       ) var datetime      : Long?              = null,
  @SerializedName("type"           ) var type          : String?           = null,
  @SerializedName("animated"       ) var animated      : Boolean?          = null,
  @SerializedName("width"          ) var width         : Long?              = null,
  @SerializedName("height"         ) var height        : Long?              = null,
  @SerializedName("size"           ) var size          : Long?              = null,
  @SerializedName("views"          ) var views         : Long?              = null,
  @SerializedName("bandwidth"      ) var bandwidth     : Long?              = null,
  @SerializedName("vote"           ) var vote          : String?           = null,
  @SerializedName("favorite"       ) var favorite      : Boolean?          = null,
  @SerializedName("nsfw"           ) var nsfw          : String?           = null,
  @SerializedName("section"        ) var section       : String?           = null,
  @SerializedName("account_url"    ) var accountUrl    : String?           = null,
  @SerializedName("account_id"     ) var accountId     : String?           = null,
  @SerializedName("is_ad"          ) var isAd          : Boolean?          = null,
  @SerializedName("in_most_viral"  ) var inMostViral   : Boolean?          = null,
  @SerializedName("has_sound"      ) var hasSound      : Boolean?          = null,
  @SerializedName("tags"           ) var tags          : ArrayList<String> = arrayListOf(),
  @SerializedName("ad_type"        ) var adType        : Int?              = null,
  @SerializedName("ad_url"         ) var adUrl         : String?           = null,
  @SerializedName("edited"         ) var edited        : String?           = null,
  @SerializedName("in_gallery"     ) var inGallery     : Boolean?          = null,
  @SerializedName("link"           ) var link          : String?           = null,
  @SerializedName("comment_count"  ) var commentCount  : String?           = null,
  @SerializedName("favorite_count" ) var favoriteCount : String?           = null,
  @SerializedName("ups"            ) var ups           : String?           = null,
  @SerializedName("downs"          ) var downs         : String?           = null,
  @SerializedName("points"         ) var points        : String?           = null,
  @SerializedName("score"          ) var score         : String?           = null

)