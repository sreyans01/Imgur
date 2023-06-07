package com.assign.imgur

import com.google.gson.annotations.SerializedName


data class AdConfig (

  @SerializedName("safeFlags"         ) var safeFlags      : ArrayList<String> = arrayListOf(),
  @SerializedName("highRiskFlags"     ) var highRiskFlags   : ArrayList<String> = arrayListOf(),
  @SerializedName("unsafeFlags"       ) var unsafeFlags     : ArrayList<String> = arrayListOf(),
  @SerializedName("wallUnsafeFlags"   ) var wallUnsafeFlags : ArrayList<String> = arrayListOf(),
  @SerializedName("showsAds"          ) var showsAds        : Boolean?          = null,
  @SerializedName("showAdLevel"       ) var showAdLevel     : Int?              = null,
  @SerializedName("safe_flags"        ) var safe_flags       : ArrayList<String> = arrayListOf(),
  @SerializedName("high_risk_flags"   ) var high_riskFlags   : ArrayList<String> = arrayListOf(),
  @SerializedName("unsafe_flags"      ) var unsafe_flags     : ArrayList<String> = arrayListOf(),
  @SerializedName("wall_unsafe_flags" ) var wall_unsafe_flags : ArrayList<String> = arrayListOf(),
  @SerializedName("show_ads"          ) var show_ads         : Boolean?          = null,
  @SerializedName("show_ad_level"     ) var show_ad_level     : Int?              = null,
  @SerializedName("nsfw_score"        ) var nsfw_score       : Double?           = null

)