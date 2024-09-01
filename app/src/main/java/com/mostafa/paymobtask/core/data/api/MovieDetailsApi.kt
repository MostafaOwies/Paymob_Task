package com.mostafa.paymobtask.core.data.api

import com.mostafa.paymobtask.core.data.api.model.ApiMovieDetails
import com.mostafa.paymobtask.core.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsApi {
    @GET(Constants.MOVIE_DETAILS)
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: String,
        @Query("api_key") apiKey: String,
    ): ApiMovieDetails
}