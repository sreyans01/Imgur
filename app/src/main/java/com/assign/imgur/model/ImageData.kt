package com.assign.imgur

import com.google.gson.annotations.SerializedName


data class ImageData (

  @SerializedName("id"                ) var id              : String?           = null,
  @SerializedName("title"             ) var title           : String?           = null,
  @SerializedName("description"       ) var description     : String?           = null,
  @SerializedName("datetime"          ) var datetime        : Long?              = null,
  @SerializedName("cover"             ) var cover           : String?           = null,
  @SerializedName("cover_width"       ) var coverWidth      : Long?              = null,
  @SerializedName("cover_height"      ) var coverHeight     : Long?              = null,
  @SerializedName("account_url"       ) var accountUrl      : String?           = null,
  @SerializedName("account_id"        ) var accountId       : Long?              = null,
  @SerializedName("privacy"           ) var privacy         : String?           = null,
  @SerializedName("layout"            ) var layout          : String?           = null,
  @SerializedName("views"             ) var views           : Long?              = null,
  @SerializedName("link"              ) var link            : String?           = null,
  @SerializedName("ups"               ) var ups             : Long?              = null,
  @SerializedName("downs"             ) var downs           : Long?              = null,
  @SerializedName("points"            ) var points          : Long?              = null,
  @SerializedName("score"             ) var score           : Long?              = null,
  @SerializedName("is_album"          ) var isAlbum         : Boolean?          = null,
  @SerializedName("vote"              ) var vote            : String?           = null,
  @SerializedName("favorite"          ) var favorite        : Boolean?          = null,
  @SerializedName("nsfw"              ) var nsfw            : Boolean?          = null,
  @SerializedName("section"           ) var section         : String?           = null,
  @SerializedName("comment_count"     ) var commentCount    : Long?              = null,
  @SerializedName("favorite_count"    ) var favoriteCount   : Long?              = null,
  @SerializedName("topic"             ) var topic           : String?           = null,
  @SerializedName("topic_id"          ) var topicId         : String?           = null,
  @SerializedName("images_count"      ) var imagesCount     : Long?              = 0,
  @SerializedName("in_gallery"        ) var inGallery       : Boolean?          = null,
  @SerializedName("is_ad"             ) var isAd            : Boolean?          = null,
  @SerializedName("tags"              ) var tags            : ArrayList<Tags>   = arrayListOf(),
  @SerializedName("ad_type"           ) var adType          : Int?              = null,
  @SerializedName("ad_url"            ) var adUrl           : String?           = null,
  @SerializedName("in_most_viral"     ) var inMostViral     : Boolean?          = null,
  @SerializedName("include_album_ads" ) var includeAlbumAds : Boolean?          = null,
  @SerializedName("images"            ) var images          : ArrayList<Images> = arrayListOf(),
  @SerializedName("ad_config"         ) var adConfig        : AdConfig?         = AdConfig()

)