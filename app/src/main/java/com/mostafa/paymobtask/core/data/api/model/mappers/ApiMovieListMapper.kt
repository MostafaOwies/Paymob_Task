package com.mostafa.paymobtask.core.data.api.model.mappers

import com.mostafa.paymobtask.core.data.api.model.ApiMovieList
import com.mostafa.paymobtask.core.data.api.model.ApiMovieListResult
import com.mostafa.paymobtask.movieList.domain.MovieList
import com.mostafa.paymobtask.movieList.domain.MovieListResult
import javax.inject.Inject

class ApiMovieListMapper @Inject constructor() :
    ApiMapper<ApiMovieList, MovieList> {
    override fun mapToDomain(apiEntity: ApiMovieList): MovieList {
        val (page, results, totalPages, totalResults) = apiEntity
        return MovieList(
            page = page ?: 0,
            totalPages = totalPages ?: 0,
            totalResults = totalResults ?: 0,
            results = results.map {
                mapMovieList(it)
            }
        )
    }

    private fun mapMovieList(apiMovieListResult: ApiMovieListResult): MovieListResult {
        return MovieListResult(
            adult = apiMovieListResult.adult ?: false,
            id = apiMovieListResult.id ?: 0,
            originalLanguage = apiMovieListResult.originalLanguage.orEmpty(),
            originalTitle = apiMovieListResult.originalTitle.orEmpty(),
            overview = apiMovieListResult.overview.orEmpty(),
            poster = apiMovieListResult.poster.orEmpty(),
            releaseDate = apiMovieListResult.releaseDate.orEmpty(),
            rating = apiMovieListResult.rating ?: 0.0,
            voteCount = apiMovieListResult.voteCount ?: 0,
        )
    }
}