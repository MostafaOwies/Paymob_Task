package com.mostafa.paymobtask.core.data.api

import com.mostafa.paymobtask.core.data.api.model.ApiMovieList
import com.mostafa.paymobtask.core.utils.Constants
import retrofit2.http.Headers
import retrofit2.http.POST

interface MovieListApi {
    @POST(Constants.MOVIES_LIST)
    suspend fun getMovieList(): ApiMovieList
}