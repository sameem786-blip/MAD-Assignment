package com.mad.mad_app.ui.Search

import com.google.gson.annotations.SerializedName

data class QuoteList(
    @SerializedName("count")
    val count : Int ,
    @SerializedName("totalCount")
    val totalCount : Int ,
    @SerializedName("page")
    val page : Int ,
    @SerializedName("totalPages")
    val totalPages : Int,
    @SerializedName("lastItemIndex")
    val lastItemIndex : Int,
    @SerializedName("results")
    val results : List<Result>
)
