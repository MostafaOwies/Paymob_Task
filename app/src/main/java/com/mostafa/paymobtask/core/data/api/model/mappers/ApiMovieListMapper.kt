package com.mostafa.paymobtask.core.data.api.model.mappers

import com.mostafa.paymobtask.core.data.api.model.ApiMovieList
import javax.inject.Inject

class ApiMovieListMapper @Inject constructor() :
    ApiMapper<ApiMovieList, MovieList> {
    override fun mapToDomain(apiEntity: ApiMovieList): MovieList {
        TODO("Not yet implemented")
    }
}