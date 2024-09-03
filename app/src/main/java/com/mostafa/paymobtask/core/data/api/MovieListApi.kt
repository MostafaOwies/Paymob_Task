package com.mostafa.paymobtask.core.data.api

import com.mostafa.paymobtask.core.data.api.model.ApiMovieList
import com.mostafa.paymobtask.core.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieListApi {
    @GET(Constants.MOVIES_LIST)
    suspend fun getMovieList(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
    ): ApiMovieList
}