package com.assign.imgur

import com.google.gson.annotations.SerializedName


data class ImageData (

  @SerializedName("id"             ) var id            : String?         = null,
  @SerializedName("title"          ) var title         : String?         = null,
  @SerializedName("description"    ) var description   : String?         = null,
  @SerializedName("datetime"       ) var datetime      : Int?            = null,
  @SerializedName("type"           ) var type          : String?         = null,
  @SerializedName("animated"       ) var animated      : Boolean?        = null,
  @SerializedName("width"          ) var width         : Int?            = null,
  @SerializedName("height"         ) var height        : Int?            = null,
  @SerializedName("size"           ) var size          : Int?            = null,
  @SerializedName("views"          ) var views         : Int?            = null,
  @SerializedName("bandwidth"      ) var bandwidth     : Int?            = null,
  @SerializedName("vote"           ) var vote          : String?         = null,
  @SerializedName("favorite"       ) var favorite      : Boolean?        = null,
  @SerializedName("nsfw"           ) var nsfw          : Boolean?        = null,
  @SerializedName("section"        ) var section       : String?         = null,
  @SerializedName("account_url"    ) var accountUrl    : String?         = null,
  @SerializedName("account_id"     ) var accountId     : Int?            = null,
  @SerializedName("is_ad"          ) var isAd          : Boolean?        = null,
  @SerializedName("in_most_viral"  ) var inMostViral   : Boolean?        = null,
  @SerializedName("has_sound"      ) var hasSound      : Boolean?        = null,
  @SerializedName("tags"           ) var tags          : ArrayList<Tags> = arrayListOf(),
  @SerializedName("ad_type"        ) var adType        : Int?            = null,
  @SerializedName("ad_url"         ) var adUrl         : String?         = null,
  @SerializedName("edited"         ) var edited        : Int?            = null,
  @SerializedName("in_gallery"     ) var inGallery     : Boolean?        = null,
  @SerializedName("topic"          ) var topic         : String?         = null,
  @SerializedName("topic_id"       ) var topicId       : Int?            = null,
  @SerializedName("link"           ) var link          : String?         = null,
  @SerializedName("mp4"            ) var mp4           : String?         = null,
  @SerializedName("gifv"           ) var gifv          : String?         = null,
  @SerializedName("hls"            ) var hls           : String?         = null,
  @SerializedName("mp4_size"       ) var mp4Size       : Int?            = null,
  @SerializedName("looping"        ) var looping       : Boolean?        = null,
  @SerializedName("processing"     ) var processing    : Processing?     = Processing(),
  @SerializedName("ad_config"      ) var adConfig      : AdConfig?       = AdConfig(),
  @SerializedName("comment_count"  ) var commentCount  : Int?            = null,
  @SerializedName("favorite_count" ) var favoriteCount : Int?            = null,
  @SerializedName("ups"            ) var ups           : Int?            = null,
  @SerializedName("downs"          ) var downs         : Int?            = null,
  @SerializedName("points"         ) var points        : Int?            = null,
  @SerializedName("score"          ) var score         : Int?            = null,
  @SerializedName("is_album"       ) var isAlbum       : Boolean?        = null

)