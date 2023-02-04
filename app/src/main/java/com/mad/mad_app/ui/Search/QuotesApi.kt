package com.mad.mad_app.ui.Search

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface QuotesApi {
    @GET("quotes")
    fun getQuotes() : Call<QuoteList>
}