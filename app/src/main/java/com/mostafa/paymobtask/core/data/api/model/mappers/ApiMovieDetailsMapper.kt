package com.mostafa.paymobtask.core.data.api.model.mappers

import com.mostafa.paymobtask.core.data.api.model.ApiMovieDetails
import com.mostafa.paymobtask.movieDetails.domain.MovieDetails
import javax.inject.Inject

class ApiMovieDetailsMapper @Inject constructor() :
    ApiMapper<ApiMovieDetails, MovieDetails> {
    override fun mapToDomain(apiEntity: ApiMovieDetails): MovieDetails {
        return MovieDetails(
            adult = apiEntity.adult ?: false,
            id = apiEntity.id ?: 0,
            originalLanguage = apiEntity.originalLanguage.orEmpty(),
            originalTitle = apiEntity.originalTitle.orEmpty(),
            overview = apiEntity.overview.orEmpty(),
            poster = apiEntity.poster.orEmpty(),
            releaseDate = apiEntity.releaseDate.orEmpty(),
            rating = apiEntity.rating ?: 0.0,
            voteCount = apiEntity.voteCount ?: 0,
        )
    }
}