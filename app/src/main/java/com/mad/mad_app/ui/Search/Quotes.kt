package com.mad.mad_app.ui.Search

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("_id")
    val _id : String ,
    @SerializedName("author")
    val author : String ,
    @SerializedName("content")
    val content : String ,
    @SerializedName("tags")
    val tags : List<String> ,
    @SerializedName("authorSlug")
    val authorSlug : String ,
    @SerializedName("length")
    val length : Int ,
    @SerializedName("dateAdded")
    val dateAdded : String ,
    @SerializedName("dateModified")
    val dateModified : String,
)
